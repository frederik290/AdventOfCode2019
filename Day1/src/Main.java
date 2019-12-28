import java.util.List;


public class Main {
    public static void main(String[] args) {
        Solver solver = new Solver();
//        List<Integer> masses = solver.getMasses();
//        int result = solver.getTotalFuelRequirement(masses);
//        System.out.println(String.format("Result is: %d", result));

        System.out.println(solver.getFuelRequirementForModule(145866, 0));
    }
}

