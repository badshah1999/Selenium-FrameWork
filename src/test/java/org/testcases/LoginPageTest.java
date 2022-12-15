package org.testcases;

import org.base.BaseClass;
import org.base.Browser;
import org.base.Locators;
import org.junit.Assert;
import org.testng.annotations.*;
import org.utils.ExcelData;

import java.io.IOException;

public class LoginPageTest extends BaseClass
{
    @DataProvider(name = "data")
    public Object[][] dataprovider() throws IOException {
        Object[][] readData = ExcelData.getExcel("/Users/badshah.p/Desktop/PageObjectModel.xlsx");
        return readData;
    }

    @BeforeMethod
    public void startUp(){
        setUp(Browser.CHROME,"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @AfterMethod
    public void terminate() throws InterruptedException {
        Thread.sleep(3000);
        close();
    }


    /**
     * This will pass the login credential data to the required fields
     */
    @Test(dataProvider = "data",dependsOnMethods = {"labelVerification"})
    public void login(String data[]) throws InterruptedException {

        type(element(Locators.xpath, "//input[@placeholder='Username']"), data[0]);
        Assert.assertTrue(true);

        type(element(Locators.xpath, "//input[@placeholder='Password']"), data[1]);
        Assert.assertTrue(true);

        click(element(Locators.xpath, "//button[@type='submit']"));
        Assert.assertTrue(true);

        String title = getTitle();
        Assert.assertEquals("OrangeHRM", title);
        Thread.sleep(3000);

    }

    /**
     * This will verify all the labels in the login page are displayed.
     */
    @Test
    public void labelVerification() throws InterruptedException {

        isDisplayed(element(Locators.xpath, "//label[normalize-space()='Username']"));
        Assert.assertTrue(true);

        isDisplayed(element(Locators.xpath, "//label[normalize-space()='Password']"));
        Assert.assertTrue(true);

        isDisplayed(element(Locators.xpath, "//button[@type='submit']"));
        Assert.assertTrue(true);

        isDisplayed(element(Locators.xpath, "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        Assert.assertTrue(true);
        Thread.sleep(3000);

    }
}
