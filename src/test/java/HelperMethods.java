import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class HelperMethods {

    public static void login(FirefoxDriver firefoxDriver, String userName, String password) {
        firefoxDriver.findElementById("username").sendKeys(userName);
        firefoxDriver.findElementById("password").sendKeys(password);
        firefoxDriver.findElementByTagName("button").click();
    }

    public static void validateMessage(String message) {
        assertTrue(message.contains("Your password is invalid!"));
    }
}
