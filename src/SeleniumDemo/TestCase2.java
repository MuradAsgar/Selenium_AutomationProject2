package SeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class TestCase2 {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/muradasgar/Desktop/chromedriver 2");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // it will wait up till 10 seconds till that element found. if it found earlier it will move on.
        /* implement right after WebDriver. it will be usefully. be careful about duration,
        because if there will be not that kind of element it will wait that amount of time */

        driver.get("https://www.dice.com/");

        String term = "SDET";
        String location = "Washington DC";


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.dice.com/");

        Assert.assertEquals(driver.getTitle(), "Find Jobs In Technology");

        Assert.assertTrue(driver.getTitle().contains("Find Jobs"));

        driver.findElement(By.id("typeaheadInput")).sendKeys(term);
        driver.findElement(By.id("google-location-search")).sendKeys(location);
        driver.findElement(By.xpath("//button[@id='submitSearch-button']")).click();

       // Thread.sleep(2000);


        List<WebElement> links = (List<WebElement>) driver.findElements(By.xpath("//a[@class='card-title-link bold']"));

        if(links.isEmpty()){
            throw new RuntimeException("Find element couldn't find enyting");

        }


        for (WebElement link : links) {
            System.out.println(link.getText());
            Assert.assertTrue(link.getText().contains(term));

        }
















        //===============================================



//        String expectedURL = "https://www.duotech.io/";
//        String expectedTitle = "Software QA Automation Engineer program | SDET | QA School | Software Testing";
//
//        String actualURL = driver.getCurrentUrl();
//        String actualTitle = driver.getTitle();
//
//        if(expectedTitle.equals(actualTitle) && expectedURL.equals(actualURL)){
//            System.out.println("PASS");
//        }else{
//            System.out.println("FAIL");
//        }

    }

}
