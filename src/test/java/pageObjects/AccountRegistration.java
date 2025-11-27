package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage{
    public AccountRegistration(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath="//input[@id='input-firstname']")
    WebElement txtFName;
    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement txtLName;
    @FindBy(xpath="//input[@id='input-email']")
    WebElement txtEmail;
    @FindBy(xpath="//input[@id='input-telephone']")
    WebElement txtPh;
    @FindBy(xpath="//input[@id='input-password']")
    WebElement txtPass;
    @FindBy(xpath="//input[@id='input-confirm']")
    WebElement txtCPass;
    @FindBy(xpath="//input[@name='agree']")
    WebElement chkPrivacy;
    @FindBy(xpath="//input[@value='Continue']")
    WebElement btnContinue;
    @FindBy(xpath="//a[normalize-space()='Continue']")
    WebElement chkCont;
    @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement btnLogout;


    public void setFName(String fname){
        txtFName.sendKeys(fname);
    }
    public void setLName(String lname){
        txtLName.sendKeys(lname);
    }
    public void setEmail(String email){
        txtEmail.sendKeys(email);
    }
    public void setPh(String ph){
        txtPh.sendKeys(ph);
    }
    public void setPass(String pass){
        txtPass.sendKeys(pass);
    }
    public void setCPass(String cpass){
        txtCPass.sendKeys(cpass);
    }
    public void clickPrivacy(){
        chkPrivacy.click();
    }
    public void clickCont(){
        btnContinue.click();
    }
    public void clickContinue(){
        chkCont.click();
    }
    public void clickLogout(){
        btnLogout.click();
    }

}
