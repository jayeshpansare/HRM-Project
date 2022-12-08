package testCases;
import lib.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import stepDefination.AdminDoctorPage;
import stepDefination.AdminLoginPage;

public class TC_04_validateDoctorPage extends BaseClass {
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
    public void openDoctorSubMenu() throws InterruptedException {
        AdminDoctorPage objAdminDoctorPage = new AdminDoctorPage(getDriver());
        objAdminDoctorPage.openDoctorMenu();
        log.info("open doctor menu");
    }
    @Test(priority=3, groups="smoke", dataProvider = "doctorSpecificationInvalidDataProvider")
    public void doctorSpecialization(String doctorData) throws InterruptedException {
        AdminDoctorPage objAdminDoctorPage = new AdminDoctorPage(getDriver());
        String getDoctorErrorMessage = objAdminDoctorPage.validateDoctorSpecilization(doctorData);
        Assert.assertEquals(getDoctorErrorMessage, "Doctor Specialization added successfully !!");
        log.info("Add doctor");
    }
    @Test(priority=4, groups="smoke")
    public void openAddDoctorPage(){
        AdminDoctorPage objAdminDoctorPage = new AdminDoctorPage(getDriver());
        objAdminDoctorPage.openAddDoctorMenu();
        log.info("open doctor menu");
    }
    @Test(priority=5, groups="smoke")
    public void addDoctorPage(){
        AdminDoctorPage objAdminDoctorPage = new AdminDoctorPage(getDriver());
        objAdminDoctorPage.addDoctorData();
        log.info("Add doctor data");
    }
    @Test(priority=6, groups="smoke")
    public void verifyEmailMsg() throws InterruptedException {
        AdminDoctorPage objAdminDoctorPage = new AdminDoctorPage(getDriver());
        Assert.assertEquals(objAdminDoctorPage.verifyEmailMsg(), "Email available for Registration .");
        log.info("verify email message - "+objAdminDoctorPage.verifyEmailMsg());
        objAdminDoctorPage.clickAddDoctorForm();
    }
    @Test(priority=7, groups="smoke")
    public void verifyAddDoctorAlertMsg() throws InterruptedException {
        AdminDoctorPage objAdminDoctorPage = new AdminDoctorPage(getDriver());
        objAdminDoctorPage.getAddDoctorAlertMsg();
        log.info("Alert message");
        objAdminDoctorPage.clickOnAddDoctorAlert();
    }
    @Test(priority=8, groups="smoke")
    public void clickOnEditBtn() throws InterruptedException {
        AdminDoctorPage objAdminDoctorPage = new AdminDoctorPage(getDriver());
        Thread.sleep(1000);
        System.out.println(objAdminDoctorPage.getEditBtnToolTip());
        objAdminDoctorPage.clickOnEditBtn();
        log.info("Open edit form");
    }
    @Test(priority=9, groups="smoke")
    public void verifyEditPageTitle() throws InterruptedException {
        AdminDoctorPage objAdminDoctorPage = new AdminDoctorPage(getDriver());
        System.out.println(objAdminDoctorPage.getEditPageTitle());
        System.out.println(objAdminDoctorPage.getEditPageSubTitle());
        System.out.println(objAdminDoctorPage.getEditPageProfileTitle());
        System.out.println(objAdminDoctorPage.getRegDate());
    }

    @Test(priority=10, groups="smoke")
    public void updateDoctorInfo() throws InterruptedException {
        AdminDoctorPage objAdminDoctorPage = new AdminDoctorPage(getDriver());
        objAdminDoctorPage.updateDoctorInfo();
        objAdminDoctorPage.clickOnUpdateDoctorBtn();
    }
}