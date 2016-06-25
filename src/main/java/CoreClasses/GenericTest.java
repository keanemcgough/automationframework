package CoreClasses;

import org.junit.*;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

/**
 * Created by Keane on 6/24/2016.
 * Create tests that are not for the UI using this class as the base
 */
public class GenericTest  {

    @Before
    public void initialize() {
    }

    @After public void end() {
    }

    public TestWatcher testWatcher =new TestWatcher() {
        @Override
        public void failed(Throwable e, Description description) {
            super.failed(e, description);
        }

        @Override
        public void finished(Description description) {
            super.finished(description);
        }
    };

}
