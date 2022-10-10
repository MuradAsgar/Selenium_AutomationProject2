package SeleniumDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/muradasgar/Desktop/chromedriver 2");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.duotech.io");

        // Thread.sleep(1000);
        driver.navigate().to("https://duotech.talentlms.com/");
        // Thread.sleep(1000);
        driver.navigate().to("https://www.amazon.com/");
        // .navigate().to() stores history. This is the main difference from .get() method
        // That allows us to call .back() , .forward() , .refresh()  methods after .navigate().to() method
        // this is not possible with .get() method


        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }
}
