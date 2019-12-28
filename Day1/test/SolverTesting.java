import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class SolverTesting {
    Solver solver;

    public SolverTesting(){
        this.solver = new Solver();
    }

    @Test
    public void moduleWithMass100756Requires50346Fuel(){
        //numbers from description of assignment
        int expectedResult = 50346;
        int result = solver.getFuelRequirementForModule(100756, 0);

        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void fuelForWeightsTwelveFourteenAndTwentyIsCorrect(){
        //fuel for a) 12: 12/3-2 = 2 b) 14: 14/3-2 = 2 c) 20: 20/3-2 = 4
        //in total: 8

        Solver solver = new Solver();
        List<Integer> masses = Arrays.asList(12, 14, 20);
        int result = solver.getTotalFuelRequirement(masses);
        int expectedResult = 8;

        Assert.assertEquals(expectedResult, result);

    }
}
