import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class FelineTest {
    private Feline feline = new Feline();

    @Test
    public void eatFelineMeatTest() throws Exception {
        Feline felineSpy = Mockito.spy(feline);
        felineSpy.eatMeat();
        Mockito.verify(felineSpy, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFelineFamilyTest(){
        Assert.assertEquals("Семейство отличается от семейства Кошачьих", "Кошачьи", feline.getFamily());
    }

    @Test
    public void getFelineKittensWithNoArgumentTest(){
        Assert.assertEquals("Количество котят должно ровняться 1", 1, feline.getKittens());
    }

    @Test
    public void getFelineKittensWithArgumentTest(){
        Assert.assertEquals("Количество котят не соответстсвует действительности", 2,  feline.getKittens(2));
    }

    @Test
    public void getFelineKittensCallMethodTest(){
        MockitoAnnotations.openMocks(this);
        Feline felineMock = Mockito.mock(Feline.class);
        felineMock.getKittens(2);
        Mockito.verify(felineMock).getKittens(Mockito.anyInt());
    }
}
