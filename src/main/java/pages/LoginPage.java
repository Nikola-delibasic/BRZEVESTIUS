package pages;

import framework.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import framework.Helper;

public class LoginPage {
//    //*[@id="app-layout"]/div/div/div/div/div[2]/form/div[1]/div/span/strong
    private WebDriver driver;
    private final By emailFieldLocator = By.name("email");
    private final By passwordFieldLocator = By.name("password");
//    remember me
    private final By rememberButton = By.name("remember");
//    login button
    private final By loginButton = By.className("btn-primary");
    private final By emailMessageLocator = By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[1]/div/span/strong");
    
    private final By wrongPasswordLocator = By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[2]/div/span/strong");
    
        //*[@id="app-layout"]/div/div/div/div/div[2]/form/div[1]/div/span/strong
        public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    
    public void enterEmailOfValidUser(){        
        driver.findElement(emailFieldLocator).sendKeys(Configuration.validAdminUserEmail);
    }
    
    
    public void enterInvalidEmail(){
       driver.findElement(emailFieldLocator).sendKeys(Helper.getRandomEmail());
    }
    
    public void enterPasswordOfValidUser(){
        driver.findElement(passwordFieldLocator).sendKeys(Configuration.validAdminUserPassword);
    }
    
    public void enterPasswordOfNonExistingUser(){
        driver.findElement(passwordFieldLocator).sendKeys(Helper.getRandomText());
    }
    
    
//    click on remember me
    public void clickRemember(){
        driver.findElement(rememberButton).click();
    }
//    click on login   
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
    
    
    public String getEmailMessageText(){
        return driver.findElement(emailMessageLocator).getText();
    }
    
    public String getWrongPasswordText(){
        return driver.findElement(wrongPasswordLocator).getText();
    }
}

