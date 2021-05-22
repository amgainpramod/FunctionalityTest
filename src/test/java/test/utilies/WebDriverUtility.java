package test.utilies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class WebDriverUtility {
    public static WebDriver driver;

    @BeforeSuite
    public void beforeAllClasses(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void afterAllClasses(){
        driver.quit();
    }
}
