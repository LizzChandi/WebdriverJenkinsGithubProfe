import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by usuario on 05/06/2016.
 */
public class TestGmailAccount {
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
    public void testGmailAccount() throws Exception {
        driver.get(baseUrl + "/src/main/index.html");
        //driver.get(baseUrl + "/index.html");

        driver.findElement(By.cssSelector("img[alt=\"Gmail\"]")).click();
        String expectedTitle = "Inicio de sesión - Cuentas de Google";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle))
            System.out.println("Verification Successful - The correct title is displayed on the web page.");
        else
        {
            System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
        }
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("gaby_r0805@hotmail.com");
        driver.findElement(By.id("next")).click();
        driver.findElement(By.id("Passwd")).clear();
        driver.findElement(By.id("Passwd")).sendKeys("garomoj91");
       // driver.findElement(By.id("next")).click();

        System.out.println("Test script executed successfully.");


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
