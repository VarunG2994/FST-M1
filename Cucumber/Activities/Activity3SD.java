package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity3SD {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;



    @Given("User is on the page")
    public void login_pae(){
        driver= new ChromeDriver();
        wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        driver.manage().window().maximize();
    }



    @When("User clicks the Simple Alert button")
    public void simple_alert() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Simple Alert']")).click();
    }

    @When("User clicks the Confirm Alert button")
    public void confirm_alert() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Confirmation']")).click();
    }

    @When("User clicks the Prompt Alert button")
    public void prompt_alert() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Prompt']")).click();
    }

    @Then("^Alert opens$")
    public void alertOpens() throws InterruptedException {
        alert= driver.switchTo().alert();
    }

    @And("Read the text from it and print it")
    public void read_alert() {
       alert.getText();

    }

    @And("Write a custom message in it")
    public void write_alert() {
        alert.sendKeys("Test");

    }

    @And("Close the alert")
    public void close_alert() {
        alert.accept();

    }

    @And("Close the alert with Cancel")
    public void cancel_alert() {
        alert.dismiss();

    }


    @And("Close Browser")
    public void closeBrowser() {
        //Close browser
        driver.close();
    }
}
