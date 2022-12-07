package testCases;

import lib.BaseClass;
import lib.XLUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import stepDefination.AdminLoginPage;
import stepDefination.AdminPatientSearch;
import stepDefination.AdminReportPage;

import java.io.IOException;

public class TC_09_ValidatePatientSearchPage extends BaseClass {
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

    @Test(priority = 1)
    public void clickPatientSearchMenu(){
        AdminPatientSearch objAdminPatientSearch = new AdminPatientSearch(getDriver());
        objAdminPatientSearch.clickPatientSearchMenu();
        objAdminPatientSearch.searchPatient();
        log.info("search patient info");
        Assert.assertEquals(objAdminPatientSearch.getPatientSearchResult(),"1. John 1234567890 male 2019-11-10 18:49:24");
        log.info("validate patient info");
    }
    @DataProvider(name = "loginValidDataProvider")
    public Object[][] loginValidDataProviderMethod() throws IOException {
        XLUtils obj = new XLUtils();
        return new Object[][] {{obj.getCellData(fileURLPath, "loginValid", 1,1), obj.getCellData(fileURLPath, "loginValid", 1,2)}};
    }
}