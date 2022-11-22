package stepDefination;

import lib.PageActions;
import lib.WaitActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashSet;
import java.util.List;

public class AdminDashboardPage extends PageActions {
    private final WebDriver driver;

    public AdminDashboardPage(WebDriver driver){
        this.driver=driver;
    }
    By dashboardlogo = By.xpath("//a[@class='navbar-brand']/h2");
    By projectName = By.xpath("//*[@id='app']/div[2]/header/div[2]/ul/li[1]/h2");
    By leftMenu = By.xpath(" //ul[@class='main-navigation-menu']/li");
    By breadCrumbMain = By.xpath("//ol[@class='breadcrumb']/li[1]");
    By breadCrumbSub = By.xpath("//ol[@class='breadcrumb']/li[2]");
    By projectTitle = By.xpath("//div[@class='app-content']/header/div[2]/ul/li/h2");
    By manageUser = By.xpath("//section[@id='page-title']/following-sibling::div/div/div[1]/div/div/h2");
    By manageDoctor= By.xpath("//section[@id='page-title']/following-sibling::div/div/div[2]/div/div/h2");
    By appointment = By.xpath("//section[@id=\"page-title\"]/following-sibling::div/div/div[3]/div/div/h2");
    By managePatient = By.xpath("//section[@id=\"page-title\"]/following-sibling::div/div/div[4]/div/div/h2");
    By newQuries=By.xpath("//section[@id=\"page-title\"]/following-sibling::div/div/div[5]/div/div/h2");
    By userMenu = By.cssSelector(" a.dropdown-toggle");
    By logOutBtn = By.xpath("//*[@class='dropdown-toggle\']//following-sibling::ul//li[2]/a");
    public String getDashboardPageTitle() {
        return driver.getTitle();
    }

    public String validateDashboardLogo() {
        WaitActions objWait= new WaitActions();
        objWait.expliciteWaitVisibilityEle(driver, 10, dashboardlogo);
        return getElementText(driver, dashboardlogo);
    }

    public String validateProjectName() {
        WaitActions objWait= new WaitActions();
        objWait.expliciteWaitVisibilityEle(driver, 10, dashboardlogo);
        return getElementText(driver, projectName);
    }

    public List<WebElement> validateLeftMenu() {
        List<WebElement> objArray = driver.findElements(leftMenu);
        return objArray;
    }

    public String validateBreadcrumb() {
        return getElementText(driver, breadCrumbMain) +" "+ getElementText(driver, breadCrumbSub);
    }

    public String dashboardTitle() {
        return getElementText(driver, projectTitle);
    }

    public HashSet<String> getDashboardSubMenu() {
        HashSet<String> objDashboardMenu = new HashSet<>();
        objDashboardMenu.add(getElementText(driver, manageUser));
        objDashboardMenu.add(getElementText(driver, manageDoctor));
        objDashboardMenu.add(getElementText(driver, appointment));
        objDashboardMenu.add(getElementText(driver, managePatient));
        objDashboardMenu.add(getElementText(driver, newQuries));
        return objDashboardMenu;
    }

    public void logout() {
        clickOnElement(driver, userMenu);
        clickOnElement(driver, logOutBtn);
    }
}
