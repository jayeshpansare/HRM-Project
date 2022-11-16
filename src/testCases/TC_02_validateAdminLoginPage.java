package testCases;

import lib.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepDefination.AdminLoginPage;

public class TC_02_validateAdminLoginPage extends BaseClass {
    private static final Logger log = LogManager.getLogger(TC_01_validateHomePage.class);

    public void openAdminLoginPage(){
        AdminLoginPage adminLoginPageObj = new AdminLoginPage(getDriver());
        adminLoginPageObj.clickOnAdminBtn();
    }
}
