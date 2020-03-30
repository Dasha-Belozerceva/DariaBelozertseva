package hw1;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class ExponentiationTest extends DataProviderTestClass{
    @Test(dataProvider = "calculator DataProvider with 2 double args")
    public void powMethodTest(double a, double b){
        assertEquals(calculator.pow(a, b), Math.pow(a, Math.floor(b)));
    }
}
