package testCases;

import lib.BaseClass;
import lib.XLUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import stepDefination.AdminLoginPage;
import stepDefination.AdminUsersPage;
import java.io.IOException;

public class TC_05_validateUsers extends BaseClass {
    static String fileURLPath = "";
    static{
        String projectPath = System.getProperty("user.dir");
        String fileURL = projectPath+"\\src\\data\\login.xlsx";
        fileURLPath = fileURL;
    }
    private static final Logger log = LogManager.getLogger(TC_02_validateAdminLoginPage.class);
    @Test(priority=0, groups="", dataProvider = "loginValidDataProvider")
    public void validateValidLoginCreds(String username, String password){
        AdminLoginPage adminLoginPageObj = new AdminLoginPage(getDriver());
        adminLoginPageObj.clickOnAdminBtn();
        log.info("Open Login page");
        adminLoginPageObj.validateLoginCreds(username, password);
        adminLoginPageObj.clickOnLoginBtn();
    }

    @Test(priority=1, groups="")
    public void openUserSubMenu() throws InterruptedException {
        AdminUsersPage objAdminUserPage = new AdminUsersPage(getDriver());
        objAdminUserPage.openUsersMenu();
        log.info("open user menu");
    }
    @DataProvider(name = "loginValidDataProvider")
    public Object[][] loginValidDataProviderMethod() throws IOException {
        XLUtils obj = new XLUtils();
        return new Object[][] {{obj.getCellData(fileURLPath, "loginValid", 1,1), obj.getCellData(fileURLPath, "loginValid", 1,2)}};
    }
}