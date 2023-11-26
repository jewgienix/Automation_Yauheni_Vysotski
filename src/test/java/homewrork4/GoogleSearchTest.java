package homewrork4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearchTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void GoogleSearchPositiveTest(){
        driver.get("https://www.google.by/");
        WebElement continueButton = driver.findElement(By.id("L2AGLb"));
        continueButton.click();
        WebElement searchLine = driver.findElement(By.id("APjFqb"));
        searchLine.sendKeys("Hello, world");
        searchLine.sendKeys(Keys.ENTER);
        WebElement positiveResult = driver.findElement(By.id("result-stats"));
        Assert.assertTrue(positiveResult.isDisplayed());
    }
    @Test(priority = 2)
    public void GoogleSearchNegativeTest(){
        driver.get("https://google.by/");
        WebElement continueButton = driver.findElement(By.id("L2AGLb"));
        continueButton.click();
        WebElement searchLine = driver.findElement(By.id("APjFqb"));
        searchLine.sendKeys("-DskipTests=true");
        searchLine.sendKeys(Keys.ENTER);
        WebElement negativeResult = driver.findElement(By.cssSelector("[style='margin-top:1em']"));
        Assert.assertTrue(negativeResult.isDisplayed());
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }



}
