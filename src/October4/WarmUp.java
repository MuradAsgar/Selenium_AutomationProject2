package October4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class WarmUp {


    public static void main(String[] args) {






        System.setProperty("webdriver.chrome.driver", "/Users/muradasgar/Desktop/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        // Navigate to Amazon.com
        driver.get("https://www.amazon.com/");


        // Search for iPhone
        String term = "iphone";
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(term);


        // Verify that search result title contains iPhone
        List<WebElement> elements = driver.findElements(By.xpath("/div[@class='s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col s-widget-spacing-small sg-col-12-of-16']//span[@class='a-size-medium a-color-base a-text-normal']"));


        for (WebElement element : elements) {

                System.out.println(element.getText());
                Assert.assertTrue(element.getText().toLowerCase().contains(term));

        }



        driver.findElement(By.xpath("//li[@id='p_89/Apple']//i")).click();

        driver.findElement(By.xpath("//li[@id='p_n_feature_twelve_browse-bin/14674911011']//i")).click();

        List<WebElement> results = driver.findElements(By.xpath("//div[@class='sg-col-4-of-12 s-result-item s-asin sg-col-4-of-16 sg-col s-widget-spacing-small sg-col-4-of-20']//span[@class='a-size-base-plus a-color-base a-text-normal']"));


        for (WebElement result : results) {

            System.out.println(result.getText());
            Assert.assertTrue(result.getText().toLowerCase().contains("apple"));
            Assert.assertTrue(result.getText().toLowerCase().contains("128"));
        }





    }


    // //div[@class='s-main-slot s-result-list s-search-results sg-row']//span[@class='a-size-base-plus a-color-base a-text-normal']
}
