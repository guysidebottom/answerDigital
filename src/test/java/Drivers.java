import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Drivers {

    @Test
    public void createFirefoxDriver() {

        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.quit();

    }

    @Test
    public void createChromeDriver() {

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.quit();

    }
}