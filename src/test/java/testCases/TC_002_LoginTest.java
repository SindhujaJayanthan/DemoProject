package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

    @Test(groups = {"Sanity","Master"})
    public void verify_login(){
        HomePage hp=new HomePage(driver);
        hp.clickMyAcc();
        hp.clickLogin();

        LoginPage lp=new LoginPage(driver);
        lp.setUName(prop.getProperty("username"));
        lp.setPwd(prop.getProperty("password"));
        lp.clickLogin();

        MyaccountPage myAcc=new MyaccountPage(driver);
        boolean targetMsg=myAcc.isMyAccount();
        //Assert.assertEquals(targetMsg,"My Account");
        Assert.assertTrue(targetMsg);

    }
}
