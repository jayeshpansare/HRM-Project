package stepDefination;

import lib.PageActions;
import lib.WaitActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage extends PageActions {
    private final WebDriver driver;

    public AdminLoginPage(WebDriver driver){
        this.driver=driver;
    }
    By adminBtnLink = By.xpath("//div[@class='content-grids']/div/div/div[3]/div[2]/div/span/a");
    By adminUserName = By.name("username");
    By adminPassword = By.name("password");
    By passwordErrorMsg = By.xpath("//input[@name='password']/following-sibling::span[@id='password-error']");
    By passwordErrorMsg1 = By.xpath("//form[@class='form-login']/fieldset/p/span");
    By loginBtn = By.xpath("//form[@class='form-login']/fieldset/div[3]/button");
    public void clickOnAdminBtn() {
        WaitActions waitActionsObj = new WaitActions();
        waitActionsObj.expliciteWaitVisibilityEle(driver, 10, adminBtnLink);
        clickOnElement(driver, adminBtnLink);
    }

    public String getLoginPageTitle() {
        return driver.getTitle();
    }
    public void validateLoginCreds(String username, String password) {
        clearInput(driver, adminUserName);
        sendInput(driver, adminUserName, username);
        clearInput(driver, adminPassword);
        sendInput(driver, adminPassword, password);
    }
    public String getErrorMessageForPassword(){
        WaitActions objWait = new WaitActions();
        objWait.expliciteWaitVisibilityEle(driver, 10, passwordErrorMsg);
        return getElementText(driver, passwordErrorMsg);
    }
    public String getErrorMsgForUserNamePassword(){
        return getElementText(driver, passwordErrorMsg1);
    }
    public void clickOnLoginBtn() {
        clickOnElement(driver, loginBtn);
    }
}
