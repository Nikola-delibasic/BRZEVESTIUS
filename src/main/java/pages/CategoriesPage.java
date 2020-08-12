
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriesPage {
    private final WebDriver driver;
    private final By panelHeadingLocator = By.className("panel-heading");
    
    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
    }
        public String getPanelHeadingText(){
        return driver.findElement(panelHeadingLocator).getText();
    }
    
}
