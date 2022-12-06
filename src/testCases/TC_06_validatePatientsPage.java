package testCases;

import lib.BaseClass;
import lib.XLUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import stepDefination.AdminLoginPage;
import stepDefination.AdminPatientsPage;

import java.io.IOException;

public class TC_06_validatePatientsPage extends BaseClass {
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
    public void openPatientsSubMenu() throws InterruptedException {
        AdminPatientsPage objAdminPatientsPage = new AdminPatientsPage(getDriver());
        objAdminPatientsPage.openPatientsMenu();
    }

    @DataProvider(name = "loginValidDataProvider")
    public Object[][] loginValidDataProviderMethod() throws IOException {
        XLUtils obj = new XLUtils();
        return new Object[][] {{obj.getCellData(fileURLPath, "loginValid", 1,1), obj.getCellData(fileURLPath, "loginValid", 1,2)}};
    }
}
