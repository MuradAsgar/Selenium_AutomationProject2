package October11;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class Cookies {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/muradasgar/Desktop/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        driver.get("https://www.amazon.com/");

        Set<Cookie> cookies = driver.manage().getCookies();

        for (Cookie cookie : cookies) {

            System.out.println(cookie);

        }
    }
}
