package org.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReport {
    public static ExtentReports generateReport() {
        Property property = new Property();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./test-output/Extent-Report");
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentSparkReporter.config()
                .setReportName(property.readPropertyFile().getProperty("ReportName"));
        extentSparkReporter.config()
                .setDocumentTitle(property.readPropertyFile().getProperty("PageTitle"));
        extentSparkReporter.config()
                .setTimeStampFormat(property.readPropertyFile().getProperty("TimeStamp"));
        extentReports
                .setSystemInfo("Application URL:", property.readPropertyFile().getProperty("URL"));
        extentReports
                .setSystemInfo("Environment:",property.readPropertyFile().getProperty("Env"));
        extentReports
                .setSystemInfo("UserName:",System.getProperty("user.name"));
        extentReports
                .setSystemInfo("Operating System:",System.getProperty("os.name"));
        extentReports
                .setSystemInfo("Java Version:",System.getProperty("java.version"));
        return extentReports;
    }

}
