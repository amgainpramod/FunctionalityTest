package test.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageclasses.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    protected String baseURL;
    protected LoginPage loginPage;
    protected NavigationPage navigationPage;
    protected SearchByPage searchByPage;
    protected CategoryFilterPage categoryFilterPage;
    protected ResultsPage resultsPage;

    @BeforeClass
    public void commonSetUp(){
        baseURL = "https://letskodeit.com/";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(baseURL);
        navigationPage = new NavigationPage(driver);
        loginPage = navigationPage.login();
    }

    @AfterClass
    public void commonTearDown(){
        driver.quit();
    }
}
