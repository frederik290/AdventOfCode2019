import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String inputPath = Paths.get(Paths.get("").toAbsolutePath() + "/Day3/input.txt").toString();
        String[] lines = Util.getLinesFromFile(inputPath);
        String[] p1 = lines[0].split(",");
        String[] p2 =  lines[1].split(",");

        CrossedWires cw = new CrossedWires();
//        cw.getClosestIntersectionDistanceByManhattanDistance(p1, p2);
        cw.getClosestIntersectionDistanceByMinimumSteps(p1, p2);

    }
}
