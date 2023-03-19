package org.testcases;

import org.base.BaseClass;
import org.base.Browser;
import org.testng.annotations.*;
import org.utils.ExcelData;
import org.utils.Property;
import java.io.IOException;

public class BaseTest extends BaseClass {
    Property property = new Property();

    @DataProvider(name = "data")
    public Object[][] dataprovider() throws IOException {
        Object[][] readData = ExcelData.getExcel("/Users/badshahkhan/downloads/OrangeHRM.xlsx");
        return readData;
    }

    @BeforeMethod
    public void startUp(){
        //report.createTest("Opening Browser","Badshah","Smoke");
        //test.log(Status.INFO,"Navigating to Selected Browser");
        setUp(Browser.CHROME, property.readPropertyFile().getProperty("URL"));
    }
    @AfterMethod
    public void terminate(){
        quit();
    }

}
