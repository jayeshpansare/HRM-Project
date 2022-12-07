package testCases;

import lib.BaseClass;
import lib.XLUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import stepDefination.AdminDashboardPage;
import stepDefination.AdminLoginPage;
import org.testng.Assert;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TC_03_validateDashboardPage extends BaseClass {
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
    public void validatedDashboard(){
        AdminDashboardPage objadminDashboardPage =  new AdminDashboardPage(getDriver());
        Assert.assertEquals(objadminDashboardPage.validateDashboardLogo(), "HMS");
        log.info("Assert page title as="+objadminDashboardPage.validateDashboardLogo());
        Assert.assertEquals(objadminDashboardPage.validateProjectName(), "Hospital Management System");

        List<String> list=new ArrayList<String>();
        list.add("Dashboard");
        list.add("Doctors");
        list.add("Users");
        list.add("Patients");
        list.add("Appointment History");
        list.add("Conatctus Queries");
        list.add("Doctor Session Logs");
        list.add("User Session Logs");
        list.add("Reports");
        list.add("Patient Search");
        List<WebElement> objDashboardMenu= objadminDashboardPage.validateLeftMenu();

        for(WebElement menuName :objDashboardMenu){
            if(list.contains(menuName.getText())){
                Assert.assertTrue(true);
                log.info("valid Menu as "+menuName.getText());
            }else {
                Assert.assertFalse(false);
                System.out.println(menuName.getText());
                log.info("Invalid Menu as "+menuName.getText());
            }
        }

        Assert.assertEquals(objadminDashboardPage.validateBreadcrumb(), "Admin Dashboard");
        System.out.println(objadminDashboardPage.dashboardTitle());

        List<String> listSubMenu =new ArrayList<String>();
        listSubMenu.add("Appointments");
        listSubMenu.add("New Queries");
        listSubMenu.add("Manage Users");
        listSubMenu.add("Manage Doctors");
        listSubMenu.add("Manage Patients");

        HashSet<String> ObjDashboardSubMenu= objadminDashboardPage.getDashboardSubMenu();
        if(!ObjDashboardSubMenu.isEmpty()){
            for(String subMenu:ObjDashboardSubMenu){
                if(listSubMenu.contains(subMenu)){
                    log.info("sections as "+subMenu);
                }else {
                    log.info("sections does not match "+subMenu);
                }
            }
        }
        objadminDashboardPage.logout();
        log.info("log out");
    }

    @DataProvider(name = "loginValidDataProvider")
    public Object[][] loginValidDataProviderMethod() throws IOException {
        XLUtils obj = new XLUtils();
        return new Object[][] {{obj.getCellData(fileURLPath, "loginValid", 1,1), obj.getCellData(fileURLPath, "loginValid", 1,2)}};
    }
}