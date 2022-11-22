package testCases;

import lib.BaseClass;
import lib.XLUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import stepDefination.AdminLoginPage;

import java.io.IOException;

public class TC_02_validateAdminLoginPage extends BaseClass {
    static String fileURLPath = "";
    static{
        String projectPath = System.getProperty("user.dir");
        String fileURL = projectPath+"\\src\\data\\login.xlsx";
        fileURLPath = fileURL;
    }
    private static final Logger log = LogManager.getLogger(TC_02_validateAdminLoginPage.class);

    @Test(priority=0, groups="")
    public void openAdminLoginPage(){
        AdminLoginPage adminLoginPageObj = new AdminLoginPage(getDriver());
        adminLoginPageObj.clickOnAdminBtn();
        log.info("Open Login page");
    }
    @Test(priority=2, groups="")
    public void validatePageTitle(){
        AdminLoginPage adminLoginPageObj = new AdminLoginPage(getDriver());
        String getPageTitle = adminLoginPageObj.getLoginPageTitle();
        Assert.assertEquals(getPageTitle,"Admin-Login");
    }

    @Test(priority=3, groups="", dataProvider = "loginInvalidDataProvider")
    public void validateInvalidLoginCreds(String username, String password) throws InterruptedException {
        AdminLoginPage adminLoginPageObj = new AdminLoginPage(getDriver());
        adminLoginPageObj.validateLoginCreds(username, password);
        log.info("send user name as "+username+" and password as "+password);
        adminLoginPageObj.clickOnLoginBtn();
        log.info("Click on login button");
        if(password.equalsIgnoreCase("Test")) {
            Assert.assertEquals(adminLoginPageObj.getErrorMessageForPassword(), "Please enter at least 6 characters.");
            log.info("Assert invalid password");
        }else{
            Assert.assertEquals(adminLoginPageObj.getErrorMsgForUserNamePassword(), "Invalid username or password");
            log.info("Assert invalid password");
        }
    }
    @Test(priority=0, groups="smoke", dataProvider = "loginValidDataProvider")
    public void validateValidLoginCreds(String username, String password){
        AdminLoginPage adminLoginPageObj = new AdminLoginPage(getDriver());
        adminLoginPageObj.validateLoginCreds(username, password);
        adminLoginPageObj.clickOnLoginBtn();
    }
    /**
     * Data providers
     * **/
    @DataProvider(name = "loginInvalidDataProvider")
    public Object[][] loginInvalidDataProviderMethod() throws IOException {
        XLUtils obj = new XLUtils();
        return new Object[][] {
                {obj.getCellData(fileURLPath, "loginInvalid", 1,1), obj.getCellData(fileURLPath, "loginInvalid", 1,2)},
                {obj.getCellData(fileURLPath, "loginInvalid", 2,1), obj.getCellData(fileURLPath, "loginInvalid", 2,2)}
        };
    }
    @DataProvider(name = "loginValidDataProvider")
    public Object[][] loginValidDataProviderMethod() throws IOException {
        XLUtils obj = new XLUtils();
        return new Object[][] {{obj.getCellData(fileURLPath, "loginValid", 1,1), obj.getCellData(fileURLPath, "loginValid", 1,2)}};
    }
}
