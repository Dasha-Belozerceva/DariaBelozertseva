package hw1;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class AdditionTest extends DataProviderTestClass {
    @Test(dataProvider = "calculator DataProvider with 2 double args")
    public void sumMethodTest(double a, double b){
        assertEquals(calculator.sum(a, b), a + b);
    }
}
