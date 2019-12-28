import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class IntcodeTest {
    Intcode intcode;

    public IntcodeTest(){
        intcode = new Intcode();
    }

    @Test
    public void test1(){
        int[] expectedResult = new int[]{2,0,0,0,99};
        intcode.run(new int[] {1,0,0,0,99});
        int[] result = intcode.getProg();

        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void test2(){
        int[] expectedResult = new int[]{30,1,1,4,2,5,6,0,99};
        intcode.run(new int[] {1,1,1,4,99,5,6,0,99});
        int[] result = intcode.getProg();

        Assert.assertArrayEquals(expectedResult, result);
    }
}
