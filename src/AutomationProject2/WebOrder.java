package AutomationProject2;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebOrder {


    public static String generateCardNumber(int sort){

        long random14Digits = 10000000000000L + (long) (Math.random() * 90000000000000L);
        long random15Digits = 100000000000000L + (long) (Math.random() * 900000000000000L);

        if (sort == 0) {
            return "4"+random14Digits; // visa

        } else if (sort == 1) {
            return "5"+random14Digits;  // master

        } else return "3"+random15Digits;  // amex

    }



    public static String generateExpirationDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/yy");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime sixMonthsLater = now.plusMonths((int) (Math.random() * 72));
        return dtf.format(sixMonthsLater);
    }




    public static String getDate() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return myDateObj.format(myFormatObj);
    }





    public static void main(String[] args) {


        // 1. Launch Chrome browser.
        System.setProperty("webdriver.chrome.driver", "/Users/muradasgar/Desktop/chromedriver 2");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        Faker faker = new Faker();


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 2. Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 3. Login using username Tester and password test
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test", Keys.ENTER);


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 4. Click on Order link
        driver.findElement(By.linkText("Order")).click();


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 5. Enter a random product quantity between 1 and 100

        int randomQuantity = (int) (1 + (Math.random() * 100));
        WebElement quantityBox = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
        quantityBox.sendKeys(Keys.BACK_SPACE, "" + randomQuantity);


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 6. Click on Calculate and verify that the Total value is correct.

        int expectedTotal = randomQuantity * 100;
        int expectedTotalWithDiscount = (int) (expectedTotal - (expectedTotal * 0.08));

        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        int actualTotal = Integer.parseInt((driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtTotal")).getAttribute("value")));

        if (randomQuantity < 10) {
            Assert.assertEquals(actualTotal, expectedTotal);
        } else {
            Assert.assertEquals(actualTotal, expectedTotalWithDiscount);
        }


        //System.out.println("Actual total is: " + actualTotal);


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 7. Generate and enter random first name and last name.

        String fullName = faker.name().fullName();

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(fullName);


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 8. Generate and Enter random street address

        String streetAddress = faker.address().streetAddress();

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys(streetAddress);


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 9. Generate and Enter random city

        String cityName = faker.address().cityName();

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys(cityName);


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 10. Generate and Enter random state

        String stateName = faker.address().state();

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys(stateName);


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 11. Generate and Enter a random 5 digit zip code

        String zipCode = "" + (int) (10000 + (Math.random() * 90000));

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(zipCode);


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 12. Select the card type randomly. On each run your script should select a random type.

        //driver.findElement(By.xpath("(//input[@type='radio'])[" + (int) (1 + Math.random() * 3) + "]")).click();
        //driver.findElement(By.xpath("//table[@class='RadioList']//td[" + cardType + "]")).click();


        int cardType = (int) (Math.random() * 3);  // 0-1-2

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_" + cardType)).click();


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 13. Generate and enter the random card number:


        String cardNumber = generateCardNumber(cardType);

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(cardNumber);



        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 14. Enter a valid expiration date (newer than the current date)


        String expirationDate = generateExpirationDate();

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys(expirationDate);


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 15. Click on Process

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 16. Verify that “New order has been successfully added” message appeared on the page.

        String expectedText = "New order has been successfully added.";
        String actualText = driver.findElement(By.className("buttons_process")).getText();

        Assert.assertTrue(actualText.contains(expectedText));


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 17. Click on View All Orders link.

        driver.findElement(By.linkText("View all orders")).click();


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 18. The placed order details appears on the first row of the orders table. Verify that the entire information contained on the row (Name, Product, Quantity, etc) matches the previously entered information in previous steps.


        List<String> expectedValues = new ArrayList<>(Arrays.asList(fullName,
                                                                   "MyMoney",
                                                           ""+randomQuantity,
                                                                   getDate(),
                                                               streetAddress,
                                                                    cityName,
                                                                   stateName,
                                                                     zipCode,
         (cardType==0 ?"Visa": cardType==1 ?"MasterCard":"American Express"),
                                                                  cardNumber,
                                                              expirationDate ));



        List<String> actualValues = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='SampleTable']//tr[2]//td"));


        for (WebElement passedData : elements) {

            actualValues.add(passedData.getText());
        }


        actualValues.remove(0);
        actualValues.remove(actualValues.size()-1);


        Assert.assertEquals(actualValues, expectedValues);


        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 19. Log out of the application.

        driver.findElement(By.id("ctl00_logout")).click();



        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        System.out.println("PASSED! NO BUG FOUND");

        driver.quit();





    }
}
