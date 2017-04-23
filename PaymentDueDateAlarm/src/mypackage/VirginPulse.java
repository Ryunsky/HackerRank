package mypackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import interfaces.Web;

public class VirginPulse implements Web {

    
    private String username;
    private String password;
    public VirginPulse (String username, String password){
        this.username = username;
        this.password = password;
    }
    @Override
    public String getWebLink() {
        // TODO Auto-generated method stub
        return "https://member.virginpulse.com/login.aspx";
    }

    @Override
    public void setWebLink() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getWebName() {
        // TODO Auto-generated method stub
        return "VirginPulse";
    }

    @Override
    public void setWebName() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void login(WebDriver driver) {
        // TODO Auto-generated method stub
        driver.get(getWebLink());
        WebElement userID = driver.findElement(By.id("oUserID"));
        WebElement passWD = driver.findElement(By.id("oPwdID"));
        WebElement passWD_click = driver.findElement(By.id("txtPlainPassword"));
        WebElement login = driver.findElement(By.id("oLogon"));
        userID.sendKeys(username);
        passWD_click.click();
        passWD.sendKeys(password);
        login.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

}
