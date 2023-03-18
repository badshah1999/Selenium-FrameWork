package org.testcases;

import org.base.BaseClass;
import org.base.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.utils.ExcelData;

import java.io.IOException;

public class BaseTest extends BaseClass {
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
}
