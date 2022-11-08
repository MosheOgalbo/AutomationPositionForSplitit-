import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DefiningElements {
    public static  By byNewPaymentButton =  By.xpath(TextRepository.newPaymentButton);
    public static By bySignInButton = By.cssSelector(TextRepository.signInButton);
    public static By byLoginButton_name = By.name(TextRepository.LoginButton_name);
    public  static By byUsernameField_id = By.id(TextRepository.fieldOfUserEmail);
    public  static By byPasswordField_id = By.id(TextRepository.fieldOfUserPassword);


    public static WebElement elementUsernameField (WebDriver driver){
        return driver.findElement(byUsernameField_id);
    }
    public static WebElement elementPasswordField (WebDriver driver){
        return driver.findElement(byPasswordField_id);
    }
    public static WebElement elementLoginButton (WebDriver driver){
        return driver.findElement(byLoginButton_name);
    }
}
