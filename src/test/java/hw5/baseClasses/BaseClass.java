package hw5.baseClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseClass {
    protected WebDriver driver;
    protected Properties propertyData;

    @BeforeSuite
    public void setUpDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setUp(){
        SingletonDriver.INSTANCE.createDriver("chrome");
        driver = SingletonDriver.INSTANCE.getDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        propertyData = new Properties();
        try {
            InputStream input = new FileInputStream("src/test/resources/hw5/hw5_data.properties");
            propertyData.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   @AfterClass
   public void tearDown(){
       SingletonDriver.INSTANCE.getDriver().close();
    }
}
