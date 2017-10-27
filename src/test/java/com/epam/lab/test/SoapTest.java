package com.epam.lab.test;

import com.epam.lab.service.soap.CalculatorSoapServiceImpl;
import com.epam.lab.service.soap.CalculatorSoapServiceImplService;
import com.epam.lab.service.util.TestNGListener;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Listeners({TestNGListener.class})
public class SoapTest {

    private static final Logger LOGGER = Logger.getLogger(SoapTest.class);

    CalculatorSoapServiceImpl calcService = null;
    NumberFormat format = null;
    Number number = null;

    @BeforeTest
    public void setUp() {
        calcService = new CalculatorSoapServiceImplService().getCalculatorSoapServiceImplPort();
        format = NumberFormat.getInstance(Locale.FRANCE);
        number = null;
    }

    @Test
    public void soapAddTest_ValidValuesPassed_ShouldPass() {
        try {
            number = format.parse((calcService.add(10, 10)));
        } catch (ParseException e) {
            LOGGER.error(e);
        }

        double result = number.doubleValue();
        double expectedResult = 20.0;
        LOGGER.info("Expected result = " + expectedResult + " and actual = " + result);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void soapSubtractTest_ValidValuesPassed_ShouldPass() {
        try {
            number = format.parse((calcService.subtract(20, 10)));
        } catch (ParseException e) {
            LOGGER.error(e);
        }

        double result = number.doubleValue();
        double expectedResult = 10.0;
        LOGGER.info("Expected result = " + expectedResult + " and actual = " + result);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void soapDivideTest_ValidValuesPassed_ShouldPass() {
        try {
            number = format.parse((calcService.divide(100, 10)));
        } catch (ParseException e) {
            LOGGER.error(e);
        }

        double result = number.doubleValue();

        double expectedResult = 10.0;
        LOGGER.info("Expected result = " + expectedResult + " and actual = " + result);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void soapMultiplyTest_ValidValuesPassed_ShouldPass() {
        try {
            number = format.parse((calcService.multiply(5, 10)));
        } catch (ParseException e) {
            LOGGER.error(e);
        }

        double result = number.doubleValue();

        double expectedResult = 100.0;
        LOGGER.info("Expected result = " + expectedResult + " and actual = " + result);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void soapPercentageTest_ValidValuesPassed_ShouldPass() {
        try {
            number = format.parse((calcService.percentage(5, 3)));
        } catch (ParseException e) {
            LOGGER.error(e);
        }

        double result = number.doubleValue();

        double expectedResult = 2.0;
        LOGGER.info("Expected result = " + expectedResult + " and actual = " + result);
        Assert.assertEquals(expectedResult, result);
    }

}
