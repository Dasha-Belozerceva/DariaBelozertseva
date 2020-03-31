package hw1;

import static org.testng.Assert.*;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CosinusTest extends DataProviderTestClass{
    protected Calculator calculator;

    @BeforeMethod
    public void setCalculator(){
        calculator = new Calculator();
    }

    @Test(dataProvider = "calculator DataProvider with 1 arg")
    public void wrongCosMethodTest(double a){
        assertNotEquals(calculator.cos(a), Math.cos(a)) ;
    }


    @AfterMethod
    public void tearDown(){
        calculator = null;
    }
}
