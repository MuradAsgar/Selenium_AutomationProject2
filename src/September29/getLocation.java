package September29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getLocation {

    public static void main(String[] args) {



        System.setProperty("webdriver.chrome.driver", "/Users/muradasgar/Desktop/chromedriver 2");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.duotech.io/");

        System.out.println(driver.findElement(By.tagName("h1")).getLocation());

    }
}
