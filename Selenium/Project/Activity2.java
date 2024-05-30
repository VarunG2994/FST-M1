import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity2 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest(alwaysRun = true)
    public void beforeMethod() {
        driver = new ChromeDriver();

        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test()
    public void pageHeaderTest() throws InterruptedException {


        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='entry-title']")));
        WebElement header= driver.findElement(By.xpath("//*[@class='entry-title']"));
        String headertest= header.getText();
       Thread.sleep(2000);
        System.out.println("Title is: " + headertest);
        Assert.assertEquals(headertest, "Welcome to Alchemy Jobs");
    }

    @AfterTest(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
