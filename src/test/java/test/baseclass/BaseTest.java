package test.baseclass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageclasses.*;

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
        driver = WebDriverFactory.getInstance().getDriver("chrome");
        baseURL = "https://letskodeit.com/";
        driver.get(baseURL);
        navigationPage = new NavigationPage(driver);
        loginPage = navigationPage.login();
    }

    @AfterClass
    public void commonTearDown(){
        WebDriverFactory.getInstance().quitDriver();
    }
}
