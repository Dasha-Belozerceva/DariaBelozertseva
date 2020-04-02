package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class CommonMethods {
    protected WebDriver driver;

    @BeforeSuite
    public void setUpDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        // 1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html ");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    // 3. Perform login
    protected void performLogin(String login, String password){
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

   /*@AfterClass
   public void tearDown(){
        driver.close();
    }*/
}
