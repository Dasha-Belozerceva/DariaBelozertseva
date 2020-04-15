package hw4;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    protected WebDriver driver;
    protected Properties loginData;
    protected final static String web_site = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeSuite
    public void setUpDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        // 1. Open test site by URL
        driver.get(web_site);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        loginData = new Properties();
        try {
            InputStream input = new FileInputStream("src/test/resources/hw4/hw4_data.properties");
            loginData.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
