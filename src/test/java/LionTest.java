import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private final boolean hasMane;

    public LionTest(String sex, Boolean hasMane){
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checkManeForLionSex() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals("Наличие гривы определено неверно", hasMane, lion.doesHaveMane());
    }

    @Test
    public void getLionKittensTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, feline);
        Mockito.when(lion.getKittens()).thenReturn(1);
        Assert.assertEquals("Количество котят должно ровняться 1", 1, lion.getKittens());
    }

    @Test
    public void getLionFoodTest() throws Exception {
        Feline feline = new Feline();
        Feline felineSpy = Mockito.spy(feline);
        Lion lion = new Lion(sex, felineSpy);
        lion.getFood();
        Mockito.verify(felineSpy, Mockito.times(1)).getFood("Хищник");
    }
}
