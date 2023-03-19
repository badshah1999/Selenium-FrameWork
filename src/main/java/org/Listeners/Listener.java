package org.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.utils.ExtentReport;

public class Listener implements ITestListener {
        ExtentReports extentReports;
        ExtentTest test;

        @Override
        public void onStart(ITestContext context) {
                extentReports = ExtentReport.generateReport();
        }

        @Override
        public void onTestStart(ITestResult result) {
                test = extentReports.createTest(result.getName());
                test.log(Status.INFO,result.getName()+" "+"Test Started Executing");
        }

        @Override
        public void onTestSuccess(ITestResult result) {
                test.log(Status.PASS,result.getName()+" "+"Test Case Passed");
        }

        @Override
        public void onTestFailure(ITestResult result) {
                test.log(Status.FAIL,result.getName()+" "+"Test Case Failed",
                        MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
                test.log(Status.INFO,result.getThrowable());
        }

        @Override
        public void onTestSkipped(ITestResult result) {
                test.log(Status.INFO,result.getThrowable());
                test.log(Status.SKIP,result.getName()+" "+"Test Case Skipped");
        }

        @Override
        public void onFinish(ITestContext context) {
            extentReports.flush();
        }

}
