package October11;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakingScreenshot {


    public static void main(String[] args) throws IOException {


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

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

       // FileUtils.copyFile(screenshot,new File("src/Octobe11/screenshot.png"));
    }
}
