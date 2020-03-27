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

    @DataProvider(name = "calculator DataProvider with 2 double args")
    public static Object[][] calculatorDoubleDataProviderWithTwoArgs(){
        return new Object[][] {
                {0.01, 10},
                {5.4565, 9.17},
                {-100000.3, 200000.988},
                {-5.45, 45},
                {56.00002, 0.0003}};
    }

    @DataProvider(name = "calculator DataProvider with 2 args, which multiplication gives integer result")
    public static Object[][] calculatorIntegerDataProviderWithTwoArgs(){
        return new Object[][] {
                {5, 10},
                {0, 917},
                {-100000, 200000},
                {-500, 45},
                {56, -10},
                {0.1, 10}};
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
