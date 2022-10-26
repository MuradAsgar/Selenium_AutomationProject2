package AutomationProject3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class CarFax {


    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/muradasgar/Desktop/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 1. Navigate  to carfax.com
        driver.get("https://www.carfax.com/");



        // 2. Click on Find a Used Car
        driver.findElement(By.linkText("Find a Used Car")).click();



        // 3. Verify the page title contains the word “Used Cars”
        Assert.assertTrue(driver.getTitle().contains("Used Cars"));



        // 4. Choose “Tesla” for  Make.



        //for (int i = 0; i < 31; i++) {

            driver.findElement(By.id("cfx-select-input-6002438451861735")).click();

            //driver.findElement(By.id("make_Tesla")).click();

       // }
    }
}
