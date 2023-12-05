package homework5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
        LenghtSearch.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        LenghtSearch.sendKeys("7");
        LenghtSearch.sendKeys(Keys.ENTER);

        WebElement WidthSearch = driver.findElement(By.name("calc_roomheight"));
        WidthSearch.click();
        WidthSearch.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        WidthSearch.sendKeys("5");
        WidthSearch.sendKeys(Keys.ENTER);

        WebElement Button = driver.findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']"));
        Button.click();

    }
    @AfterTest
    public void tearDown() {
        //driver.quit();
    }
}
