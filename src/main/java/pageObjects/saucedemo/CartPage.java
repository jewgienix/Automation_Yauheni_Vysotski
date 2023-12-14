package pageObjects.saucedemo;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class CartPage extends BasePage {
    private final By cartLink = By.id("shopping_cart_container");
    private final By header = By.className("title");
    private final By cartItem = By.className("cart_item");
    private final By removeButton = By.id("remove-sauce-labs-bike-light");

    public void checkCart(){
        click(cartLink);
    }
    public void removeItem(){
        click(removeButton);
    }



}
