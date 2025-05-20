package pageobject;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import static data.Variables.PASSWORD;
import static data.Variables.STANDARD_USER_LOGIN;
import static utility.WaitUtils.waitForElementToBeVisible;


public class LoginPage extends BasePage {

    public LoginPage() {
        super();
    }

    @iOSXCUITFindBy(accessibility = "test-Username")
    private WebElement usernameField;

    @iOSXCUITFindBy(accessibility = "test-Password")
    private WebElement passwordField;

    @iOSXCUITFindBy(accessibility = "test-LOGIN")
    private WebElement loginButton;

    public void typeIntoUsernameField(String input) {
        waitForElementToBeVisible(usernameField);
        usernameField.sendKeys(input);
    }

    public void typeIntoPasswordField(String input) {
        passwordField.sendKeys(input);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void loginAsStandardUser() {
        typeIntoUsernameField(STANDARD_USER_LOGIN);
        typeIntoPasswordField(PASSWORD);
        clickLoginButton();
    }
}
