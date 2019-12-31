public class Main {
    public static void main(String[] args) {
        SecureContainer sc = new SecureContainer();
        int numberOfValidPasses = sc.getNumberOfValidPasswordsInRange(134564, 585159);
        System.out.println("Number of valid passes: " + numberOfValidPasses);
    }
}
