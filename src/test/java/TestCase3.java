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
        String keyPressOne = HelperMethods.pressKeyAndReturnResult(firefoxDriver, "a");
        String keyPressTwo = HelperMethods.pressKeyAndReturnResult(firefoxDriver, "b");
        String keyPressThree = HelperMethods.pressKeyAndReturnResult(firefoxDriver, "c");
        String keyPressFour = HelperMethods.pressKeyAndReturnResult(firefoxDriver, "d");

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
