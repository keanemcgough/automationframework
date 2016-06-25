package CoreClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Keane on 6/24/2016.
 */
public class InitialSetup {
    public static WebDriver createDriver() {
        String remote = System.getProperty("remotedriver");
        return remote != null && remote.equals("remote") ? createRemoteChromeDriver() : createLocalChromeDriver();
    }

    public static WebDriver createLocalChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        return new ChromeDriver();

    }

    public static WebDriver createRemoteChromeDriver() {
        try {
            return new RemoteWebDriver(
                    new URL("http://10.2.0.250:4444/wd/hub"),
                    DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            return null;
        }
    }


}
