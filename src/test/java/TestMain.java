import org.apache.hc.core5.http.HttpResponse;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.*;
import static java.lang.Thread.sleep;

public class TestMain {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        // ExtentReports extent = new ExtentReports();
        driver = Driver.chromeDriverBrowser(TextRepository.url);
    }
    @AfterClass
    public void closeAllPages(){
        driver.quit();
        // driver.close();
    }
    @Test
    /* Press on ‘New Payment’ button */
    public void test1 ()  {
        Driver.waitDrivervElementToBeClickable(driver,DefiningElements.byNewPaymentButton).click();
    }
    @Test
    /* Press on ‘Sign in’ button */
    public void test2(){
        Driver.waitDrivervElementToBeClickable(driver,DefiningElements.bySignInButton).click();
       Driver.waitInvisibilityOfElementLocated(driver,DefiningElements.bySignInButton);
    }
    @Test
    /*Go to the login screen */
    public void test3(){
        Driver.waitDrivervElementToBeClickable(driver,DefiningElements.byLoginButton_name);
    }
    @Test
    /* Connecting with a user defined in the test*/
    public void test4() throws InterruptedException {
        DefiningElements.elementUsernameField(driver).sendKeys(TextRepository.userEmail);
        DefiningElements.elementPasswordField(driver).sendKeys(TextRepository.userPassword);
        DefiningElements.elementLoginButton(driver).click();
        //Driver.waitInvisibilityOfElementLocated(driver,DefiningElements.byLoginButton_name);
         sleep(10000);
    }
    @Test
    public void  test5(){
//        Cookie cookie = driver.manage().getCookieNamed("forterToken");
//        String encodedToken  = cookie.getValue();
        WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
        LocalStorage localStorage = webStorage.getLocalStorage();
        TextRepository.encodedToken= localStorage.getItem("forterToken");
        SessionId s = ((RemoteWebDriver) driver).getSessionId();
        System.out.println( TextRepository.encodedToken);
        System.out.println(s);

    }
    @Test
    public void  test6(){
        TestFunctions.apiLoop();
    }
}
