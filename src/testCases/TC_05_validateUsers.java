package testCases;

import lib.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import stepDefination.AdminLoginPage;
import stepDefination.AdminUsersPage;

public class TC_05_validateUsers extends BaseClass {
    private static final Logger log = LogManager.getLogger(TC_02_validateAdminLoginPage.class);
    @Test(priority=1, groups="smoke", dataProvider = "loginValidDataProvider")
    public void validateValidLoginCreds(String username, String password){
        AdminLoginPage adminLoginPageObj = new AdminLoginPage(getDriver());
        adminLoginPageObj.clickOnAdminBtn();
        log.info("Open Login page");
        adminLoginPageObj.validateLoginCreds(username, password);
        adminLoginPageObj.clickOnLoginBtn();
    }
    @Test(priority=2, groups="smoke")
    public void openUserSubMenu() throws InterruptedException {
        AdminUsersPage objAdminUserPage = new AdminUsersPage(getDriver());
        objAdminUserPage.openUsersMenu();
        log.info("open user menu");
    }
}