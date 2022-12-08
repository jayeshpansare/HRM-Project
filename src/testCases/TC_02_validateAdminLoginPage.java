package testCases;

import lib.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import stepDefination.AdminLoginPage;

public class TC_02_validateAdminLoginPage extends BaseClass {
    private static final Logger log = LogManager.getLogger(TC_02_validateAdminLoginPage.class);

    @Test(priority=1, groups="smoke")
    public void openAdminLoginPage(){
        AdminLoginPage adminLoginPageObj = new AdminLoginPage(getDriver());
        adminLoginPageObj.clickOnAdminBtn();
        log.info("Open Login page");
    }
    @Test(priority=2, groups="smoke")
    public void validatePageTitle(){
        AdminLoginPage adminLoginPageObj = new AdminLoginPage(getDriver());
        String getPageTitle = adminLoginPageObj.getLoginPageTitle();
        Assert.assertEquals(getPageTitle,"Admin-Login");
    }

    @Test(priority=3, groups="smoke", dataProvider = "loginInvalidDataProvider")
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
    @Test(priority=4, groups="smoke", dataProvider = "loginValidDataProvider")
    public void validateValidLoginCreds(String username, String password){
        AdminLoginPage adminLoginPageObj = new AdminLoginPage(getDriver());
        adminLoginPageObj.validateLoginCreds(username, password);
        adminLoginPageObj.clickOnLoginBtn();
        log.info("Login user");
    }
}