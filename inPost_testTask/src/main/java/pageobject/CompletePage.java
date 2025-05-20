package pageobject;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;


public class CompletePage extends BasePage {

    public CompletePage() {
        super();
    }

    @iOSXCUITFindBy(accessibility = "THANK YOU FOR YOU ORDER")
    private WebElement confirmationLabel;

    public boolean isConfirmationLabelShown() {
        return confirmationLabel.isDisplayed();
    }
}
