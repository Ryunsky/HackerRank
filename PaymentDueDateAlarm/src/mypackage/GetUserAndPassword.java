package mypackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetUserAndPassword {
    
    private Properties prop;
    
    public GetUserAndPassword (String fileName) {
        try {
            prop = new Properties();
            prop.load(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getProperties(String key){
        return prop.getProperty(key);
    }
}
