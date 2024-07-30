import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity4 {
    public static void main(String[] args){
        WebDriver driver= new ChromeDriver();

        driver.get("https://v1.training-support.net/selenium/target-practice");

        System.out.println("Title of the page is " + driver.getTitle());

        String ThirdHeaderName= driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
        System.out.println("Third header name is " +ThirdHeaderName);

        String fifthColourName=   driver.findElement(By.xpath("//h5[contains(text(), 'Fifth header')]")).getCssValue("color");
        System.out.println("Third header name is " +fifthColourName);

        String violetButtonClass = driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
        System.out.println(violetButtonClass);

        String greyButtonText = driver.findElement(By.xpath("//button[text()='Grey']")).getText();
        System.out.println(greyButtonText);

        driver.quit();

    }

}
