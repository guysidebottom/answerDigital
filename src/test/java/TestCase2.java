import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class TestCase2 {

    FirefoxDriver firefoxDriver;

    @Before
    public void setup() {
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.navigate().to("http://the-internet.herokuapp.com/");
        firefoxDriver.findElementByLinkText("Infinite Scroll").click();
    }

    @Test
    public void shouldScrollPageVerticallyTwiceAndAssertHeader() {
        JavascriptExecutor jsExec = firefoxDriver;

        for(int i = 0; i < 2; i++) {
            jsExec.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }
        jsExec.executeScript("window.scrollTo(0, 0)");

        String header = firefoxDriver.findElementByTagName("h3").getText();

        assertTrue(header.equalsIgnoreCase("infinite scroll"));
    }

    @After
    public void tearDown() {
        firefoxDriver.quit();
    }
}
