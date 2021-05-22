package testclasses;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageclasses.CategoryFilterPage;
import pageclasses.SearchByPage;
import test.baseclass.BaseTest;

public class AllCoursesTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        navigationPage = loginPage.signInWith("test@email.com", "abcabc");
    }

    @Test
    public void searchByInput() throws InterruptedException {
        navigationPage.scrollPage();
        searchByPage = new SearchByPage(driver);
        resultsPage = searchByPage.searchCourse("rest api");

        boolean searchResult = resultsPage.verifySearchResult();
        Assert.assertTrue(searchResult);
    }

    @Test()
    public void searchByCategory(){
        navigationPage.scrollPage();
        categoryFilterPage = new CategoryFilterPage(driver);
        resultsPage = categoryFilterPage.selectCategory("Sofware Testing");
        boolean categoryResults = resultsPage.verifySearchResult();
        Assert.assertTrue(categoryResults);

    }
}
