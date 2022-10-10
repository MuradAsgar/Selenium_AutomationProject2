package SeleniumDemo;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CSS {


    public static void main(String[] args) {



        System.setProperty("webdriver.chrome.driver", "/Users/muradasgar/Desktop/chromedriver 2");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // it will wait up till 10 seconds till that element found. if it found earlier it will move on.
        /* implement right after WebDriver. it will be usefully. be careful about duration,
        because if there will be not that kind of element it will wait that amount of time */

        driver.get("https://www.google.com/");
    }
}
