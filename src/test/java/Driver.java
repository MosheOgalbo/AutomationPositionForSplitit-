import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {
    public static WebDriver chromeDriverBrowser(String goToBrowse){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.navigate().to(goToBrowse);
        return driver;
    }
    public static WebElement waitDrivervElementToBeClickable(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        return  wait.until(ExpectedConditions.elementToBeClickable(by));

    }
    public static Boolean waitInvisibilityOfElementLocated (WebDriver driver, By by){
        WebDriverWait waitDriver = new WebDriverWait(driver,Duration.ofSeconds(20));
        return waitDriver.until(ExpectedConditions.invisibilityOf(driver.findElement(by)));

    }
    public static WebElement waitVisibilityOfElementLocated (WebDriver driver, By by){
        WebDriverWait waitDriver = new WebDriverWait(driver,Duration.ofSeconds(20));
        return waitDriver.until(ExpectedConditions.visibilityOfElementLocated(by));

    }
}
