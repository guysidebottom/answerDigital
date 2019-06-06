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
    public void shouldDisplayErrorWhenUsingInvalidPassword() throws InterruptedException {
        firefoxDriver.findElementById("username").sendKeys("tomsmith");
        firefoxDriver.findElementById("password").sendKeys("somePassword");
        firefoxDriver.findElementByTagName("button").click();

        String validationText = firefoxDriver.findElementById("flash").getText().trim();

        assertTrue(validationText.contains("Your password is invalid!"));
    }

    @Test
    public void shouldDisplayErrorWhenUsingInvalidUsername() throws InterruptedException {
        firefoxDriver.findElementById("username").sendKeys("someUsername");
        firefoxDriver.findElementById("password").sendKeys("SuperSecretPassword!");
        firefoxDriver.findElementByTagName("button").click();

        String validationText = firefoxDriver.findElementById("flash").getText().trim();

        assertTrue(validationText.contains("Your username is invalid!"));
    }

    @Test
    public void loginWithValidCredentialsThenLogout() throws InterruptedException {
        firefoxDriver.findElementById("username").sendKeys("tomsmith");
        firefoxDriver.findElementById("password").sendKeys("SuperSecretPassword!");
        firefoxDriver.findElementByTagName("button").click();
        firefoxDriver.findElementByClassName("icon-signout").click();

        String validationText = firefoxDriver.findElementById("flash").getText().trim();
        String header = firefoxDriver.findElementByTagName("h2").getText();

        assertTrue(validationText.contains("You logged out of the secure area!"));
        assertTrue(header.equalsIgnoreCase("login page"));
    }

    @After
    public void tearDown() {
        firefoxDriver.quit();
    }

}

