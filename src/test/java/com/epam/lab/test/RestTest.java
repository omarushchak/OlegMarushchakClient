package com.epam.lab.test;

import com.epam.lab.service.RestRequestSender;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RestTest {
    private static final Logger LOGGER = Logger.getLogger(RestTest.class);
    private String restBaseUrl;
    RestRequestSender restRequestSender;

    @BeforeTest
    public void setUp() {
        restBaseUrl = "http://localhost:8091/RestService/rest/calc";
        restRequestSender = new RestRequestSender();
    }

    @Test
    public void restPlusTest_ValidValuesPassed_ShouldPass() {
        double firstN = 5;
        double secondN = 10;
        double expectedResult = 15.0;
        double result = restRequestSender.sendRequestAndGetResult(restBaseUrl + "/add/" + firstN + "/" + secondN);

        LOGGER.info("Expected result = " + expectedResult + " and actual = " + result);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void restMinusTest_ValidValuesPassed_ShouldPass() {
        double firstN = -10;
        double secondN = -15;
        double expectedResult = 5.0;
        double result = restRequestSender.sendRequestAndGetResult(restBaseUrl + "/subtract/" + firstN + "/" + secondN);

        LOGGER.info("Expected result = " + expectedResult + " and actual = " + result);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void restDivisionTest_ValidValuesPassed_ShouldPass() {
        double firstN = 20;
        double secondN = 10;
        double expectedResult = 2;
        double result = restRequestSender.sendRequestAndGetResult(restBaseUrl + "/divide/" + firstN + "/" + secondN);

        LOGGER.info("Expected result = " + expectedResult + " and actual = " + result);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void restMultiplicationTest_ValidValuesPassed_ShouldPass() {
        double firstN = 20;
        double secondN = 10;
        double expectedResult = 200;
        double result = restRequestSender.sendRequestAndGetResult(restBaseUrl + "/multiply/" + firstN + "/" + secondN);

        LOGGER.info("Expected result = " + expectedResult + " and actual = " + result);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void restPercentTest_ValidValuesPassed_ShouldPass() {
        double firstN = 222;
        double secondN = 5;
        double expectedResult = 2.0;
        double result = restRequestSender.sendRequestAndGetResult(restBaseUrl + "/percentage/" + firstN + "/" + secondN);

        LOGGER.info("Expected result = " + expectedResult + " and actual = " + result);
        Assert.assertEquals(expectedResult, result);
    }
}
