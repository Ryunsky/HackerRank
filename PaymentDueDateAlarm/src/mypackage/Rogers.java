package mypackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    public void login(WebDriver driver) throws NoSuchElementException{
        // TODO Auto-generated method stub
        driver.get(getWebLink());
        WebElement userID = driver.findElement(By.id("USER"));
        WebElement passWD = driver.findElement(By.id("password"));
        userID.sendKeys(username);
        passWD.sendKeys(password);
        WebElement login = driver.findElement(By.xpath(".//button[@class='cta-round primary medium full overrite']"));
        login.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        accountSelection(driver);
        viewBill(driver);
        printBillAmountAndDate(driver);
        driver.close();
    }
    
    public void accountSelection(WebDriver driver) throws NoSuchElementException{
        if (driver.findElement(By.xpath(".//div[contains(@modal-window, '@modal-window')]")) != null) {
            driver.findElement(By.xpath("//span[@class='account-number-txt' and .//span[contains(text(), '240753047403')]]")).click();
        }
    }
    
    public void viewBill(WebDriver driver) throws NoSuchElementException{
        driver.findElement(By.xpath("//button[@class='btn-view-bill']")).click();
    }
    
    //switch to the iframe first, and then find the element
    public void printBillAmountAndDate(WebDriver driver) throws NoSuchElementException{
        driver.switchTo().frame(driver.findElement(By.id("bb_iframe_container bb_iframe")));
        WebElement amount = driver.findElement(By.xpath("//span[starts-with(@ng-bind-html, 'document.account_balance.amount_with_tax')]"));
        System.out.println(amount.getText());
        WebElement date = (driver.findElement(By.xpath("//div[@class='due ng-binding ng-scope']")))
                .findElement(By.xpath(".//strong"));
        System.out.println(date.getText());
    }
}
