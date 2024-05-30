import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity4 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest(alwaysRun = true)
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test()
    public void pageNameTest() throws InterruptedException {
        Thread.sleep(2000);
       String requiredValue= driver.findElement(By.xpath("//h2[text()='Quia quis non']")).getText();
        System.out.println("Title second title is: " + requiredValue);
        Assert.assertEquals(requiredValue, "Quia quis non");
    }

    @AfterTest(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}
