package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.applet.Main;

/**
 * Created by Keane on 6/24/2016.
 */
public class GoogleHomepage {
    WebDriver driver;
    @FindBy(id = "lst-ib")
    private WebElement searchInput;
    public GoogleHomepage(){}
    public GoogleHomepage(WebDriver driver) {
        this.driver = driver;
    }

    public void editSearchAndEnter() {
        searchInput.sendKeys("selenium");
        searchInput.sendKeys(Keys.ENTER);
    }

    public void waitThirtySeconds() {
        synchronized ( GoogleHomepage.this) {
            try {
                wait(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
