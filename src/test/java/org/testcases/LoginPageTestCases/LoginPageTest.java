package org.testcases.LoginPageTestCases;

import org.base.Locators;
import org.junit.Assert;
import org.testcases.BaseTest;
import org.testng.annotations.*;

public class LoginPageTest extends BaseTest
{
    /**
     * This will pass the login credential data to the required fields
     */
    //ExtentTest test;
    @Test(dataProvider = "data")
    public void login(String data[]) throws InterruptedException {
        //test.log(Status.INFO,"Passing the Username Credential");
        type(element(Locators.xpath, "//input[@placeholder='Username']"), data[0]);
        //test.log(Status.INFO,"");

        //test.log(Status.INFO,"Passing the Password Credential");
        type(element(Locators.xpath, "//input[@placeholder='Password']"), data[1]);
        Assert.assertTrue(true);

        //test.log(Status.INFO,"Clicking the Login Button");
        click(element(Locators.xpath, "//button[@type='submit']"));
        Assert.assertTrue(true);

        //test.log(Status.INFO,"Verifying the Title of the Page");
        String title = getTitle();
//        if (title.equals("OrangeHRM")) {
//            test.log(Status.PASS, "Title is Verified");
//        }
//        else {
//            test.log(Status.FAIL,"Title is not Expected");
//            File screenshot = setTakesScreenshot("Title");
//            test.addScreenCaptureFromPath(String.valueOf(screenshot));
//        }
        Assert.assertEquals("OrangeHRM",title);
        Thread.sleep(3000);
    }
}
