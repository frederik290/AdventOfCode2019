import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Intcode {
    String inputPath;
    private int[] prog;
    int pointer;

    public Intcode(String inputPath){
        this.pointer = 0;
        this.inputPath = inputPath;
        this.prog = initProg(inputPath);
    }

    public Intcode(){
       this.pointer = 0;
        //for testing purposes
    }

    public void findNounAndVerb(){
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                setProgConfiguration(i, j);
                if(run() == 19690720){
                    System.out.println("Noun: " + i + " Verb:" + j);
                }
            }
        }
    }

    private void setProgConfiguration(int i, int j) {
        this.prog = initProg(this.inputPath);
        this.pointer = 0;
        prog[1] = i;
        prog[2] = j;
    }

    public int run(int[] program){
        this.prog = program;
        return this.run();
    }

    public int run(){
        int opcode = prog[pointer];

        while(opcode != 99) {

            int index1 = prog[pointer+1];
            int index2 = prog[pointer+2];
            int storeIndex = prog[pointer+3];

            switch (opcode) {
                case 1:
                    process(index1, index2, storeIndex, ((a, b) -> a + b));
                    break;
                case 2:
                    process(index1, index2, storeIndex, ((a, b) -> a * b));
                    break;
            }
            opcode = movePointerAndGetOpcode();
        }
//        System.out.println(Arrays.toString(prog));
        return prog[0];
    }

    private void process(int i1, int i2, int si, TwoArgIntOperator operator){
        int result = operator.calculate(prog[i1], prog[i2]);
        prog[si] = result;
    }

    private int movePointerAndGetOpcode() {
        pointer = pointer + 4;
        return prog[pointer];
    }

    private int[] initProg(String inputPath) {
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
    public int[] getProg(){
        return this.prog;
    }

    interface TwoArgIntOperator {
        int calculate(int a, int b);
    }
}
