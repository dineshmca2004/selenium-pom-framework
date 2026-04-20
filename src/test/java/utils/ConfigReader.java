package utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private final Properties properties;
     public ConfigReader() {
         properties = new Properties();
         try{
             FileInputStream file = new FileInputStream("src/test/resources/config.properties");
             properties.load(file);
         } catch(FileNotFoundException e){
             throw new RuntimeException("File not found", e);
         }
         catch(IOException e){
             throw new RuntimeException("Failed to load config.properties file", e);
         }
     }
    public String getBrowser(){
         return properties.getProperty("browser");
    }

    public String getBaseUrl(){
         return properties.getProperty("url");
    }

}

