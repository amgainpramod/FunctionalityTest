package testclasses;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageclasses.LoginPage;
import pageclasses.NavigationPage;
import test.utilies.WebDriverUtility;

public class LoginTest extends WebDriverUtility {
    String baseURL;
    LoginPage loginPage;
    NavigationPage navigationPage;

    @BeforeClass
    public void setUp(){
        baseURL = "https://letskodeit.com/";
        driver.get(baseURL);
        navigationPage = new NavigationPage(driver);
        loginPage = navigationPage.login();
    }

    @Test
    public void testLogin() {
        navigationPage = loginPage.signInWith("test@email.com", "abcabc");
        boolean result = navigationPage.isUserLoggedIn();
        Assert.assertTrue(result);
    }

    @Test
    public void testInvalidLogin() {
        navigationPage = loginPage.signInWith("test@email", "abcabc");
        boolean result = navigationPage.isUserLoggedIn();
        Assert.assertFalse(result);
    }

    @AfterMethod
    public void afterMethod(){
        if(navigationPage.isUserLoggedIn()){
            navigationPage.logOut();
            navigationPage.redirectToLogin();
        }
    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
    }


}
