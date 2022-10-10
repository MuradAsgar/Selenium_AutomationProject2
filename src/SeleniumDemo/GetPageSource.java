package SeleniumDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetPageSource {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/muradasgar/Desktop/chromedriver 2");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.duotech.io");

        System.out.println(driver.getPageSource().contains("Start New IT Career"));
        // returns false because in html code instead of real space used as &nbsp;
        System.out.println(driver.getPageSource().contains("Start New IT&nbsp;Career"));
        // now it will return true


        driver.quit(); // Quits entire web driver session. closing every associated window.

        driver.close(); // Closes only current window (tab)


        driver.get("https://www.duotech.io");
        // When you call any driver method on driver object after calling quit NoSuchSessionException will be thrown


    }
}
