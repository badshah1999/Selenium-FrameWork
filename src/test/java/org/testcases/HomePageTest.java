package org.testcases;

import org.base.Locators;
import org.testng.Assert;
import org.testng.annotations.Test;
public class HomePageTest extends LoginPageTest {

    @Test(dataProvider = "data")
    public void Validations(String data[]) throws InterruptedException {

        login(data);

        /**
         * This will verify all the side tab elements in the home page is displayed.
         */
        isDisplayed(element(Locators.xpath,"//span[normalize-space()='Recruitment']"));
        Assert.assertTrue(true);

        isDisplayed(element(Locators.xpath,"//span[normalize-space()='PIM']"));
        Assert.assertTrue(true);

        isDisplayed(element(Locators.xpath,"//span[normalize-space()='Leave']"));
        Assert.assertTrue(true);

        isDisplayed(element(Locators.xpath,"//span[normalize-space()='Time']"));
        Assert.assertTrue(true);

        isDisplayed(element(Locators.xpath,"//span[normalize-space()='Recruitment']"));
        Assert.assertTrue(true);

        isDisplayed(element(Locators.xpath,"//span[normalize-space()='My Info']"));
        Assert.assertTrue(true);

        isDisplayed(element(Locators.xpath,"//span[normalize-space()='Performance']"));
        Assert.assertTrue(true);

        isDisplayed(element(Locators.xpath,"//span[normalize-space()='Dashboard']"));
        Assert.assertTrue(true);

        isDisplayed(element(Locators.xpath,"//span[normalize-space()='Directory']"));
        Assert.assertTrue(true);

        isDisplayed(element(Locators.xpath,"//span[normalize-space()='Maintenance']"));
        Assert.assertTrue(true);

        isDisplayed(element(Locators.xpath,"//span[normalize-space()='Buzz']"));
        Assert.assertTrue(true);

    }


}
