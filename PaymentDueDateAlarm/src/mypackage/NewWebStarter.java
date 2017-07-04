package mypackage;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import interfaces.Web;

public class NewWebStarter implements Runnable {

    private Web web;
    public NewWebStarter(Web web) {
        this.web = web;
    }
    @Override
    public void run() {
        WebDriver driver = new ChromeDriver();
        try{
            web.login(driver);
        } catch (NoSuchElementException e) {
            System.out.printf("%s cannot find the element ",web.getWebName());
            driver.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("here");
        }
        
    }
}
