import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest(alwaysRun = true)
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test()
    public void pageUrlTest() throws InterruptedException {
        Thread.sleep(2000);
        String headerUrl= driver.getCurrentUrl();
        System.out.println("The second url is: " + headerUrl);

    }

    @AfterTest(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}
