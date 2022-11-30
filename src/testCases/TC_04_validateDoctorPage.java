package testCases;
import gherkin.lexer.Th;
import lib.BaseClass;
import lib.XLUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import stepDefination.AdminDoctorPage;
import stepDefination.AdminLoginPage;

import java.io.IOException;
import java.net.Socket;

public class TC_04_validateDoctorPage extends BaseClass {
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
//    @Test(priority=1, groups="")
//    public void openDoctorSubMenu() throws InterruptedException {
//        AdminDoctorPage objAdminDoctorPage = new AdminDoctorPage(getDriver());
//        objAdminDoctorPage.openDoctorMenu();
//    }
//    @Test(priority=2, groups="", dataProvider = "doctorSpecificationInvalidDataProvider")
//    public void doctorSpecialization(String doctorData) throws InterruptedException {
//        AdminDoctorPage objAdminDoctorPage = new AdminDoctorPage(getDriver());
//        //objAdminDoctorPage.invalidDoctorSpecilization();
//        String getDoctorErrorMessage = objAdminDoctorPage.validateDoctorSpecilization(doctorData);
//        Assert.assertEquals(getDoctorErrorMessage, "Doctor Specialization added successfully !!");
//    }
    @Test(priority=3, groups="")
    public void openAddDoctorPage(){
        AdminDoctorPage objAdminDoctorPage = new AdminDoctorPage(getDriver());
        objAdminDoctorPage.openAddDoctorMenu();
    }
    @Test(priority=4, groups="")
    public void addDoctorPage(){
        AdminDoctorPage objAdminDoctorPage = new AdminDoctorPage(getDriver());
        objAdminDoctorPage.addDoctorData();
    }

    @Test(priority=5, groups="")
    public void verifyEmailMsg() throws InterruptedException {
        AdminDoctorPage objAdminDoctorPage = new AdminDoctorPage(getDriver());
        Assert.assertEquals(objAdminDoctorPage.verifyEmailMsg(), "Email available for Registration .");
        log.info("verify email message - "+objAdminDoctorPage.verifyEmailMsg());
        objAdminDoctorPage.clickAddDoctorForm();
    }
    @Test(priority=6, groups="")
    public void verifyAddDoctorAlertMsg() throws InterruptedException {
        AdminDoctorPage objAdminDoctorPage = new AdminDoctorPage(getDriver());
        objAdminDoctorPage.getAddDoctorAlertMsg();
        objAdminDoctorPage.clickOnAddDoctorAlert();
    }
    @Test(priority=7, groups="")
    public void clickOnEditBtn() throws InterruptedException {
        AdminDoctorPage objAdminDoctorPage = new AdminDoctorPage(getDriver());
        Thread.sleep(1000);
        System.out.println(objAdminDoctorPage.getEditBtnToolTip());
        objAdminDoctorPage.clickOnEditBtn();
    }
    @Test(priority=8, groups="")
    public void verifyEditPageTitle() throws InterruptedException {
        AdminDoctorPage objAdminDoctorPage = new AdminDoctorPage(getDriver());
        System.out.println(objAdminDoctorPage.getEditPageTitle());
        System.out.println(objAdminDoctorPage.getEditPageSubTitle());
        System.out.println(objAdminDoctorPage.getEditPageProfileTitle());
        System.out.println(objAdminDoctorPage.getRegDate());
    }

    @Test(priority=9, groups="")
    public void updateDoctorInfo() throws InterruptedException {
        AdminDoctorPage objAdminDoctorPage = new AdminDoctorPage(getDriver());
        objAdminDoctorPage.updateDoctorInfo();
        objAdminDoctorPage.clickOnUpdateDoctorBtn();
    }
    @DataProvider(name = "DoctorValidData")
    public Object[][] doctorValidData() throws IOException {
        return new Object[][] {{"Homeopath"}, {""}};
    }
    @DataProvider(name = "loginValidDataProvider")
    public Object[][] loginValidDataProviderMethod() throws IOException {
        XLUtils obj = new XLUtils();
        return new Object[][] {{obj.getCellData(fileURLPath, "loginValid", 1,1), obj.getCellData(fileURLPath, "loginValid", 1,2)}};
    }
    @DataProvider(name = "doctorSpecificationInvalidDataProvider")
    public Object[][] doctorInvalidDataProviderMethod() throws IOException {
        XLUtils obj = new XLUtils();
        return new Object[][] {{"Test"},
                            {"Test@123"}};
    }
}