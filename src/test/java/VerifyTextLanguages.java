
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
public class VerifyTextLanguages {
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
    public void testVerifyTextLanguages() throws Exception {
        //driver.get(baseUrl + "/src/main/index.html");
        driver.get(baseUrl+ "/index.html");
        driver.findElement(By.xpath("(//a[contains(text(),'Go')])[3]")).click();
        try {
            assertEquals("Language", driver.getTitle());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Languages", driver.findElement(By.cssSelector("h2.title")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Languages", driver.findElement(By.xpath("//div[3]/h2")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("English", driver.findElement(By.cssSelector("li")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("English", driver.findElement(By.xpath("//div[3]/ul/li")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Spanish", driver.findElement(By.xpath("//li[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Spanish", driver.findElement(By.xpath("//div[3]/ul/li[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.cssSelector("img[alt=\"Home\"]")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
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
