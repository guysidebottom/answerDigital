import org.openqa.selenium.firefox.FirefoxDriver;

public class HelperMethods {

    public static void login(FirefoxDriver firefoxDriver, String userName, String password) {
        firefoxDriver.findElementById("username").sendKeys(userName);
        firefoxDriver.findElementById("password").sendKeys(password);
        firefoxDriver.findElementByTagName("button").click();
    }

    public static String pressKeyAndReturnResult(FirefoxDriver firefoxDriver, String characterPressed) {
        firefoxDriver.findElementByTagName("body").sendKeys(characterPressed);
        return firefoxDriver.findElementById("result").getText();
    }
}
