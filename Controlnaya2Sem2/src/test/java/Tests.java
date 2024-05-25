import org.junit.Assert;
import org.junit.Test;
import ru.itis.inf301.MyThread;

public class Tests {

    @Test
    public void checkOne() {
        Assert.assertEquals(MyThread.countEven(new byte[] {124, 22, 54, 36, 7, 1}), 5+3+4+2+3+1);
    }
    @Test
    public void checkTwo() {
        Assert.assertEquals(MyThread.countEven(new byte[] {1, 77, 98, 11, 2}), 1+4+3+3+1);
    }
    @Test
    public void checkThree() {
        Assert.assertEquals(MyThread.countEven(new byte[] {1, 12, 13, 1, 1}), 8);
    }
    @Test
    public void checkFour() {
        Assert.assertEquals(MyThread.countEven(new byte[] {33, 44, 55, 66}), 12);
    }
}
