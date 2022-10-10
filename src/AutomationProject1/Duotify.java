package AutomationProject1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Duotify {


    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/muradasgar/Desktop/chromedriver 2");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 1. Navigate to http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php
        driver.get("http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");



        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 2. Verify the the title is "Welcome to Duotify!"
        Thread.sleep(1000);

        String searchedTitle = "Welcome to Duotify!";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(searchedTitle)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL. Title didn't pass");
        }



        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 3. Click on Signup here
        driver.findElement(By.id("hideLogin")).click();



        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 4. Fill out the form with the required info
        driver.findElement(By.id("username")).sendKeys("Murad.Asgar");
        driver.findElement(By.id("firstName")).sendKeys("Murad");
        driver.findElement(By.id("lastName")).sendKeys("Asgar");
        driver.findElement(By.id("email")).sendKeys("muradasgarv@gmail.com");
        driver.findElement(By.id("email2")).sendKeys("muradasgarv@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Murad123");
        driver.findElement(By.id("password2")).sendKeys("Murad123");



        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 5. Click on Sign up
        driver.findElement(By.name("registerButton")).click();



        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 6. Once logged in to the application, verify that the URL is: //http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?
        String searchedURL1 = "http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?";
        String actualURL1 = driver.getCurrentUrl();

        if (actualURL1.equals(searchedURL1)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL. URL didn't match");
        }



        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 7. In the left navigation bar, verify that your first and last name matches the first and last name that you used when signing up.
        String searchedFullName = "Murad Asgar";
        String actualFullName = driver.findElement(By.id("nameFirstAndLast")).getText();


        if (actualFullName.equals(searchedFullName)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL. Not expected name");
        }




        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 8. Click on the username on the left navigation bar,
        driver.findElement(By.id("nameFirstAndLast")).click();


        //and verify the username on the main window is correct
        String searchedUserName = "Murad Asgar";

        if (driver.getPageSource().contains(searchedUserName)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL. Not expected username");
        }


        // and then click logout
        Thread.sleep(2000);
        driver.findElement(By.id("rafael")).sendKeys(Keys.ENTER);




        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 9. Verify that you are logged out by verifying the URL is: //http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php
        Thread.sleep(2000);
        String searchedURL2 = "http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php";
        String actualURL2 = driver.getCurrentUrl();

        if (actualURL2.equals(searchedURL2)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL. URL didn't match");
        }




        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 10. Login using the same username and password when you signed up.
        Thread.sleep(2000);
        driver.findElement(By.id("loginUsername")).sendKeys("Murad.Asgar");
        driver.findElement(By.id("loginPassword")).sendKeys("Murad123", Keys.ENTER);




        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 11. Verify successful login by verifying that the home page contains the text "You Might Also Like".
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
