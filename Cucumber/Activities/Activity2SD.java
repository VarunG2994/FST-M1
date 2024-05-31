package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity2SD {
    WebDriver driver;
    WebDriverWait wait;


    @Given("User is on Login page")
    public void login_pae(){
        driver= new ChromeDriver();
        wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://v1.training-support.net/selenium/login-form");
        driver.manage().window().maximize();
    }

    @When("User enters {string} and {string}")
    public void userEntersAdminAndPassword(String username, String password) {
        //Enter username from Feature file
        driver.findElement(By.id("username")).sendKeys(username);
        //Enter password from Feature file
        driver.findElement(By.id("password")).sendKeys(password);
        //Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @When("User enters username and password")
    public void user_input() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()= 'Log in']")).click();
    }
    @Then("^Read the page title and confirmation message$")
    public void readTitleAndHeading() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));

        //Read the page title and heading
        String pageTitle = driver.getTitle();
        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();

        //Print the page title and heading
        System.out.println("Page title is: " + pageTitle);
        System.out.println("Login message is: " + confirmMessage);
        Thread.sleep(2000);
    }

    @And("Close the Browser Login page")
    public void closeBrowser() {
        //Close browser
        driver.close();
    }
}
