package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class DynamicControlsPage extends BasePage {
    private final By header = By.tagName("h4");
    private final By removeButton = By.cssSelector("[type='button']");
    private final By firstMessage = By.id("message");
    private final By checkboxVision = By.id("checkbox");
    private final By enableButton = By.cssSelector("[onclick='swapInput()']");
    private final By secondMessage = By.id("message");
    private final By textField = By.cssSelector("input[type='text']");

    public void verifyTitleText() {
        wait.until(textToBe(header, "Dynamic Controls"));
    }

    public void clickOnRemoveButton() {
        click(removeButton);
    }

    public void clickOnEnableButton() {
        click(enableButton);
    }

    public void verifyFirstMessage() {
        wait.until(ExpectedConditions.textToBe(firstMessage, "It's gone!"));
    }

    public void verifySecondMessage() {
        wait.until(ExpectedConditions.textToBe(secondMessage, "It's enabled!"));
    }

    public void verifyCheckbox() {
        wait.until(visibilityOfElementLocated(checkboxVision));
    }

    public void verifyNotCheckbox() {
        wait.until(not(visibilityOfElementLocated(checkboxVision)));
    }

    public void enterText(String text) {
        sendKeys(textField, text);
    }

    public void verifyTextFieldIsDisabled() {
        wait.until(not(elementToBeClickable(textField)));
    }


}
