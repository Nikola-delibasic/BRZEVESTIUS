package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    
    public static String operaDriverPath;
    public static String validAdminUserEmail;
    public static String validAdminUserPassword;
    
    
public static void init() throws FileNotFoundException, IOException{
    Properties properties = new Properties();
    FileInputStream fis = new FileInputStream("env.properties");
        
    properties.load(fis);
        
    operaDriverPath = properties.getProperty("operaDriverPath");
    validAdminUserEmail = properties.getProperty("validAdminUserEmail");
    validAdminUserPassword = properties.getProperty("validAdminUserPassword");
    }
    
    
}

//configuration.init();