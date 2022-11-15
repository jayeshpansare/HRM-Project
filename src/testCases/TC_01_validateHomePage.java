package testCases;

import lib.BaseClass;
import lib.FindBrokenLinks;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import stepDefination.HomePages;
import java.io.IOException;

public class TC_01_validateHomePage extends BaseClass {

    @BeforeClass
   public void init() throws IOException {
       String webURL = readProperty().getProperty("URL");
       initBrowser(webURL, "chrome");
   }

    @Test(priority=0, groups="smoke")
    public void verifyTitle(){
        Assert.assertEquals("Hospital Management System", getDriver().getTitle());
    }
    /* @Test(priority=1, groups="smoke")
    public void verifyBrokenLinks() throws IOException {
        FindBrokenLinks objBrokenLinks = new FindBrokenLinks();
        objBrokenLinks.findBrokenLink(getDriver());
    }*/
    @Test(priority=1, groups="smoke")
    public void verifyHomePageTitle(){
        HomePages loginObj= new HomePages(getDriver());
        String getHomePageTitle = loginObj.verifyHomePageTitle();
        Assert.assertEquals(getHomePageTitle, "Hospital Management system");
    }
    @Test(priority=2, groups="smoke")
    public void verifyMenu(){
        HomePages loginObj= new HomePages(getDriver());
        String getHomeMenu = loginObj.verifyHomeMenuOnHomePage();
        Assert.assertEquals(getHomeMenu, "HOME");
        String getContactMenu = loginObj.verifyContactMenuOnHomePage();
        Assert.assertEquals(getContactMenu, "CONTACT");
    }


   @AfterClass
   public void close(){
       tearDown();
   }
}
