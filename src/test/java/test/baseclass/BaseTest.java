package test.baseclass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageclasses.*;
import utilities.Constants;

public class BaseTest {
    public WebDriver driver;
    protected String baseURL;
    protected LoginPage loginPage;
    protected NavigationPage navigationPage;
    protected SearchByPage searchByPage;
    protected CategoryFilterPage categoryFilterPage;
    protected ResultsPage resultsPage;


    @BeforeClass
    @Parameters({"browser"})
    public void commonSetUp(String browser){
        driver = WebDriverFactory.getInstance().getDriver(browser);
        baseURL = Constants.BASE_URL;
        driver.get(baseURL);
        navigationPage = new NavigationPage(driver);
        loginPage = navigationPage.login();
    }

    //Before method for clearing Hash Map before every methods runs on every classes
    @BeforeMethod
    public void methodSetUp(){
        CheckPoint.clearHashMap();
    }

    @AfterClass
    public void commonTearDown(){
        WebDriverFactory.getInstance().quitDriver();
    }
}
