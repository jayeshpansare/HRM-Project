package stepDefination;

import lib.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePages extends PageActions {
    private final WebDriver driver;
    public HomePages(WebDriver driver){
        this.driver=driver;
    }
    By websiteTitle = By.xpath("//div[@class='logo']/a");
    By getHomeMenu = By.xpath("//div[@class='top-nav']/ul/li[1]/a");
    By getContactMenu = By.xpath("//div[@class='top-nav']/ul/li[2]/a");
    By getSliderImg1 = By.xpath("//ul[@id='slider1']/li[1]/img");
    By getSliderImg2 = By.xpath("//ul[@id='slider1']/li[2]/img");
    By getSliderImg3 = By.xpath("//ul[@id='slider1']/li[3]/img");

    public String verifyHomePageTitle() {
        return getElementText(driver, websiteTitle);
    }
    public String verifyHomeMenuOnHomePage() {
        return getElementText(driver, getHomeMenu);
    }
    public String verifyContactMenuOnHomePage() {
        return getElementText(driver, getContactMenu);
    }
}
