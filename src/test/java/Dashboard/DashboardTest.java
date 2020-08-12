/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dashboard;

import Base.BaseTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SignaturesPage;

/**
 *
 * @author joshu
 */
public class DashboardTest extends BaseTest {
    
    public DashboardTest() {
    }
    
    private static DashboardPage dashboardPage;
    
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLogin();
        
        dashboardPage = new DashboardPage(driver);
    }
    
    @After
    public void tearDown() {
        
        dashboardPage.logout();
    }

    @Test
    public void testDashboardLink(){
//        1.click on dashboard link in nav bar
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickOnDashboardNavLink();
        
        
//        expected result > be on dashboard page
        String expectedPanelHeadingText = "Dashboard";
        String actualPanelHeadingText = dashboardPage.getPanelHeadingText();
        assertTrue("Wrong panel heading text.",expectedPanelHeadingText.equals(actualPanelHeadingText));
        

    }   
    
    @Test
    public void testSignaturesLink(){
        dashboardPage.clickOnSignaturesNavLink();
        SignaturesPage signaturesPage = new SignaturesPage(driver);
        
//        
        SignaturesPage signaturesPage2 = dashboardPage.clickOnSignaturesNavLink2();
//        
//        
        
        String expectedPanelHeadingText = "Signatures";
        String actualPanelHeadingText = signaturesPage.getPanelHeadingText();
        assertTrue("Wrong panel heading text.",expectedPanelHeadingText.equals(actualPanelHeadingText));
        
    }
    
    @Test
    public void testCategoriesLink(){
        dashboardPage.clickOnCategoriesNavLink();
    }   
}

