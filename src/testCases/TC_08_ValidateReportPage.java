package testCases;

import lib.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import stepDefination.AdminLoginPage;
import stepDefination.AdminReportPage;

public class TC_08_ValidateReportPage extends BaseClass {
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
    public void openPatientsSubMenu(){
        AdminReportPage objAdminReportPage = new AdminReportPage(getDriver());
        objAdminReportPage.openReportMenu();
        log.info("open report menu");
    }
    @Test(priority=3, groups="smoke")
    public void validateReportInfo(){
        AdminReportPage objAdminReportPage = new AdminReportPage(getDriver());
        Assert.assertEquals(objAdminReportPage.getReportPageTitle(), "BETWEEN DATES | REPORTS");
        Assert.assertEquals(objAdminReportPage.getBodyPageTitle(), "Between Dates Reports");
        log.info("open report page");
    }
    @Test(priority=4, groups="smoke")
    public void setdates(){
        AdminReportPage objAdminReportPage = new AdminReportPage(getDriver());
        objAdminReportPage.setDates();
        log.info("set dates");
    }
    @Test(priority=5, groups="smoke")
    public void validateTableinfo(){
        AdminReportPage objAdminReportPage = new AdminReportPage(getDriver());
        Assert.assertEquals(objAdminReportPage.getTableTitle(), "Report from 2020-12-06 to 2022-12-12");
        Assert.assertEquals(objAdminReportPage.getTableData(), "1. ABC 1234567891 Male 2022-06-19 12:51:21 2022-06-19 12:52:23");
        log.info("assert results");
    }
}