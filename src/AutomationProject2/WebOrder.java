package AutomationProject2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import java.time.Duration;

public class WebOrder {


    public static void main(String[] args) {


        // 1. Launch Chrome browser.
        System.setProperty("webdriver.chrome.driver", "/Users/muradasgar/Desktop/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


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

        int randomQuantity = (int)(1+(Math.random()*100));
        WebElement quantityBox = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
        quantityBox.sendKeys(Keys.BACK_SPACE, ""+randomQuantity);



        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 6. Click on Calculate and verify that the Total value is correct.

        int expectedTotal = randomQuantity*100;
        int expectedTotalWithDiscount = (int) (expectedTotal - (expectedTotal*0.08));

        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        int actualTotal = Integer.parseInt((driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtTotal")).getAttribute("value")));

      if(randomQuantity<10){
          Assert.assertEquals(actualTotal,expectedTotal);
      }else{
          Assert.assertEquals(actualTotal,expectedTotalWithDiscount);
      }


        //System.out.println("Actual total is: " + actualTotal);




        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 7. Generate and enter random first name and last name.

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder firstName = new StringBuilder();
        StringBuilder lastName = new StringBuilder();


        for (int i = 0; i < 5; i++) {
            firstName.append(alphabet.charAt((int) (Math.random() * alphabet.length())));
        }

        for (int i = 0; i < 7; i++) {
            lastName.append(alphabet.charAt((int) (Math.random() * alphabet.length())));
        }

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(firstName + " " + lastName);




        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 8. Generate and Enter random street address

        StringBuilder streetName = new StringBuilder();
        int homeNo = (int)(1000+(Math.random()*9000));

        for (int i = 0; i < 8; i++) {
            streetName.append(alphabet.charAt((int) (Math.random() * alphabet.length())));
        }

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys(homeNo + " " + streetName + " STR");




        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 9. Generate and Enter random city

        StringBuilder cityName = new StringBuilder();

        for (int i = 0; i < 7; i++) {
            cityName.append(alphabet.charAt((int) (Math.random() * alphabet.length())));
        }

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys(cityName);




        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 10. Generate and Enter random state

        StringBuilder stateName = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            stateName.append(alphabet.charAt((int) (Math.random() * alphabet.length())));
        }

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys(stateName);



        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 11. Generate and Enter a random 5 digit zip code

        int zipCode = (int)(10000+(Math.random()*90000));

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(""+zipCode);



        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 12. Select the card type randomly. On each run your script should select a random type.

        driver.findElement(By.xpath("(//input[@type='radio'])[" + (int)(1+Math.random()*3) + "]")).click();




        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        // 13. Generate and enter the random card number:
        //      If Visa is selected, the card number should start with 4.
        //      If MasterCard is selected, card number should start with 5.
        //      If American Express is selected, card number should start with 3.
        //      Card numbers should be 16 digits for Visa and MasterCard, 15 for American Express.


        
























        // System.out.println(driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).getAttribute("value"));


        //driver.quit();


        // BCTFQ KVPLIFO





    }
}
