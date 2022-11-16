package testCases;

import lib.BaseClass;
import lib.FindBrokenLinks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import stepDefination.HomePages;
import java.io.IOException;

public class TC_01_validateHomePage extends BaseClass {

    private static final Logger log = LogManager.getLogger(TC_01_validateHomePage.class);

    @BeforeClass
   public void init() throws IOException {
       String webURL = readProperty().getProperty("URL");
       initBrowser(webURL, "chrome");
       log.info("Start Application");
   }

    @Test(priority=0, groups="smoke")
    public void verifyTitle(){
        Assert.assertEquals("Hospital Management System", getDriver().getTitle());
        log.info("Assert title");
    }
     @Test(priority=1, groups="smoke")
    public void verifyBrokenLinks() throws IOException {
        FindBrokenLinks objBrokenLinks = new FindBrokenLinks();
        objBrokenLinks.findBrokenLink(getDriver());
         log.info("Assert Broken Links");
    }
    @Test(priority=1, groups="smoke")
    public void verifyHomePageTitle(){
        HomePages loginObj= new HomePages(getDriver());
        String getHomePageTitle = loginObj.verifyHomePageTitle();
        Assert.assertEquals(getHomePageTitle, "Hospital Management system");
        log.info("Assert home page");
    }
    @Test(priority=2, groups="smoke")
    public void verifyMenu(){
        HomePages loginObj= new HomePages(getDriver());
        String getHomeMenu = loginObj.verifyHomeMenuOnHomePage();
        Assert.assertEquals(getHomeMenu, "HOME");
        String getContactMenu = loginObj.verifyContactMenuOnHomePage();
        Assert.assertEquals(getContactMenu, "CONTACT");
        log.info("Assert menu");
    }
    @Test(priority=3, groups="smoke")
    public void verifyImageOnHomePage(){
        HomePages loginObj= new HomePages(getDriver());
        Assert.assertTrue(loginObj.verifyImage1HomePage());
        log.info("Assert slider image");
    }

    @Test(priority=4, groups="smoke")
    public void verifyPatientSection(){
        HomePages loginObj= new HomePages(getDriver());
        Assert.assertTrue(loginObj.verifyPatientImageOnHomePage());
        Assert.assertEquals(loginObj.verifyPatientTitle(), "Patients");
        log.info("Assert patient title");
        Assert.assertEquals(loginObj.verifyPatientDescription(), "Register & Book Appointment");
        log.info("Assert patient description");
        Assert.assertEquals(loginObj.verifyPatientBtnTxt(), "Click Here");
        log.info("Assert button text");
    }

    @Test(priority=5, groups="smoke")
    public void verifyDoctorSection(){
        HomePages loginObj= new HomePages(getDriver());
        Assert.assertTrue(loginObj.verifyDoctorImageOnHomePage());
        log.info("Assert doctor image");
        Assert.assertEquals(loginObj.verifyDoctortTitle(), "Doctors Login");
        log.info("Assert doctor login text");
        Assert.assertEquals(loginObj.verifyDoctorBtnTxt(), "Click Here");
        log.info("Assert doctor btn");
    }

    @Test(priority=6, groups="smoke")
    public void verifyAdminSection(){
        HomePages loginObj= new HomePages(getDriver());
        Assert.assertTrue(loginObj.verifyAdminImageOnHomePage());
        log.info("Assert admin image");
        Assert.assertEquals(loginObj.verifyAdmintTitle(), "Admin Login");
        log.info("Assert admin text");
        Assert.assertEquals(loginObj.verifyAdminBtnTxt(), "Click Here");
        log.info("Assert admin click button");
    }

    @Test(priority=7, groups="smoke")
    public void verifyFooterSection(){
        HomePages loginObj= new HomePages(getDriver());
        Assert.assertEquals(loginObj.verifyHomePageMenu(), "HOME");
        log.info("Assert footer home menu");
        Assert.assertEquals(loginObj.verifyContactUsMenu(), "CONTACT");
        log.info("Assert footer contact menu");
    }
    @AfterClass
    public void close(){
        tearDown();
        log.info("Close app");
    }
}
