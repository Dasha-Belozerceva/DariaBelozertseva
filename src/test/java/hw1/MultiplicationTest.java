package hw1;

import static org.testng.Assert.*;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiplicationTest extends DataProviderTestClass {

    protected Calculator calculator;

    @BeforeMethod
    public void setCalculator(){
        calculator = new Calculator();
    }

    @Test(dataProvider = "calculator DataProvider with 2 double args")
    public void multDoubleArgsMethodTest(double a, double b){
        assertNotEquals(calculator.mult(a, b), a * b);
    }

    @Test(dataProvider = "calculator DataProvider with 2 args, which multiplication gives integer result")
    public void multIntegerArgsMethodTest(double a, double b){
        assertEquals(calculator.mult(a, b), a * b);
    }

    @AfterMethod
    public void tearDown(){
        calculator = null;
    }
}
