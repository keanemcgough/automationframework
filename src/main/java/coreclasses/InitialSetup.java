package coreclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Keane on 6/24/2016.
 */
public class InitialSetup {
    public static WebDriver createDriver() {
        String browser = System.getProperty("remotedriver");
        browser = browser == null ? "" : browser;
        WebDriver driver = null;
        switch (browser) {
            case "firefox":
                driver = createRemoteDriver(DesiredCapabilities.firefox());
                break;
            case "chrome":
                //add specific chrome settings here or create a new method
                driver = createRemoteDriver(DesiredCapabilities.chrome());
                break;
            case "chromelocal":
                driver = createLocalChromeDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }

    public static WebDriver createLocalChromeDriver() {
        System.out.println(System.getProperty("os.name"));
        String path = "";
        //this should work on windows and linux assuming chromedriver is in the correct folder or the path is changed
        if (System.getProperty("os.name").toLowerCase().indexOf("win") > -1)
            path = "D:\\chromedriver\\chromedriver.exe";
        else
            path = "~/chromedriver/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
        return new ChromeDriver();

    }

    public static WebDriver createLocalFirefoxDriver() {
        return new FirefoxDriver();
    }

    public static WebDriver createRemoteDriver(DesiredCapabilities caps) {
        try {
            //add grid hostname or ip
            return new RemoteWebDriver(new URL(System.getProperty("gridaddress") + ":4444/wd/hub"), caps);
        } catch (MalformedURLException e) {
            return null;
        }
    }


}
