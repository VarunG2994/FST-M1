import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Activity6 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest(alwaysRun = true)
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test()
    public void emailValidationTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Jobs']")).click();
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='search_keywords']")));
        WebElement inputJobSearch= driver.findElement(By.xpath("//input[@name='search_keywords']"));
        inputJobSearch.sendKeys("Banking");
        inputJobSearch.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='position'])[1]")).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@value='Apply for job']")));
        driver.findElement(By.xpath("//*[@value='Apply for job']")).click();
        Thread.sleep(2000);
        String email= driver.findElement(By.xpath("//*[@class='job_application_email']")).getText();
        System.out.println("Email address to apply job is " + email);
          }

    @AfterTest(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
