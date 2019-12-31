import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String inputPath = "/Users/frederik290/IdeaProjects/AdventOfCode2019/Day3/input.txt";
        String[] lines = Util.getLinesFromFile(inputPath);
        String[] p1 = Arrays.stream(lines[0].split(",")).toArray(String[]::new);
        String[] p2 =  Arrays.stream(lines[1].split(",")).toArray(String[]::new);

        CrossedWires cw = new CrossedWires();
//        cw.getClosestIntersectionDistanceByManhattanDistance(p1, p2);
        cw.getClosestIntersectionDistanceByMinimumSteps(p1, p2);
    }
}
