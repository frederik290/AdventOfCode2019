import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CrossedWiresTest {


    @Test
    public void testMinimizeSignalDelay1() {
        String[] wirePath2 = new String[] {"U7","R6","D4","L4"};
        String[] wirePath1 = new String[] {"R8","U5","L5","D3"};

        CrossedWires cw = new CrossedWires();
        int expectedResult = 30; //steps
        int result = cw.getClosestIntersectionDistanceByMinimumSteps(wirePath1, wirePath2);
        Assert.assertEquals(expectedResult, result);
    }
    @Test
    public void testMinimizeSignalDelay2() {
        String[] w1 = new String[] {"R75","D30","R83","U83","L12","D49","R71","U7","L72"};
        String[] w2 = new String[] {"U62","R66","U55","R34","D71","R55","D58","R83"};

        CrossedWires cw = new CrossedWires();
        int expectedResult = 610;
        int result = cw.getClosestIntersectionDistanceByMinimumSteps(w1, w2);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testManhattanDistance1() {
        String[] wirePath2 = new String[] {"U7","R6","D4","L4"};
        String[] wirePath1 = new String[] {"R8","U5","L5","D3"};

        CrossedWires cw = new CrossedWires();
        int expectedResult = 6;
        int result = cw.getClosestIntersectionDistanceByManhattanDistance(wirePath1, wirePath2);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testManhattanDistance2() {
        String[] w1 = new String[] {"R75","D30","R83","U83","L12","D49","R71","U7","L72"};
        String[] w2 = new String[] {"U62","R66","U55","R34","D71","R55","D58","R83"};

        CrossedWires cw = new CrossedWires();
        int expectedResult = 159;
        int result = cw.getClosestIntersectionDistanceByManhattanDistance(w1, w2);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testCreateWire() {
        CrossedWires cw = new CrossedWires();

        String[] wirePath1 = new String[] {"R8","U5","L5","D3"};
        ArrayList<Coordinate> wire1 = cw.createWire(wirePath1);

        System.out.println("---");

        String[] wirePath2 = new String[] {"U7","R6","D4","L4"};
        ArrayList<Coordinate> wire2 = cw.createWire(wirePath2);

    }
}
