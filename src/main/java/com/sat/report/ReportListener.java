package com.sat.report;

import com.aventstack.extentreports.service.ExtentTestManager;
//import com.sat.driver.DriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

public class ReportListener implements ITestListener{
    @Override
    public synchronized void onStart(ITestContext context) {
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        reportPrint();
    }
    
    @Override
    public synchronized void onTestFailure(ITestResult result) {
        reportPrint();
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }
    
    private void reportPrint() {
        ExtentTestManager.getTest().addScreenCaptureFromBase64String(takeScreenshot());
    }

    private String takeScreenshot() {
        //return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
        return "";
    }
}
