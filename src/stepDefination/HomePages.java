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
    By getIPatinetIcon = By.xpath("//div[@class='content-grids']/div/div/div[1]/div/img");
    By patientTitle= By.xpath("//div[@class='content-grids']/div/div/div/div[2]/h3");
    By patientDescription= By.xpath("//div[@class='content-grids']/div/div/div/div[2]/p");
    By patientBtnTxt = By.xpath("//div[@class='content-grids']/div/div/div/div[2]/div/span/a");
    By doctorProfileimg = By.xpath("//div[@class='content-grids']/div/div/div[2]/div/img");
    By doctorTitle = By.xpath("//div[@class='content-grids']/div/div/div[2]/div[2]/h3");
    By doctorBtnTxt = By.xpath("//div[@class='content-grids']/div/div/div[2]/div[2]/div/span/a");
    By adminProfileimg = By.xpath("//div[@class='content-grids']/div/div/div[3]/div/img");
    By adminTitle = By.xpath("//div[@class='content-grids']/div/div/div[3]/div[2]/h3");
    By adminBtnTxt = By.xpath("//div[@class='content-grids']/div/div/div[3]/div[2]/div/span/a");
    By footerHomeMenu = By.xpath("//div[@class='footer-left']/ul/li[1]/a");
    By footerContactMenu = By.xpath("//div[@class='footer-left']/ul/li[2]/a");

    /**
     *
     *
     * **/

    public String verifyHomePageTitle() {
        return getElementText(driver, websiteTitle);
    }
    public String verifyHomeMenuOnHomePage() {
        return getElementText(driver, getHomeMenu);
    }
    public String verifyContactMenuOnHomePage() {
        return getElementText(driver, getContactMenu);
    }
    public boolean verifyImage1HomePage(){
       return isLocatorPresent(driver, getSliderImg1);
    }
    public boolean verifyImage2HomePage() {
        return isLocatorPresent(driver, getSliderImg2);
    }
    public boolean verifyImage3HomePage() {
        return isLocatorPresent(driver, getSliderImg3);
    }
    public boolean verifyPatientImageOnHomePage() {
        return isLocatorPresent(driver, getIPatinetIcon);
    }
    public String verifyPatientTitle() {
        return getElementText(driver, patientTitle);
    }
    public String verifyPatientDescription() {
        return getElementText(driver, patientDescription);
    }
    public String verifyPatientBtnTxt() {
        return getElementText(driver, patientBtnTxt);
    }
    public boolean verifyDoctorImageOnHomePage() {
        return isLocatorPresent(driver, doctorProfileimg);
    }
    public String verifyDoctortTitle() {
        return getElementText(driver, doctorTitle);
    }
    public String verifyDoctorBtnTxt() {
        return getElementText(driver, doctorBtnTxt);
    }
    public boolean verifyAdminImageOnHomePage() {
        return isLocatorPresent(driver, adminProfileimg);
    }
    public String verifyAdmintTitle() {
        return getElementText(driver, adminTitle);
    }
    public String  verifyAdminBtnTxt() {
        return getElementText(driver, adminBtnTxt);
    }
    public String verifyHomePageMenu() {
        return getElementText(driver, footerHomeMenu);
    }
    public String verifyContactUsMenu() {
        return getElementText(driver, footerContactMenu);
    }
}
