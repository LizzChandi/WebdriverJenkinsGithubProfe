
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class VerifyQualitiesMember2 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        Logger.getLogger("").setLevel(Level.SEVERE);
        driver = new HtmlUnitDriver();
        baseUrl = String.valueOf(System.getProperty("baseURL"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testVerifyQualitiesMember2() throws Exception {
        driver.get(baseUrl + "/src/main/index.html");

        driver.findElement(By.xpath("(//a[contains(text(),'Go')])[2]")).click();
        try {
            assertEquals("Researcher Spirit", driver.findElement(By.xpath("//div[3]/ul/li")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Responsible", driver.findElement(By.xpath("//div[3]/ul/li[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Teamwork", driver.findElement(By.xpath("//div[3]/ul/li[3]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Enthusiastic to learn new things.", driver.findElement(By.xpath("//div[3]/ul/li[4]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Efficient and effective", driver.findElement(By.xpath("//div[3]/ul/li[5]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Perseverant", driver.findElement(By.xpath("//div[3]/ul/li[6]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
