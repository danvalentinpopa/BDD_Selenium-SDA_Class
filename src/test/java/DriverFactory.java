import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver driver;
    private static final String BROWSER_PROPERTY = "browser";
    private static final String EDGE_BROWSER = "edge";
    private static final String CHROME_BROWSER = "chrome";
    private static final long IMPLICIT_WAIT_TIMEOUT = 5;
    private static final int SCRIPT_TIMEOUT = 5;

    public static void startBrowser() {
        if (driver == null) {
            switch (getBrowser().toLowerCase()) {
                case EDGE_BROWSER:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case CHROME_BROWSER:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                default:
                    throw new IllegalStateException("Unsupported browser type");
            }

            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(SCRIPT_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().window().fullscreen();

        } else {
            throw new IllegalStateException("Driver has already been initialized. Quit it before using this method");
        }

    }

    private static String getBrowser() {
        String browser = System.getProperty(BROWSER_PROPERTY);
        if (browser == null) {
            browser = System.getenv(BROWSER_PROPERTY);
            if (browser == null) {
                browser = CHROME_BROWSER;
            }
        }
        return browser;
    }

    public static void destroyDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
