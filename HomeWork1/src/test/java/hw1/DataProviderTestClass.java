package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class DataProviderTestClass {
    protected Calculator calculator;

    @BeforeMethod
    public void setCalculator(){
        calculator = new Calculator();
    }

    @DataProvider(name = "calculator DataProvider with 2 args")
    public static Object[][] calculatorDataProviderWithTwoArgs(){
        return new Object[][] {
                {0.1, 10},
                {5, 9},
                {-100000, 200000},
                {-5.45, 45},
                {56, 0}};
    }

    @DataProvider(name = "calculator DataProvider with 1 arg")
    public static Object[][] calculatorDataProviderWithOneArg(){
        return new Object[][]{
                {5},
                {0.0001},
                {-1000},
                {100000}
        };
    }
}
