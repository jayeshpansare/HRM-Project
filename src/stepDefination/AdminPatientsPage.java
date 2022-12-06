package stepDefination;

import lib.PageActions;
import lib.WaitActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPatientsPage extends PageActions {
    private final WebDriver driver;
    public AdminPatientsPage(WebDriver driver) {
        this.driver = driver;
    }

    By adminPatientsMenu = By.xpath("//ul[@class='main-navigation-menu']/li[4]/a/div");
    By adminManagePatientsUser = By.xpath("//ul[@class='main-navigation-menu']/li[4]/ul/li/a");

    public void openPatientsMenu() {
        WaitActions objWait = new WaitActions();
        objWait.expliciteWaitVisibilityEle(driver, 10, adminPatientsMenu);
        clickOnElement(driver, adminPatientsMenu);
        objWait.expliciteWaitVisibilityEle(driver, 10, adminManagePatientsUser);
        clickOnElement(driver, adminManagePatientsUser);
    }
}
