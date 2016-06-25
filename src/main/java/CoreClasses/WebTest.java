package CoreClasses;

import org.junit.After;
import org.junit.Before;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Created by Keane on 6/24/2016.
 * Create UI tests using this class as the base
 */
public class WebTest extends GenericTest {
    protected WebDriver driver;
    TestName testName = new TestName();
    @Before
    public void initialize() {
        //possible place to store startup information in database
        driver = InitialSetup.createDriver();
    }

    @After
    public void deleteOutputFile() {
        driver.close();
    }

    TestWatcher testWatcherUI =new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            //save this screenshot somewhere.
            //if the failure is caused by the driver session breaking, this will throw and exception
            try {
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            }catch (Exception ex){
                e.printStackTrace();
            }
            super.failed(e, description);
        }

        @Override
        protected void finished(Description description) {
            super.finished(description);
        }
    };
}
