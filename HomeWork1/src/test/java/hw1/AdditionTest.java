package hw1;

import static org.testng.Assert.*;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdditionTest extends DataProviderTestClass {
    protected Calculator calculator;

    @BeforeMethod
    public void setCalculator(){
        calculator = new Calculator();
    }
    @Test(dataProvider = "calculator DataProvider with 2 double args")
    public void sumMethodTest(double a, double b){
        assertEquals(calculator.sum(a, b), a + b);
    }

    @AfterMethod
    public void tearDown(){
        calculator = null;
    }
}
