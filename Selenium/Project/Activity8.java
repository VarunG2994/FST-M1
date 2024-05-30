import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Activity8 {
    WebDriver driver;
    WebDriverWait wait;
    String userNameInput= "root";
    String password= "pa$$w0rd";
    @BeforeTest(alwaysRun = true)
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    }

    @Test()
    public void loginTest() throws InterruptedException {
        Thread.sleep(2000);
        WebElement userName= driver.findElement(By.xpath("//input[@id='user_login']"));
        WebElement pwd= driver.findElement(By.xpath("//input[@id='user_pass']"));
        WebElement loginBtn= driver.findElement(By.xpath("//input[@id='wp-submit']"));
        userName.sendKeys(userNameInput);
        pwd.sendKeys(password);
        Thread.sleep(2000);
        loginBtn.click();
        WebElement dashboard= driver.findElement(By.xpath("//h1[text()='Dashboard']"));
        Assert.assertTrue(dashboard.isDisplayed());
    }

    @AfterTest(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
