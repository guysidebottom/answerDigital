import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase1 {

    FirefoxDriver firefoxDriver;

    @Before
    public void setup() {
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.navigate().to("http://the-internet.herokuapp.com/");
        firefoxDriver.findElementByLinkText("Form Authentication").click();
    }

    @Test
    public void shouldDisplayErrorWhenUsingInvalidPassword() {
        HelperMethods.login(firefoxDriver, "tomsmith", "somePassword");

        String validationText = firefoxDriver.findElementById("flash").getText().trim();

        assertTrue(validationText.contains("Your password is invalid!"));
    }

    @Test
    public void shouldDisplayErrorWhenUsingInvalidUsername() {
        HelperMethods.login(firefoxDriver, "someUserName", "SuperSecretPassword!");

        String validationText = firefoxDriver.findElementById("flash").getText().trim();

        assertTrue(validationText.contains("Your username is invalid!"));
    }

    @Test
    public void loginWithValidCredentialsThenLogout() {
        HelperMethods.login(firefoxDriver, "tomsmith", "SuperSecretPassword!");

        firefoxDriver.findElementByClassName("icon-signout").click();

        String validationText = firefoxDriver.findElementById("flash").getText().trim();
        String header = firefoxDriver.findElementByTagName("h2").getText();

        assertTrue(header.equalsIgnoreCase("login page"));
        assertTrue(validationText.contains("You logged out of the secure area!"));
    }

    @After
    public void tearDown() {
        firefoxDriver.quit();
    }

}

