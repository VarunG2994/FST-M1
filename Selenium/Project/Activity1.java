import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity1 {

    WebDriver driver;
    WebDriverWait wait;

     @BeforeTest(alwaysRun = true)
    public void beforeMethod() {
        driver = new ChromeDriver();

        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test()
    public void pageTitleTest() throws InterruptedException {
        String title = driver.getTitle();
        Thread.sleep(2000);
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "Alchemy Jobs – Job Board Application");
    }

    @AfterTest(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
