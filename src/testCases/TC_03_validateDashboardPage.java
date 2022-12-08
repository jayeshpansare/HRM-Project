package testCases;

import lib.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import stepDefination.AdminDashboardPage;
import stepDefination.AdminLoginPage;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TC_03_validateDashboardPage extends BaseClass {
    private static final Logger log = LogManager.getLogger(TC_02_validateAdminLoginPage.class);
    @Test(priority=0, groups="smoke", dataProvider = "loginValidDataProvider")
    public void validateValidLoginCreds(String username, String password){
        AdminLoginPage adminLoginPageObj = new AdminLoginPage(getDriver());
        adminLoginPageObj.clickOnAdminBtn();
        log.info("Open Login page");
        adminLoginPageObj.validateLoginCreds(username, password);
        adminLoginPageObj.clickOnLoginBtn();
    }

    @Test(priority=1, groups="smoke")
    public void validatedDashboard(){
        AdminDashboardPage objadminDashboardPage =  new AdminDashboardPage(getDriver());
        Assert.assertEquals(objadminDashboardPage.validateDashboardLogo(), "HMS");
        log.info("Assert page title as="+objadminDashboardPage.validateDashboardLogo());
        Assert.assertEquals(objadminDashboardPage.validateProjectName(), "Hospital Management System");

        List<String> list=new ArrayList<>();
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

        List<String> listSubMenu =new ArrayList<>();
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
}