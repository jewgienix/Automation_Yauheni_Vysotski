package homewrork4;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SeleniumGoogleTestTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void seleniumGoogleTest() {
        driver.get("https://www.google.by/");
        driver.manage().window().setSize(new Dimension(1470, 849));
        driver.findElement(By.id("APjFqb")).sendKeys("he");
        driver.findElement(By.cssSelector(".sbhl .pcTkSc")).click();
        driver.findElement(By.cssSelector("#rso > .MjjYud:nth-child(1) .LC20lb")).click();
    }
}
