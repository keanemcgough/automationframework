package CoreClasses;

import com.sun.deploy.util.SystemUtils;
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
        System.out.println(System.getProperty("os.name"));
        String path = "";
        if (System.getProperty("os.name").toLowerCase().indexOf("win") > -1)
            path = "D:\\chromedriver\\chromedriver.exe";
        else
            path = "~/chromedriver/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
        return new ChromeDriver();

    }

    public static WebDriver createRemoteChromeDriver() {
        try {
            return new RemoteWebDriver(
                    new URL("http://ip:4444/wd/hub"),
                    DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            return null;
        }
    }


}
