package homework5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LaminateCalcTests {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
    }
    @Test
    public void test1() {
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
        WebElement LenghtSearch = driver.findElement(By.name("calc_roomwidth"));
        LenghtSearch.click();
        LenghtSearch.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE);
        LenghtSearch.sendKeys("5");
        LenghtSearch.sendKeys(Keys.ENTER);

        WebElement WidthSearch = driver.findElement(By.name("calc_roomheight"));
        WidthSearch.click();
        WidthSearch.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE);
        WidthSearch.sendKeys("7");
        WidthSearch.sendKeys(Keys.ENTER);

        WebElement Button = driver.findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']"));
        Button.click();

        WebElement result = driver.findElement(By.id("s_lam"));
        Assert.assertTrue(result.isDisplayed(), "34.76");
    }
    @Test
    public void test2() {
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
        WebElement LenghtSearch = driver.findElement(By.name("calc_roomwidth"));
        LenghtSearch.click();
        LenghtSearch.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE);
        LenghtSearch.sendKeys("7");
        LenghtSearch.sendKeys(Keys.ENTER);

        WebElement WidthSearch = driver.findElement(By.name("calc_roomheight"));
        WidthSearch.click();
        WidthSearch.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE);
        WidthSearch.sendKeys("9");
        WidthSearch.sendKeys(Keys.ENTER);

        WebElement Button = driver.findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']"));
        Button.click();

        Assert.assertEquals(driver.findElement(By.id("s_lam")).getText(), "62.68 м2.");
    }

    @Test
    public void test3() {
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
        WebElement LenghtSearch = driver.findElement(By.name("calc_roomwidth"));
        LenghtSearch.click();
        LenghtSearch.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE);
        LenghtSearch.sendKeys("0");
        LenghtSearch.sendKeys(Keys.ENTER);

        WebElement WidthSearch = driver.findElement(By.name("calc_roomheight"));
        WidthSearch.click();
        WidthSearch.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE);
        WidthSearch.sendKeys("0");
        WidthSearch.sendKeys(Keys.ENTER);

        WebElement Button = driver.findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']"));
        Button.click();

        Assert.assertEquals(driver.findElement(By.id("s_lam")).getText(), "0 м2.", "Error, zero values turned into digits 1");
    }
    @Test
    public void test4() {
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
        WebElement LenghtSearch = driver.findElement(By.name("calc_roomwidth"));
        LenghtSearch.click();
        LenghtSearch.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE);
        LenghtSearch.sendKeys("-2");
        LenghtSearch.sendKeys(Keys.ENTER);

        WebElement WidthSearch = driver.findElement(By.name("calc_roomheight"));
        WidthSearch.click();
        WidthSearch.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE);
        WidthSearch.sendKeys("-6");
        WidthSearch.sendKeys(Keys.ENTER);

        WebElement Button = driver.findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']"));
        Button.click();

        Assert.assertEquals(driver.findElement(By.id("s_lam")).getText(), "0 м2.", "Error, negative values have turned into positive ones");
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
