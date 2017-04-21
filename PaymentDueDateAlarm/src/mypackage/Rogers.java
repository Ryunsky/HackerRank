package mypackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import interfaces.Web;

public class Rogers implements Web {
    
    
    private String username;
    private String password;
    public Rogers(String username, String password){
        this.username = username;
        this.password = password;
    }
    @Override
    public String getWebLink() {
        // TODO Auto-generated method stub
        return "https://www.rogers.com/web/totes/#/signin";
    }

    @Override
    public void setWebLink() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getWebName() {
        // TODO Auto-generated method stub
        return "Rogers";
    }

    @Override
    public void setWebName() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void login(WebDriver driver) {
        // TODO Auto-generated method stub
        driver.get(getWebLink());
        WebElement userID = driver.findElement(By.id("USER"));
        WebElement passWD = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.xpath(".//button[@class='cta-round primary medium full overrite']"));
        userID.sendKeys(username);
        passWD.sendKeys(password);
        login.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

}
