import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.TestCase.assertTrue;


public class TestCase3 {

    FirefoxDriver firefoxDriver;

    @Before
    public void setup() {
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.navigate().to("http://the-internet.herokuapp.com/");
        firefoxDriver.findElementByLinkText("Key Presses").click();
    }

    @Test
    public void shouldPressFourKeysAndAssertWhatWasPressed() {
        firefoxDriver.findElementByTagName("body").sendKeys("a");
        String keyPressOne = firefoxDriver.findElementById("result").getText();
        firefoxDriver.findElementByTagName("body").sendKeys("b");
        String keyPressTwo = firefoxDriver.findElementById("result").getText();
        firefoxDriver.findElementByTagName("body").sendKeys("c");
        String keyPressThree = firefoxDriver.findElementById("result").getText();
        firefoxDriver.findElementByTagName("body").sendKeys("d");
        String keyPressFour = firefoxDriver.findElementById("result").getText();

        assertTrue(keyPressOne.equalsIgnoreCase("You entered: A"));
        assertTrue(keyPressTwo.equalsIgnoreCase("You entered: B"));
        assertTrue(keyPressThree.equalsIgnoreCase("You entered: C"));
        assertTrue(keyPressFour.equalsIgnoreCase("You entered: D"));

    }

    @After
    public void tearDown() {
        firefoxDriver.quit();
    }
}
