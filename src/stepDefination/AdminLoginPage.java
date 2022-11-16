package stepDefination;

import lib.PageActions;
import lib.WaitActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage extends PageActions {
    private final WebDriver driver;

    public AdminLoginPage(WebDriver driver){
        this.driver =driver;
    }
    By adminBtnLink = By.xpath("//div[@class='content-grids']/div/div/div[3]/div[2]/div/span/a");
    public void clickOnAdminBtn() {
        WaitActions waitActionsObj = new WaitActions();
        waitActionsObj.expliciteWaitVisibilityEle(driver, 10, adminBtnLink);
        clickOnElement(driver, adminBtnLink);
    }
}
