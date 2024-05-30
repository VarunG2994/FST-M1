import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Activity7 {
    Random random= new Random();
    String jobAddedNew= "DemoTest Jon" +  random.nextInt(50);
    String email= "abcd@efg" + random.nextInt(50) + ".com";

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
    public void jobsAddtest() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Post a Job']")).click();
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputemail= driver.findElement(By.xpath("//input[@name='create_account_email']"));
        inputemail.sendKeys(email);
        WebElement inputJobSearch= driver.findElement(By.xpath("//input[@name='job_title']"));
        inputJobSearch.sendKeys(jobAddedNew);
        WebElement applicationEmail= driver.findElement(By.xpath("//input[@name='application']"));
        applicationEmail.sendKeys("abcd@efgh.com");
        WebElement companyName= driver.findElement(By.xpath("//input[@name='company_name']"));
        companyName.sendKeys("ABCD Comp");
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        WebElement descriptionId= driver.findElement(By.cssSelector("#tinymce"));
        descriptionId.sendKeys("ABCD Comp");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@value='Preview']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("job_preview_submit_button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Jobs']")).click();
        WebElement searchJob = driver.findElement(By.xpath("//input[@name='search_keywords']"));
        searchJob.sendKeys(jobAddedNew);
        Thread.sleep(3000);
        searchJob.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement addedJob= driver.findElement(By.xpath("//*[contains(text(), '" +jobAddedNew+ "')]"));
        Assert.assertTrue(addedJob.isDisplayed());
    }

    @AfterTest(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
