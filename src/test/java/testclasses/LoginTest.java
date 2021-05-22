package testclasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.baseclass.BaseTest;

public class LoginTest extends BaseTest {

    @BeforeClass
    public void setUp(){

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
}
