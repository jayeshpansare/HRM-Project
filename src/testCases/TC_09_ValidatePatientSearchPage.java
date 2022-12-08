package testCases;

import lib.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import stepDefination.AdminLoginPage;
import stepDefination.AdminPatientSearch;

public class TC_09_ValidatePatientSearchPage extends BaseClass {
    private static final Logger log = LogManager.getLogger(TC_02_validateAdminLoginPage.class);
    @Test(priority=1, groups="smoke", dataProvider = "loginValidDataProvider")
    public void validateValidLoginCreds(String username, String password){
        AdminLoginPage adminLoginPageObj = new AdminLoginPage(getDriver());
        adminLoginPageObj.clickOnAdminBtn();
        log.info("Open Login page");
        adminLoginPageObj.validateLoginCreds(username, password);
        adminLoginPageObj.clickOnLoginBtn();
    }
    @Test(priority=2)
    public void clickPatientSearchMenu(){
        AdminPatientSearch objAdminPatientSearch = new AdminPatientSearch(getDriver());
        objAdminPatientSearch.clickPatientSearchMenu();
        objAdminPatientSearch.searchPatient();
        log.info("search patient info");
        Assert.assertEquals(objAdminPatientSearch.getPatientSearchResult(),"1. John 1234567890 male 2019-11-10 18:49:24");
        log.info("validate patient info");
    }
}