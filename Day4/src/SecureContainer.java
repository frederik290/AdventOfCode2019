import java.util.stream.IntStream;

public class SecureContainer {

    public int getNumberOfValidPasswordsInRange(int startRange, int endRange) {
        int count = 0;
        for(int number : IntStream.range(startRange, endRange + 1).toArray()){
            if(requirementsMet(number))
                count++;
        }
        return count;
    }

    public SecureContainer() {

    }

    public boolean requirementsMet(int number){
        String str = Integer.toString(number);
        return containsDoubleDigits(str) && isNonDeceasing(str);
    }

    public boolean containsDoubleDigits(String str){
        for(int i = 0; i < str.length() - 1; i++){
            if(str.charAt(i) == str.charAt(i+1))
                return true;
        }
        return false;
    }

    public boolean isNonDeceasing(String str){
        boolean isNonDecreasing = true;

        for(int i = 0; i < str.length() - 1; i++){
            int currentValue = Integer.parseInt(str.charAt(i) + "");
            int nextValue = Integer.parseInt(str.charAt(i+1) + "");
            isNonDecreasing &= currentValue <= nextValue;
        }
        return isNonDecreasing;
    }
}
