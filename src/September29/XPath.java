package September29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/muradasgar/Desktop/chromedriver 2");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.hoteltonight.com/");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"viewport\"]/div/div/div[2]/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div/div[2]/div/div/div[1]/div/form/div/div/div/input"));
        // Full xpath is not recommended. Because it is easily breakable







    }
}
