package CoreClasses;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

/**
 * Created by Keane on 6/24/2016.
 */
public class WebTest extends GenericTest {
    protected WebDriver driver;
    @Before
    public void initialize() {
        driver = InitialSetup.createDriver();
    }

    @After
    public void deleteOutputFile() {
        driver.close();
    }
}
