package stepDefination;

import lib.PageActions;
import lib.WaitActions;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminDoctorPage extends PageActions {
    private final WebDriver driver;
    public AdminDoctorPage(WebDriver driver){
        this.driver=driver;
    }
    By doctorMainMenu = By.xpath("//ul[@class='main-navigation-menu']/li[2]/a/div");
    By specilizationMenu = By.xpath("//ul[@class='main-navigation-menu']/li[2]/ul/li/a/span");
    By doctorspecilizationInpt = By.name("doctorspecilization");
    By doctorErrorMsg= By.xpath("//*[@id='container']/div/div[1]/div[1]/div/div/div/div[2]/p");
    By doctorSubmitBtn = By.xpath("//form[@name='dcotorspcl']/button");
    By doctorMenu = By.xpath("//ul[@class='main-navigation-menu']/li[2]/ul/li[2]/a/span");
    By doctorSpeciInpt = By.name("Doctorspecialization");
    By doctorName= By.name("docname");
    By doctorClinicAddressInpt = By.name("clinicaddress");
    By doctorFreeinpt = By.name("docfees");
    By doctorNumberInpt =By.name("doccontact");
    By doctorEmailId = By.name("docemail");
    By passwordInpt = By.name("npass");
    By confirmPasswordInpt = By.name("cfpass");
    By addDoctorBtn = By.id("submit");
    By emailMsg = By.id("email-availability-status");
    By tableEditBtn = By.xpath("//table[@id='sample-table-1']/tbody/tr[last()]/td[5]/div/a[1]");

    // Edit page
    By editPageTitle =By.className("mainTitle");
    By editDoctorInfoLbl = By.className("panel-title");
    By profileLbl = By.xpath("//div[@class='panel-body']/h4");
    By dateTxt = By.xpath("//div[@class='panel-body']/p");
    By updateDoctorBtn = By.xpath("//form[@name='adddoc']/button");

    public void openDoctorMenu() {
        WaitActions objwait= new WaitActions();
        objwait.expliciteWaitVisibilityEle(driver, 10, doctorMainMenu);
        clickOnElement(driver, doctorMainMenu);
        objwait.expliciteWaitEleClickable(driver, 10, specilizationMenu);
        clickOnElement(driver, specilizationMenu);
    }

    public String validateDoctorSpecilization(String doctorData) throws InterruptedException {
        sendInput(driver, doctorspecilizationInpt, doctorData);
        Thread.sleep(1000);
        clickOnElement(driver, doctorSubmitBtn);
        return getElementText(driver, doctorErrorMsg);
    }

    public void validateDoctorSpecilization() {
    }
    public void openAddDoctorMenu() {
        WaitActions objwait= new WaitActions();
        objwait.expliciteWaitVisibilityEle(driver, 10, doctorMainMenu);
        clickOnElement(driver, doctorMainMenu);
        objwait.expliciteWaitEleClickable(driver, 10, doctorMenu);
        clickOnElement(driver, doctorMenu);
    }
    public void addDoctorData() {
        selectOptionByValue(driver, doctorSpeciInpt, "Homeopath");
        sendInput(driver, doctorName, "Test");
        sendInput(driver, doctorClinicAddressInpt, "Test Address");
        sendInput(driver, doctorFreeinpt, "100");
        sendInput(driver, doctorNumberInpt, "9999999999");
        sendInput(driver, doctorEmailId, "Testr15@gmail.com");
        sendInput(driver, passwordInpt, "Test");
        sendInput(driver, confirmPasswordInpt, "Test");
    }
    public String verifyEmailMsg() {
        WaitActions objWaitActions= new WaitActions();
        objWaitActions.presenceOfElementLocatedEle(driver, 10, emailMsg);
        return getElementText(driver, emailMsg);
    }
    public void clickAddDoctorForm() throws InterruptedException {
        WaitActions objWaitActions= new WaitActions();
        objWaitActions.presenceOfElementLocatedEle(driver, 10, emailMsg);
        clickOnElement(driver, addDoctorBtn);
        Thread.sleep(1000);
    }
    public String getAddDoctorAlertMsg() {
        return driver.switchTo().alert().getText();
    }
    public void clickOnAddDoctorAlert() {
        driver.switchTo().alert().accept();
    }
    public String getEditBtnToolTip() {
        WaitActions objWaitActions= new WaitActions();
        objWaitActions.presenceOfElementLocatedEle(driver, 100, tableEditBtn);
        return getAttributrText(driver, tableEditBtn, "tooltip");
    }
    public void clickOnEditBtn() {
        WaitActions objWaitActions= new WaitActions();
        objWaitActions.presenceOfElementLocatedEle(driver, 100, tableEditBtn);
        clickOnElement(driver, tableEditBtn);
    }
    public String getEditPageTitle() {
        return getElementText(driver, editPageTitle);
    }

    public String getEditPageSubTitle() {
        return getElementText(driver, editDoctorInfoLbl);
    }

    public String getEditPageProfileTitle() {
        return getElementText(driver, profileLbl);
    }

    public String getRegDate() {
        return getElementText(driver, dateTxt);
    }
    public void updateDoctorInfo(){
        selectOptionByValue(driver, doctorSpeciInpt, "Ayurveda");
    }
    public void clickOnUpdateDoctorBtn(){
        clickOnElement(driver, updateDoctorBtn);
    }
//    public String getDoctorUpdateSucessMsg(){
//        //*[@id="container"]/div/div/div[1]/h5
//    }
}