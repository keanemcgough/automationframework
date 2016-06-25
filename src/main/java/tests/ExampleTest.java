package tests;

import CoreClasses.WebTest;
import navigation.LoadGoogle;
import org.apache.commons.io.FileUtils;
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
        googleHomepage.editSearchAndEnter();
        googleHomepage.waitThirtySeconds();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("c:\\temp\\screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
https://github.com/keanemcgough/automationframework.git