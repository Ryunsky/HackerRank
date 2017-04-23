package mypackage;

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
        web.login(driver);
        
    }
}
