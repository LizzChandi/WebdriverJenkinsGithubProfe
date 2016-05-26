
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class TestSearcherGoog {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://staging-workspacelizz096.rhcloud.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSearcherGoog() throws Exception {
        driver.get(baseUrl + "/src/main/index.html");
        assertEquals("QUALIDADE DE SOFTWARE + SOFTWARE QUALITY MEI-CM", driver.getTitle());
        try {
            assertEquals("QUALIDADE DE SOFTWARE + SOFTWARE QUALITY MEI-CM", driver.getTitle());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Team Work SOFTWARE QUALITY MEI-CM\n \n Good team, good works. \n Lets go to see together: Work Projects\n Team member N.1 Lizz Chandi Argoti \n Suitable for teaching\n \n Ecuadorian IPL student: 2152219 23 years old Life Goals: Teacher, Psychologist, own business,travel around the world Read more about me\n My CV Facebook\n \n \n Team member N.2 Gaby RoldÃ¡n Molina \n Suitable for learning\n \n Ecuadorian IPL student: 2152216 25 years old Professional goal: Conduct courses on mobile applications Own business Read more about me\n My CV Facebook", driver.findElement(By.cssSelector("div.pricing-table.group")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.cssSelector("div.pricing-table.group")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("gsc-i-id1")).clear();
        driver.findElement(By.id("gsc-i-id1")).sendKeys("ISTQB");
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
