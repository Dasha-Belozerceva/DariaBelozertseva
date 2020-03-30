package hw1;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class SubstractionTest extends DataProviderTestClass {
    @Test(dataProvider = "calculator DataProvider with 2 double args")
    public void subMethodTest(double a, double b){
        assertEquals(calculator.sub(a, b), a - b);
    }
}
