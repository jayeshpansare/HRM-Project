package stepDefination;

import lib.PageActions;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminReportPage extends PageActions {
    private final WebDriver driver;
    public AdminReportPage(WebDriver driver) {
        this.driver = driver;
    }
    By reportMenu = By.xpath("//ul[@class='main-navigation-menu']/li[9]/a/div");
    By dateReport = By.xpath("//ul[@class='main-navigation-menu']/li[9]/ul/li/a");
    By pageTitle = By.className("mainTitle");
    By containerName = By.className("panel-title");
    By fromdate= By.id("fromdate");
    By todate = By.id("todate");
    By submitForm = By.id("submit");
    By tableTitle = By.xpath("//*[@id='container']/div/div/div/h5");
    By tableRow1 = By.xpath("//*[@id='sample-table-1']/tbody/tr[1]");
    public void openReportMenu() {
        clickOnElement(driver, reportMenu);
        clickOnElement(driver, dateReport);
    }
    public String getReportPageTitle(){
        return getElementText(driver, pageTitle);
    }
    public String getBodyPageTitle(){
        return getElementText(driver, containerName);
    }
    public void setDates(){
        sendInput(driver, fromdate, "06122020");
        sendInput(driver, todate, "12122022");
        clickOnElement(driver, submitForm);
    }
    public String getTableTitle(){
        return getElementText(driver, tableTitle);
    }
    public String getTableData(){
        return getElementText(driver, tableRow1);
    }
}
