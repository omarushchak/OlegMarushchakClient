package com.epam.lab.service.util;

import org.apache.log4j.Logger;
import org.testng.*;
import org.testng.xml.XmlSuite;


import java.util.List;

public class TestNGListener implements ITestListener, IReporter {
    private static final Logger LOGGER = Logger.getLogger(TestNGListener.class);

    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info("test starts " + iTestResult.getName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.info("test passed " + iTestResult.getName() + " during time " + (iTestResult.getEndMillis() - iTestResult.getStartMillis()));
    }

    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.info("test failed " + iTestResult.getTestName());
    }

    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.info("test skipped " + iTestResult.getTestName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
        LOGGER.info("test starts " + iTestContext.getName() +" on " + iTestContext.getStartDate());
    }

    public void onFinish(ITestContext iTestContext) {
        LOGGER.info("test ends " + iTestContext.getName() +" on" + iTestContext.getEndDate());
    }

    public void generateReport(List<XmlSuite> list, List<ISuite> list1, String s) {

    }
}

