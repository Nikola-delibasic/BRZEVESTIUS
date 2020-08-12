
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import framework.Helper;


public class Firstjunittest {
    
    private static WebDriver driver;
    
    public Firstjunittest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
//    Driver initialise    
        driver = new OperaDriver();
        driver.manage().window().maximize();
//        Go to URL
        driver.get("http://bvtest.school.cubes.rs/login");
         
//    Test step 1   
        System.out.println("Title:" + driver.getTitle()); 
        System.out.println("URL" + driver.getCurrentUrl());

//    Test step 1.1        
        WebElement emailField = driver.findElement(By.name("email")); 
        emailField.sendKeys("qa@cubes.rs");

//    Test step 1.2 password field
        WebElement passwordField = driver.findElement(By.name("password"));  
        passwordField.sendKeys("cubesqa");

//    Test step 1.3 button click login
        WebElement loginButton = driver.findElement(By.className("btn-primary"));
        loginButton.click();
    }
    
    @AfterClass
    public static void tearDownClass() {
//        Exit driver
        
    }
    
    @Before
    public void setUp() {
        System.out.println("Hi,I'm setup method");
    }
    
    @After
    public void tearDown() {
        System.out.println("Hi,I'm teardown method");
    }

// TODO add test methods here.
// The methods must be annotated with annotation @Test. For example:
//
     @Test
     public void hello() {
        System.out.println("Hi,HELLO test.");
     }
     
     
//     LOGIN TEST
     @Test
     public void testLogin(){
        System.out.println("Hi,LOGIN test.");
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();
           
        assertEquals("URL's doesn't match.", expectedUrl, actualUrl);     
     }
     
     @Test
     public void testAddNewCategory(){
       System.out.println("Hi,ADD NEW CATEGORY test.");
         
//    Test step 1.4:category     
       WebElement categoriesLink = driver.findElement(By.linkText("Categories"));
       categoriesLink.click();
       
//    Test step 1.5:add category
       WebElement addCategoryLink = driver.findElement(By.className("pull-right"));
       addCategoryLink.click();
       
//    Test step 1.6:add category 
       WebElement addTitle = driver.findElement(By.id("title"));
       addTitle.sendKeys(Helper.getRandomText());

//    Test step 1.6:click save    
       WebElement saveButton = driver.findElement(By.id("save-category-button"));
       saveButton.click();
       
////   expected result/actual result   

        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: is" + driver.getCurrentUrl() + ".");
    
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        
        assertEquals("URL's doesn't match.", expectedUrl, actualUrl); 
        
        String expectedMessageSnippet = "Nikola";
        WebElement alertMessageElement = driver.findElement(By.className("alert-success"));
        String alertMessageText = alertMessageElement.getText();
        
        assertTrue("Alert message is bad.", alertMessageText.contains(expectedMessageSnippet));
     
     }
}
