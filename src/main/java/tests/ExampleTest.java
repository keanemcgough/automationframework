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
 */
public class ExampleTest extends WebTest{
    @Test
    public void simpleTest(){
        GoogleHomepage googleHomepage = LoadGoogle.loadGoogle(driver);
        googleHomepage.editSearchRandomAndEnter(10);
        assertTrue("Safe Search is not on",googleHomepage.verifySafeSearchIsEnabled());

    }

}