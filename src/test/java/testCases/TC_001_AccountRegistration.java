package testCases;

import org.testng.annotations.Test;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void verify_AccReg() {

        HomePage hp = new HomePage(driver);   // uses BaseClass.driver
        hp.clickMyAcc();

        hp.clickRegister();

        AccountRegistration accreg = new AccountRegistration(driver);
        accreg.setFName(randomString().toUpperCase());
        accreg.setLName(randomString().toUpperCase());
        accreg.setEmail(randomString() + "@gmail.com");
        accreg.setPh(randomnumber());

        String password = randomAlphaNumeric();
        accreg.setPass(password);
        accreg.setCPass(password);

        accreg.clickPrivacy();
        accreg.clickCont();
        accreg.clickContinue();
        accreg.clickLogout();
}
}