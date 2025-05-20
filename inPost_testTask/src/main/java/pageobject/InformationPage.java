package pageobject;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import static data.Variables.FIRST_NAME;
import static data.Variables.LAST_NAME;
import static data.Variables.ZIP_CODE;
import static utility.WaitUtils.waitForElementToBeVisible;

public class InformationPage extends BasePage {

    public InformationPage() {
        super();
    }

    @iOSXCUITFindBy(accessibility = "test-First Name")
    private WebElement firstNameField;

    @iOSXCUITFindBy(accessibility = "test-Last Name")
    private WebElement lastNameField;

    @iOSXCUITFindBy(accessibility = "test-Zip/Postal Code")
    private WebElement zipCodeField;

    @iOSXCUITFindBy(accessibility = "test-CONTINUE")
    private WebElement continueButton;

    public void typeIntoFirstNameField(String input) {
        waitForElementToBeVisible(firstNameField);
        firstNameField.sendKeys(input);
    }

    public void typeIntoLastNameField(String input) {
        lastNameField.sendKeys(input);
    }

    public void typeIntoZipCodeField(String input) {
        zipCodeField.sendKeys(input);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void fillCheckoutData() {
        typeIntoFirstNameField(FIRST_NAME);
        typeIntoLastNameField(LAST_NAME);
        typeIntoZipCodeField(ZIP_CODE);
        clickContinueButton();
    }
}
