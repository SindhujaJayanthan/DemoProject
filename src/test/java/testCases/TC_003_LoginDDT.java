package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups = "DataDriven")
    public void verify_Login(String email, String pwd, String exp){
        HomePage hp=new HomePage(driver);
        hp.clickMyAcc();
        hp.clickLogin();

        LoginPage lp=new LoginPage(driver);
        lp.setUName(email);
        lp.setPwd(pwd);
        lp.clickLogin();
        AccountRegistration accreg=new AccountRegistration(driver);

        MyaccountPage myAcc=new MyaccountPage(driver);
        boolean targetMsg=myAcc.isMyAccount();
        if(exp.equalsIgnoreCase("Valid")){
            if(targetMsg==true){
                Assert.assertTrue(true);
                accreg.clickLogout();
            }else {
                Assert.assertTrue(false);
            }
        }
        if(exp.equalsIgnoreCase("InValid")){
            if(targetMsg==true){
                Assert.assertTrue(false);
                accreg.clickLogout();
            }else {
                Assert.assertTrue(true);
            }
        }
    }
}
