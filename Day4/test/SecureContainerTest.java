import org.junit.Assert;
import org.junit.Test;

public class SecureContainerTest {
    @Test
    public void testDoubleDigits1() {
        SecureContainer sc = new SecureContainer();
        boolean result = sc.containsDoubleDigits("123456");
        Assert.assertEquals(false, result);
    }

    @Test
    public void testDoubleDigits2() {
        SecureContainer sc = new SecureContainer();
        boolean result = sc.containsDoubleDigits("123455");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testDoubleDigits3() {
        SecureContainer sc = new SecureContainer();
        boolean result = sc.containsDoubleDigits("121457");
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsNonDecreasing1() {
        SecureContainer sc = new SecureContainer();
        boolean result = sc.isNonDeceasing("123456");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsNonDecreasing2() {
        SecureContainer sc = new SecureContainer();
        boolean result = sc.isNonDeceasing("723456");
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsNonDecreasing3() {
        SecureContainer sc = new SecureContainer();
        boolean result = sc.isNonDeceasing("123256");
        Assert.assertEquals(false, result);
    }

    @Test
    public void testRequirementsMet1() {
        SecureContainer sc = new SecureContainer();
        boolean result = sc.requirementsMet(111111);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testRequirementsMet2() {
        SecureContainer sc = new SecureContainer();
        boolean result = sc.requirementsMet(223450);
        Assert.assertEquals(false, result);
    }

    @Test
    public void testRequirementsMet3() {
        SecureContainer sc = new SecureContainer();
        boolean result = sc.requirementsMet(123789);
        Assert.assertEquals(false, result);
    }
}



