package October11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WarmUp {


    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "/Users/muradasgar/Desktop/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        driver.get("https://www.hoteltonight.com/");

        driver.findElement(By.xpath("//input[@placeholder='City, neighborhood, or address']")).click();

        for (int i = 0; i < 20; i++) {



        driver.findElement(By.xpath("//input[@placeholder='City, neighborhood, or address']")).sendKeys(Keys.chord(Keys.CONTROL,"A"), Keys.BACK_SPACE);

        }



       driver.findElement(By.xpath("//input[@placeholder='City, neighborhood, or address']")).sendKeys("Miami");

        //driver.findElement(By.xpath("//a[@class='covid_d0mv9i']")).click();
        //(driver.findElement(By.id("destination_form_field")).sendKeys("Miami");


        //driver.findElement(By.xpath("//div[@class='field_1t5h1hs-o_O-wrappedComponent_zpuhq4']")).click();
    }
}
