package Base;

import framework.Configuration;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BaseTest {
    
protected static WebDriver driver;
    
    @BeforeClass
    public static void setUpClass() throws IOException {
//        LOGIN

        Configuration.init();
        System.setProperty("webdriver.opera.driver", Configuration.operaDriverPath);
        
        driver = new OperaDriver();
        driver.manage().window().maximize();
        driver.get("http://bvtest.school.cubes.rs/login");
    }
    
    @AfterClass
    public static void tearDownClass() throws InterruptedException {
//        Thread.sleep(200);
        driver.quit();
    }
    


}
