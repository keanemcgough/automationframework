package tests;

import CoreClasses.WebTest;
import navigation.LoadGoogle;
import org.apache.commons.io.FileUtils;
import static org.junit.Assert.assertTrue;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pageobjects.GoogleHomepage;

import java.io.File;
import java.io.IOException;

/**
 * Created by Keane on 6/24/2016.
 * Move all test, suites, and page objects to seprate projects. They shouldn't be in the framework class.
 */
public class ExampleTest extends WebTest{
    //this should read like a testcase. Non-coders should be able to understand what the test does.
    //complexity should be hidden in a page object or other meaningfully named class
    @Test
    public void simpleTest(){
        GoogleHomepage googleHomepage = LoadGoogle.loadGoogle(driver);
        googleHomepage.editSearchRandomAndEnter(10);
        //the test fails if the assertion fails
        assertTrue("Safe Search is not on",googleHomepage.verifySafeSearchIsEnabled());

    }

}