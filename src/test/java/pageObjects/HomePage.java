package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    WebDriver driver;
    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement linkMyAcc;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement linkRegister;
    @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
    WebElement linkLogin;

    public void clickMyAcc() {
        linkMyAcc.click();
    }

    public void clickRegister() {
        linkRegister.click();
    }
    public void clickLogin() {
        linkLogin.click();
    }
}
