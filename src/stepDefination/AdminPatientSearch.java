package stepDefination;

import lib.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPatientSearch extends PageActions {
    private final WebDriver driver;
    public AdminPatientSearch(WebDriver driver) {
        this.driver = driver;
    }
    By patientSearch = By.xpath("//ul[@class='main-navigation-menu']/li[10]/a/div");
    By searchPatient = By.id("searchdata");
    By searchSubmitBtn = By.id("submit");
    By searchPatientDetails = By.xpath("//table[@id='sample-table-1']/tbody/tr");
    public void clickPatientSearchMenu(){
        clickOnElement(driver, patientSearch);
    }
    public void searchPatient(){
        sendInput(driver, searchPatient, "john");
        clickOnElement(driver, searchSubmitBtn);
    }
    public String getPatientSearchResult(){
        return getElementText(driver, searchPatientDetails);
    }
}
