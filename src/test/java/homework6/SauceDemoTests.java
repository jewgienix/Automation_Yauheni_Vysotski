package homework6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.SimpleWebDriver.*;

public class SauceDemoTests {
    @BeforeTest
    public void setUp() {
        setUpWebDriver("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void login() {
        WebElement login = getWebDriver().findElement(By.id("user-name")); //id
        login.click();
        login.sendKeys("standard_user");
        WebElement password = getWebDriver().findElement(By.name("password")); //name
        password.sendKeys("secret_sauce");
        WebElement LoginButton = getWebDriver().findElement(By.className("submit-button")); //className
        LoginButton.click();
    }

    @Test(priority = 2)
    public void productMenu() {
        WebElement backpack = getWebDriver().findElement(By.linkText("Sauce Labs Backpack")); //linktext
        backpack.click();
        WebElement addToCartButton = getWebDriver().findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")); //xpath
        addToCartButton.click();
        WebElement shoppingCartButton = getWebDriver().findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]")); //xpath
        shoppingCartButton.click();

        Assert.assertEquals(getWebDriver().findElement(By.id("item_4_title_link")).getText(), "Sauce Labs Backpack", "The product name does not match the original"); //id
        Assert.assertEquals(getWebDriver().findElement(By.cssSelector("[class='inventory_item_price']")).getText(), "$29.99", "The price tag is incorrect"); //cssSelector
    }

    @Test(priority = 3)
    public void continueShopping() {
        WebElement continueShoppingButton = getWebDriver().findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")); //xpath
        continueShoppingButton.click();
        WebElement removeButton = getWebDriver().findElement(By.cssSelector("button.btn.btn_secondary.btn_small.btn_inventory[data-test='remove-sauce-labs-backpack']"));//cssSelector
        removeButton.click();
        WebElement tShirt = getWebDriver().findElement(By.xpath("//div[@class='inventory_item_name ' and text()='Sauce Labs Bolt T-Shirt']")); //xpath
        tShirt.click();
        WebElement addToCartButton = getWebDriver().findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']")); //xpath
        addToCartButton.click();
        WebElement cartButton = getWebDriver().findElement(By.cssSelector(".shopping_cart_container")); //cssSelector
        cartButton.click();

        Assert.assertEquals(getWebDriver().findElement(By.id("item_1_title_link")).getText(), "Sauce Labs Bolt T-Shirt", "The product name does not match the original"); //id
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//div[@class='inventory_item_price']")).getText(), "$15.99", "The price tag is incorrect"); //xpath
    }

    @AfterTest
    public void tearDown() {
        quit();
    }
}
