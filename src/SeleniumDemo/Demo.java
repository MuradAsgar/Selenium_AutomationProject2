package SeleniumDemo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

    public class Demo {


        public static void main(String[] args) {


            System.setProperty("webdriver.chrome.driver", "/Users/muradasgar/Desktop/chromedriver 2");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com/");


        }


    }

