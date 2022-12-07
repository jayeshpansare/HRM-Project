package testCases;

import lib.BaseClass;
import lib.XLUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import stepDefination.AdminLoginPage;
import stepDefination.AdminReportPage;

import java.io.IOException;

public class TC_08_ValidateReportPage extends BaseClass {
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
    public void openPatientsSubMenu(){
        AdminReportPage objAdminReportPage = new AdminReportPage(getDriver());
        objAdminReportPage.openReportMenu();
        log.info("open report menu");
    }
    @Test(priority=2, groups="")
    public void validateReportInfo(){
        AdminReportPage objAdminReportPage = new AdminReportPage(getDriver());
        Assert.assertEquals(objAdminReportPage.getReportPageTitle(), "BETWEEN DATES | REPORTS");
        Assert.assertEquals(objAdminReportPage.getBodyPageTitle(), "Between Dates Reports");
        log.info("open report page");
    }
    @Test(priority=3, groups="")
    public void setdates(){
        AdminReportPage objAdminReportPage = new AdminReportPage(getDriver());
        objAdminReportPage.setDates();
        log.info("set dates");
    }
    @Test(priority=4, groups="")
    public void validateTableinfo(){
        AdminReportPage objAdminReportPage = new AdminReportPage(getDriver());
        Assert.assertEquals(objAdminReportPage.getTableTitle(), "Report from 2020-12-06 to 2022-12-12");
        Assert.assertEquals(objAdminReportPage.getTableData(), "1. ABC 1234567891 Male 2022-06-19 12:51:21 2022-06-19 12:52:23");
        log.info("assert results");
    }
    @DataProvider(name = "loginValidDataProvider")
    public Object[][] loginValidDataProviderMethod() throws IOException {
        XLUtils obj = new XLUtils();
        return new Object[][] {{obj.getCellData(fileURLPath, "loginValid", 1,1), obj.getCellData(fileURLPath, "loginValid", 1,2)}};
    }
}
