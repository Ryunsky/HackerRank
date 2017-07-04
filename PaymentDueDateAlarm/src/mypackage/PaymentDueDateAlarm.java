package mypackage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import interfaces.Web;

public class PaymentDueDateAlarm {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        GetUserAndPassword data = new GetUserAndPassword(System.getProperty("properties"));
        System.setProperty("webdriver.chrome.driver", data.getProperties("win_chrome"));
        Web rogers = new Rogers(data.getProperties("rogers.user"),
                                        data.getProperties("rogers.password"));
        Web virginPulse = new VirginPulse(data.getProperties("virgin.user"),
                                        data.getProperties("virgin.password"));
        new Thread(new NewWebStarter(virginPulse)).start();
//            new Thread(new NewWebStarter(rogers)).start();
    }

}
