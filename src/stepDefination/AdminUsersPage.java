package stepDefination;

import lib.PageActions;
import lib.WaitActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminUsersPage extends PageActions {
    private final WebDriver driver;
    public AdminUsersPage(WebDriver driver) {
        this.driver = driver;
    }
    By adminUserMenu = By.xpath("//ul[@class='main-navigation-menu']/li[3]/a/div");
    By adminManageUser = By.xpath("//ul[@class='main-navigation-menu']/li[3]/ul/li/a");

    public void openUsersMenu() {
        WaitActions objWait = new WaitActions();
        objWait.expliciteWaitVisibilityEle(driver, 10, adminUserMenu);
        clickOnElement(driver, adminUserMenu);
        objWait.expliciteWaitVisibilityEle(driver, 10, adminManageUser);
        clickOnElement(driver, adminManageUser);
    }
}
