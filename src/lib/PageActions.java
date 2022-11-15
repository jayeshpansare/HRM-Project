package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageActions {
    public boolean isLocatorPresent(WebDriver driver, By locator){
        return driver.findElement(locator).isDisplayed();
    }
    public void clearInput(WebDriver driver, By locator){
        driver.findElement(locator).clear();
    }
    public void sendInput(WebDriver driver, By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }
    public void clickOnElement(WebDriver driver, By locator) {
        driver.findElement(locator).click();
    }
    public String getElementText(WebDriver driver, By locator) {
        return driver.findElement(locator).getText();
    }
    public void moveToElement(WebDriver driver, By locator){
        Actions actions= new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).build().perform();
    }

    public void selectOptionByVisibleText(WebDriver driver, By locator, String text) {
        Select select  = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
    }

    public void selectOptionByIndex(WebDriver driver, By locator, int index) {
        Select select  = new Select(driver.findElement(locator));
        select.selectByIndex(index);
    }
}
