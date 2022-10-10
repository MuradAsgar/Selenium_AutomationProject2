package SeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementMethod {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/muradasgar/Desktop/chromedriver 2");
        WebDriver driver = new ChromeDriver();


        driver.get("https://www.instagram.com/accounts/emailsignup/");

        Thread.sleep(500); // adding this method to make execution to wait for 500 milliseconds
        // Because Selenium runs code as fast as possible, that may cause thrownException, by make code slower , synchronizes code

        driver.findElement(By.name("emailOrPhone")).sendKeys("dtacademy@gmail.com");
        driver.findElement(By.name("fullName")).sendKeys("Duotech");
        driver.findElement(By.name("username")).sendKeys("dtacademy2022");
        driver.findElement(By.name("password")).sendKeys("dT123456" +  Keys.ENTER);

        Thread.sleep(1000); // same waiting code in here too

        if(driver.getPageSource().contains("Add Your Birthday")){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }



    }
}
