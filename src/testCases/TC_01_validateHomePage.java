package testCases;

import lib.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import stepDefination.HomePages;

import java.io.IOException;

public class TC_01_validateHomePage extends BaseClass {
    HomePages loginObj= new HomePages(getDriver());

    @BeforeClass
   public void init() throws IOException {
       String webURL = readProperty().getProperty("URL");
       initBrowser(webURL, "chrome");
   }

    @Test(priority=0, groups="smoke")
    public void verifyTitle(){

        Assert.assertEquals("Hospital Management System", getDriver().getTitle());
    }

   @AfterClass
   public void close(){
       tearDown();
   }
}
