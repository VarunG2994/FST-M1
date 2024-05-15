import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1 {

    public static void main(String[] args){
        WebDriver driver= new ChromeDriver();

        driver.get("https://v1.training-support.net");

        System.out.println("Title of the page is " + driver.getTitle());

        driver.findElement(By.id("about-link")).click();

        System.out.println("Title of the page is " + driver.getTitle());

        driver.quit();

    }

}
