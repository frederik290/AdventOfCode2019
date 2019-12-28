import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Solver {
    private List<Integer> masses;

    public Solver(){
        this.masses = getInput();
    }

    public List<Integer> getMasses(){
        return masses;
    }

    public int getTotalFuelRequirement(List<Integer> masses){
        return masses.stream().reduce(0, (subTotal, element) -> subTotal + (element/3)-2);
    }

    public int getTotalFuelRequirementRecursive(List<Integer> masses){
        return masses.stream()
                .reduce(0, (subTotal, element) -> subTotal + getFuelRequirementForModule(element, 0));
    }

    public int getFuelRequirementForModule(int moduleWeight, int accumulator){
        int fuelRequired = (moduleWeight/3)-2;
        System.out.println(fuelRequired);
        if(fuelRequired <= 0) {
            return accumulator;
        } else {
            return getFuelRequirementForModule(fuelRequired, accumulator + fuelRequired);
        }
    }

    private List<Integer> getInput() {
        Path path = Paths.get("/Users/frederik290/IdeaProjects/AdventOfCode2019/Day1/Input.txt");
        try{
            List<String> lines =  Files.readAllLines(path);
            return lines.stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("ERROR: failed to read " + path.toString());
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }
}
