package stepDefination;

import lib.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminAppointmentPage extends PageActions {
    private final WebDriver driver;
    public AdminAppointmentPage(WebDriver driver) {
        this.driver = driver;
    }
    By appointmentHistory = By.xpath("//ul[@class='main-navigation-menu']/li[5]/a/div/div[2]");

    public void openAppointmentMenu() {
        clickOnElement(driver, appointmentHistory);
    }

}
