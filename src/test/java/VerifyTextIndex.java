
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class VerifyTextIndex {
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
    public void testVerifyTextIndex() throws Exception {
        driver.get(baseUrl + "/src/main/index.html");

        try {
            assertEquals("Team Work SOFTWARE QUALITY MEI-CM\n \n Good team, good works. \n Lets go to see together: Work Projects\n Areas of knowledge: Go\n Qualities of the members: Go\n Languages: Go", driver.findElement(By.cssSelector("h1.heading")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Team member N.1", driver.findElement(By.cssSelector("h2.title")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Team member N.2", driver.findElement(By.xpath("//div[3]/h2")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Lizz", driver.findElement(By.cssSelector("span")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Gaby", driver.findElement(By.xpath("//div[3]/div/p/span")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Chandi Argoti", driver.findElement(By.cssSelector("sub")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Roldán Molina", driver.findElement(By.xpath("//div[3]/div/p/sub")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Ecuadorian", driver.findElement(By.cssSelector("li")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Ecuadorian", driver.findElement(By.xpath("//div[3]/ul/li")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("IPL student: 2152219", driver.findElement(By.xpath("//li[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("IPL student: 2152216", driver.findElement(By.xpath("//div[3]/ul/li[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Life Goals: Teacher, Psychologist, own business,travel around the world", driver.findElement(By.xpath("//li[4]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Professional goal: Conduct courses on mobile applications Own business", driver.findElement(By.xpath("//div[3]/ul/li[4]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Read more about me", driver.findElement(By.cssSelector("div.pt-footer > p")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Read more about me", driver.findElement(By.xpath("//div[3]/div[2]/p")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("My CV", driver.findElement(By.linkText("My CV")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("My CV", driver.findElement(By.xpath("(//a[contains(text(),'My CV')])[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Facebook", driver.findElement(By.linkText("Facebook")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Facebook", driver.findElement(By.xpath("(//a[contains(text(),'Facebook')])[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Instagram", driver.findElement(By.linkText("Instagram")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Instagram", driver.findElement(By.xpath("(//a[contains(text(),'Instagram')])[2]")).getText());
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
