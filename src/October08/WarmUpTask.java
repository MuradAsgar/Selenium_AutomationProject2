package October08;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WarmUpTask {


    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "/Users/muradasgar/Desktop/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // go to https://www.webstaurants.com/
        driver.get("https://www.webstaurantstore.com/");


        // Search for "stainless work table"
        driver.findElement(By.name("searchval")).sendKeys("stainless work table", Keys.ENTER);



        // check all the search results from the current ensuring every product has the word "Table" in its title
        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='product_listing']//a[@data-testid='itemDescription']"));

        for (WebElement element : elements) {

            String actualText = element.getText().toLowerCase();
            System.out.println(element.getText());
            // Assert.assertTrue(actualText.contains("table") && actualText.contains("stainless") && actualText.contains("work"), "The actual test is: " + element.getText());
            // By the above implementation we can test if the actual text contains couple words at the same time!!

            Assert.assertTrue(actualText.contains("table") , "The actual test is: " + element.getText());
            // By adding , in assertTrue body after main part we will have a chance to add the custom error message that we want to add in case of FAIL.
            // LIKE: -> "The actual test is: " + element.getText()
            // Because Assert.assertTrue() doesn't give an information about the reason of failing.
            // So we print actual content of the text that we have searched to be able to see the whole text, so we can find out why it is failing if there will be any FAIL


        }


        // Add the first of found items to Cart

        elements.get(0).click();  // -> since we have list of all elements, then -> elements.get(0)  allows us to locate first found element dynamically

        driver.findElement(By.id("buyButton")).click();

        WebElement element = driver.findElement(By.xpath("//div[@class='amount']"));
        Assert.assertTrue(element.isDisplayed()); // This Assertion will provide to verify if that text element is displayed
        // isDisplayed() is one of the methods which is useful to check and verify if the code is working as intended and there is not any failure during the running of the script!


        // go to the cart

        driver.findElement(By.xpath("//button[contains(text(), 'View Cart')]")).click();




        // Empty Cart and Verify "Your cart is empty" text is shown up

        driver.findElement(By.xpath("//button[.='Empty Cart']")).click();

        driver.findElement(By.xpath("//footer//button[.='Empty Cart']")).click();
        // In here because we will have 2 Empty Cart button, for the second one we create a xpath through its parent to make this button unique!!!



        // THIS IS THE LONGER WAY TO ASSERT THE CODE:
//        String expectedText = "Your cart is empty.";
//        String actualText = driver.findElement(By.xpath("//p[@class='header-1']")).getText();
//
//        Assert.assertTrue(actualText.contains(expectedText));


        // NOW LET'S DO IT IN A SHORTER WAY:
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='header-1']")).isDisplayed());
        //   -> isDisplayed() method checks if text from found element has been displayed


        // STOPPED AT RECORDING MIN : 49



        //driver.close();
    }
}
