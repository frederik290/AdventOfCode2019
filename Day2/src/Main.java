import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String inputPath = Paths.get(Paths.get("").toAbsolutePath() + "/Day2/Input.txt").toString();
        new Intcode(inputPath).findNounAndVerb();
    }
}

