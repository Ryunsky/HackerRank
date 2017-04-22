package interfaces;

import org.openqa.selenium.WebDriver;

public interface Web {
    
    //get web link
    public String getWebLink();
    
    //set web link
    public void setWebLink();
    
    //get web name
    public String getWebName();
    
    //set web name
    public void setWebName();
    
    //login

    public void login(WebDriver driver);

}
