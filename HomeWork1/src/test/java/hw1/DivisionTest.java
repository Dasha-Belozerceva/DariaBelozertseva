package hw1;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class DivisionTest extends DataProviderTestClass {
    @Test(dataProvider = "calculator DataProvider with 2 double args")
    public void divMethodTest(double a, double b){
        assertEquals(calculator.div(a, b), a / b);
    }
}
