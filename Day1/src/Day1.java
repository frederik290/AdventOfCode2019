import java.util.List;


public class Day1 {
    public static void main(String[] args) {
        Solver solver = new Solver();
        List<Integer> masses = solver.getMasses();
        int result = solver.getTotalFuelRequirement(masses);
        System.out.println(String.format("Result is: %d", result));

    }
}

