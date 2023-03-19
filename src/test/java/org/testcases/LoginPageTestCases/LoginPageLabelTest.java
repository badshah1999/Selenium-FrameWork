package org.testcases.LoginPageTestCases;

import org.base.Locators;
import org.junit.Assert;
import org.testcases.BaseTest;
import org.testng.annotations.Test;
public class LoginPageLabelTest extends BaseTest {

     /**
     * This will verify all the labels in the login page are displayed.
     */
     @Test
    public void labelVerification() throws InterruptedException {

        //test.log(Status.INFO,"Verifying the Username Label is Displayed");
        boolean user = isDisplayed(element(Locators.xpath, "//label[normalize-space()='Username']"));

        Assert.assertTrue("Username Label is Displayed",user);

        //test.log(Status.INFO,"Verifying the Password Label is Displayed");
        boolean pass = isDisplayed(element(Locators.xpath, "//label[normalize-space()='Password']"));
        Assert.assertTrue("Password Label is Displayed",pass);

        //test.log(Status.INFO,"Verifying the Submit Button is Displayed");
        boolean submit = isDisplayed(element(Locators.xpath, "//button[@type='submit']"));
        Assert.assertTrue("Submit Button is Displayed",submit);

        //test.log(Status.INFO,"Verifying the Forgot Password is Displayed");
        boolean forgot = isDisplayed(element(Locators.xpath, "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        Assert.assertTrue("Forgot Password is Displayed",forgot);
        Thread.sleep(3000);


    }
}
