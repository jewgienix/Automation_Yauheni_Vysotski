package pageObjects.saucedemo;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;
import pageObjects.saucedemo.elements.HeaderElement;

public class CartPage extends BasePage {
    private final By cartLink = By.id("shopping_cart_container");
    private final By header = By.className("title");
    private final By cartItem = By.className("cart_item");
    private final By removeButton = By.cssSelector("[class='btn btn_secondary btn_small cart_button']");
    public HeaderElement headerElement = new HeaderElement();

    public void checkCart(){
        click(cartLink);
    }
    public void removeItem(){
        click(removeButton);
    }

    public void clickRemoveByIndex(Integer index) {
        click(driver.findElements(removeButton).get(index - 1));
    }




}
