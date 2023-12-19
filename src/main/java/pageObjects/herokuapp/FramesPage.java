package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class FramesPage extends BasePage {
    private final By header = By.tagName("h3");
    private final By frame = By.id("mce_0_ifr");

    private final By textField = By.tagName("p");
    private final By textIsDisplayed = By.id("tinymce");

    private By getItem(String name) {
        return By.linkText(name);
    }


    public void verifyTitleText() {
        wait.until(textToBe(header, "Frames"));
    }

    public void clickOnItem(String itemName) {
        click(getItem(itemName));
    }

    public void switchToFrame() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(frame)));
        driver.switchTo().frame(driver.findElement(frame));
    }

    public void enterText(String text) {
        sendKeys(textField, text);
    }

    public void unSwitchToFrame() {
        driver.switchTo().defaultContent();
    }
    public void verifyTextIsDisplayed(){
        wait.until(ExpectedConditions.textToBe(textIsDisplayed, "Your content goes here."));

    }
}
