package Login;

import org.junit.Test;
import Base.BaseTest;
import junit.framework.Assert;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTests extends BaseTest{
    
    private boolean loggedIn = false;
    
    @Before
    public void setUp(){
        
    }
    
    @After
    public void tearDown(){
       if (loggedIn){
            System.out.println("U IF petlji.");
       } 
    }
    
    @Test
    public void testValidLogin(){
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();  
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLogin();
        
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();    
        assertEquals("URL's doesn't match.", expectedUrl, actualUrl);
        
        DashboardPage dashboardPage = new DashboardPage(driver);
        String expectedPanelHeadingText = "Dashboard";
        String actualPanelHeadingText = dashboardPage.getPanelHeadingText();
        assertTrue("Wrong panel heading text.",expectedPanelHeadingText.equals(actualPanelHeadingText));
         
        
        dashboardPage.logout();
        driver.get("http://bvtest.school.cubes.rs/login");
    }
    
    @Test
    public void testEmptyFieldsLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();
                    
        String expectedUrl = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match.", expectedUrl, actualUrl);
        
        String expectedEmailMassage = "These credentials do not match our records.";
        String actualEmailMassage = loginPage.getEmailMessageText();
        Assert.assertTrue("Failed - Email message's doesn't match", expectedEmailMassage.equals(actualEmailMassage));      

               
    }
    
    @Test
    public void testValidEmailInvalidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfNonExistingUser();
        loginPage.clickLogin();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match.", expectedUrl, actualUrl);
        
        String expectedEmailMassage = "These credentials do not match our records.";
        String actualEmailMassage = loginPage.getEmailMessageText();
        Assert.assertTrue("Failed - Email message's doesn't match", expectedEmailMassage.equals(actualEmailMassage));    
        
//        1.enter VALID email in email field
//  2.ENTER INVALID PASSWORD IN PASSWORD FIELD
//CLICK ON LOGIN BUTTON
//EXPECTED RESULT:NOT LOGGED IN AND SHOWS A MESSAGE
    }
    
    @Test 
    public void testInvalidEmailValidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterInvalidEmail();
        loginPage.enterPasswordOfNonExistingUser();
        loginPage.clickLogin();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match.", expectedUrl, actualUrl);
        
        String expectedEmailMassage = "These credentials do not match our records.";
        String actualEmailMassage = loginPage.getEmailMessageText();
        Assert.assertTrue("Failed - Email message's doesn't match", expectedEmailMassage.equals(actualEmailMassage));    
        //        1.enter invalid email in email field
//  2.ENTER INVALID PASSWORD IN PASSWORD FIELD
//CLICK ON LOGIN BUTTON
//EXPECTED RESULT:NOT LOGGED IN AND SHOWS A MESSAGE
    }
    
    @Test
    public void testInvalidEmailInvalidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterInvalidEmail();
        loginPage.enterPasswordOfNonExistingUser();
        
        //        1.enter invalid email in email field
//  2.ENTER VALID PASSWORD IN PASSWORD FIELD
//CLICK ON LOGIN BUTTON
//EXPECTED RESULT:NOT LOGGED IN AND SHOWS A MESSAGE
    }
    
    @Test
    public void testCustomDataLogin(){
        LoginPage loginPage = new LoginPage(driver);
        
    }
    
//    Valid email,empty pw
    @Test
    public void testValidEmailEmptyPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.clickLogin();
        
        String expectedwrongPasswordMessage = "The password field is required.";
        String actualPasswordMessage = loginPage.getWrongPasswordText();
        Assert.assertTrue("Failed - Password message's doesn't match",expectedwrongPasswordMessage.equals(actualPasswordMessage));

    }
}
