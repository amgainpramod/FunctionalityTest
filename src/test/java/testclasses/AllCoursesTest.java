package testclasses;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageclasses.*;
import test.utilies.WebDriverUtility;

public class AllCoursesTest extends WebDriverUtility {

    String baseURL;
    LoginPage loginPage;
    NavigationPage navigationPage;
    SearchByPage searchByPage;
    ResultsPage resultsPage;
    CategoryFilterPage categoryFilterPage;

    @BeforeClass
    public void setUp() {
        baseURL = "https://letskodeit.com/";
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseURL);
        navigationPage = new NavigationPage(driver);
        loginPage = navigationPage.login();
        navigationPage = loginPage.signInWith("test@email.com", "abcabc");
        resultsPage = new ResultsPage(driver);
        searchByPage = new SearchByPage(driver);
        categoryFilterPage = new CategoryFilterPage(driver);

    }

    @Test
    public void searchByInput() throws InterruptedException {
        //navigationPage.goToNavigation();
        //navigationPage.goToMyCourses();

        navigationPage.scrollPage();


        //Below method uses NavigationPage Class
        //Search course
        resultsPage = searchByPage.searchCourse("rest api");

        //Below method uses ResultsPage Class
        //verify the result
        boolean searchResult = resultsPage.verifyInputSearchResult();
        Assert.assertTrue(searchResult);

    }

    @Test()
    public void searchByCategory(){
        navigationPage.scrollPage();
        resultsPage = categoryFilterPage.selectCategory("Sofware Testing");
        boolean categoryResults = resultsPage.verifyCategorySearchResult();
        Assert.assertTrue(categoryResults);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
