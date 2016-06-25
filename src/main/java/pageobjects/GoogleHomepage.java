package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.applet.Main;

import java.util.UUID;

/**
 * Created by Keane on 6/24/2016.
 */
public class GoogleHomepage {
    WebDriver driver;
    @FindBy(id = "lst-ib")
    private WebElement searchInput;
    @FindBy(id = "fbar")
    private WebElement fbar;
    @FindBy(xpath = "//*[@id=\"ab_ctls\"]/li[2]/span")
    private WebElement safeSearch;
    public GoogleHomepage(WebDriver driver) {
        this.driver = driver;
    }

    public void editSearchRandomAndEnter(int rand) {
        for(int i = 0; i< rand;i++) {
            searchInput.clear();
            searchInput.sendKeys(UUID.randomUUID().toString());
            searchInput.sendKeys(Keys.ENTER);
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(fbar));
        }
    }

    public Boolean verifySafeSearchIsEnabled(){
        return safeSearch.getText().contains("SafeSearch On");
    }


}
