import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Util {

    public static int[] getInputFromCommaSeparatedFile(String inputPath) {
        Path path = Paths.get(inputPath);

        try{
            return Arrays.stream(Files.readString(path).split(","))
                    .map(Integer::valueOf)
                    .mapToInt(Integer::intValue)
                    .toArray();
        } catch (Exception e) {
            System.out.println("ERROR: failed to read " + path.toString());
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }

    public static String[] getLinesFromFile(String inputPath){
        String[] result;

        try{
            result = new String[(int) Files.lines(Paths.get(inputPath)).count()];
        } catch (Exception ex){
            System.out.println("ERROR: failed to read " + inputPath);
            ex.printStackTrace();
            return null;
        }

        int i = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            for(String line; (line = br.readLine()) != null; ) {
                result[i] = line;
                i++;
            }
            return result;
        } catch (Exception ex) {
            System.out.println("ERROR: failed to read " + inputPath);
            System.out.println("Exception: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        }

    }
}
