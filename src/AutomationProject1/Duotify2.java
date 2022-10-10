package AutomationProject1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Duotify2 {


    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/muradasgar/Desktop/chromedriver 2");
        WebDriver driver = new ChromeDriver();

        // driver.manage().window().maximize();

        driver.get("http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");

        Thread.sleep(1000);

        String searchedTitle = "Welcome to Duotify!";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(searchedTitle)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL. Title didn't pass");
        }



        driver.findElement(By.id("loginUsername")).sendKeys("Murad_Asgar");
        driver.findElement(By.id("loginPassword")).sendKeys("Murad123", Keys.ENTER);


        // 6
        String searchedURL1 = "http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?";
        String actualURL1 = driver.getCurrentUrl();

        if (actualURL1.equals(searchedURL1)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL. URL didn't match");
        }


        // 7
        String searchedFullName = "Murad Asgar";
        String actualFullName = driver.findElement(By.id("nameFirstAndLast")).getText();


        if (actualFullName.equals(searchedFullName)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL. Not expected name");
        }


        // 8
        driver.findElement(By.id("nameFirstAndLast")).click();

        String searchedUserName = "Murad Asgar";


        if (driver.getPageSource().contains(searchedUserName)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL. Not expected username");
        }

        //System.out.println(actualUserName);


        // click logout
        Thread.sleep(2000);
        driver.findElement(By.id("rafael")).click();



        // 9

        // Verify that you are logged out by verifying the URL
        Thread.sleep(2000);
        String searchedURL2 = "http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php";
        String actualURL2 = driver.getCurrentUrl();

        if (actualURL2.equals(searchedURL2)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL. URL didn't match");



    }

         // 10

        Thread.sleep(2000);
        driver.findElement(By.id("loginUsername")).sendKeys("Murad_Asgar");
        driver.findElement(By.id("loginPassword")).sendKeys("Murad123", Keys.ENTER);



        Thread.sleep(2000);
        String searchedText = "You Might Also Like";
        String actualText = driver.findElement(By.className("pageHeadingBig")).getText();


        if (actualText.contains(searchedText)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL. Searched text couldn't find");
        }
    }
}