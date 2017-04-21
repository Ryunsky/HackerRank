package mypackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import interfaces.Web;

public class PaymentDueDateAlarm {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "/Users/ehklmqf/Documents/jar/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        GetUserAndPassword data = new GetUserAndPassword("/Users/ehklmqf/data.properties");
        Web rogers = new Rogers(data.getProperties("rogers_user"),
                                        data.getProperties("rogers_password"));
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        driver.navigate().to("https://member.virginpulse.com/login.aspx?");
//        WebElement userID = driver.findElement(By.id("oUserID"));
//        WebElement passWD1 = driver.findElement(By.id("oPwdID"));
//        WebElement passWD = driver.findElement(By.id("txtPlainPassword"));
//        userID.sendKeys("yuanyun.chen@hotmail.com");
//        WebElement logIn = driver.findElement(By.id("oLogon"));
//        
//        passWD.click();
//        passWD1.sendKeys("");
//        logIn.click();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.close();
        
        //https://www.rogers.com/web/totes/#/signin
        rogers.login(driver);
//        driver.close();
    }

}
