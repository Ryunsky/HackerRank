package mypackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
    public void login(WebDriver driver) throws NoSuchElementException, InterruptedException {
        // TODO Auto-generated method stub
        driver.get(getWebLink());
        Actions action = new Actions(driver);
        WebElement userID = driver.findElement(By.id("oUserID"));
        WebElement passWD = driver.findElement(By.id("oPwdID"));
        WebElement passWD_click = driver.findElement(By.id("txtPlainPassword"));
        userID.sendKeys(username);
        passWD_click.click();
        passWD.sendKeys(password);
        Thread.sleep(1000);
        WebElement login = driver.findElement(By.id("oLogon"));
        login.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        dailyCard(driver);
        healthHibit(driver, action);
    }
    
    public void dailyCard (WebDriver driver) throws InterruptedException {
        try{
            driver.findElement(By.xpath(".//div[contains(@ng-click, 'toggleDailyTips()')]")).click();
            driver.findElement(By.xpath(".//div[contains(@ng-click, 'toggleDailyTips()')]")).click();
            List<WebElement> card = driver.findElements(By.xpath(".//button[@id='triggerCloseCurtain']"));
            for (int i =0 ; i < card.size(); i++){
                WebElement e = card.get(i);
                e.click();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                System.out.println("here");
                Thread.sleep(5000);
            }
        } catch (NoSuchElementException e) {
            System.out.println("no card is available to click ");
        }
    }
    public void healthHibit (WebDriver driver, Actions action) {
        driver.findElement(By.xpath(".//div[contains(@ng-click, 'toggleHealthyHabits()')]")).click();
        List<WebElement> hibit = driver.findElements(By.xpath(".//div[@class='home-healthy-habit-yesno ng-scope']"));
        for (int i =0 ; i < hibit.size(); i++){
            WebElement e = hibit.get(i);
            action.moveToElement(e).perform();
            action.click(e.findElement(By.xpath(".//button[1]"))).perform();
        }
    }

}
