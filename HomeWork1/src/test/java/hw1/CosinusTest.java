package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CosinusTest extends DataProviderTestClass{
    @Test(dataProvider = "calculator DataProvider with 1 arg")
    public void wrongCosMethodTest(double a){
        Assert.assertNotEquals(calculator.cos(a), Math.cos(a)) ;
    }
}
