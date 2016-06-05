
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;


public class TestNumberLinks {
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
    public void testNumberLinks() throws Exception {
        driver.get(baseUrl + "/src/main/index.html");
        //driver.get(baseUrl + "/index.html");

        List allLinks= driver.findElements(By.xpath("//a"));
        assertEquals(12, allLinks.size());
        for(int i=0;i<allLinks.size();i++){
            String link= allLinks.get(i).toString();
            if(link.contains("works")){
                System.out.println("Link works Found");
            }
            if(link.contains("areas")){
                System.out.println("Link areas Found");
            }
            if(link.contains("language")){
                System.out.println("Link language Found");
            }
            if(link.contains("qualities")){
                System.out.println("Link qualities Found");
            }

            if(link.contains("google")){
                System.out.println("Link google Found");
            }

            if(link.contains("facebook")){
                System.out.println("Link facebook Found");
            }
            if(link.contains("imstagram")){
                System.out.println("Link imstagram Found");
            }

            if(link.contains("imstagram")){
                System.out.println("Link imstagram Found");
            }

            if(link.contains("linkedin")){
                System.out.println("Link linkedin Found");
            }

        }
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
