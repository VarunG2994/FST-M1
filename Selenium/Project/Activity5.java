import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest(alwaysRun = true)
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test()
    public void pageSecondHeaderTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Jobs']")).click();
       String secondTitle= driver.getTitle();
        System.out.println("Title second title is: " + secondTitle);
       Assert.assertEquals(secondTitle, "Jobs – Alchemy Jobs");
    }

    @AfterTest(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}
