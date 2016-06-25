package navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.GoogleHomepage;

/**
 * Created by Keane on 6/24/2016.
 */
public class LoadGoogle {
    public static GoogleHomepage loadGoogle(WebDriver driver){
        driver.get("https://google.com");
        return PageFactory.initElements(driver, GoogleHomepage.class);
    }
}
