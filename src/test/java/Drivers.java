import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Drivers {

    @Test
    public void createFirefoxDriver() {

        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.quit();

    }
}