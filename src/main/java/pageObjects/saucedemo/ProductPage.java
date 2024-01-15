package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
import pageObjects.saucedemo.elements.HeaderElement;


import static driver.DriverCreation.getDriver;

public class ProductPage extends BasePage {
    private final By header = By.className("app_logo");
    private final By productList = By.className("inventory_item");
    private final By addToCart = By.tagName("button");
    private final By addToCartButton = By.cssSelector("[class='btn btn_primary btn_small btn_inventory']");
    public HeaderElement headerElement = new HeaderElement();

    public void verifyPage() {
        Assert.assertEquals(getDriver().findElement(header).getText(), "Swag Labs", "Wrong header name.");
        Assert.assertFalse(getDriver().findElements(productList).isEmpty(), "Product list is empty.");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Wrong header url.");
    }

    public void clickAddToCart(Integer index) {
        click(getDriver().findElements(productList).get(index).findElement(addToCart));
    }
    public void clickItem(String product){
        click(driver.findElement(By.xpath("//div[text()='" + product + "']")));
    }
    public void clickAddToCartButton(){
        click(addToCartButton);
    }
}
