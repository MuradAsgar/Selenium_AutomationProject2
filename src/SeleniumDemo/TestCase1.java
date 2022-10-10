package SeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {


    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "/Users/muradasgar/Desktop/chromedriver 2");
        WebDriver driver = new ChromeDriver();



        String searchTerm = "Selenium";

        // Navigate to google.com
        driver.get("https://www.google.com/");

        // Type "selenium" on the search box and hit enter
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchTerm + Keys.ENTER);

        // Verify that the search page title contains the search term

        String expectedTitle = searchTerm + " - Google Search";

        String actualTitle = driver.getTitle(); // Gets the title of the current page

        if (actualTitle.equals(expectedTitle)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL. Expected title is: " + expectedTitle);
            System.out.println("The actual title is: " + actualTitle);
        }




    }
}
