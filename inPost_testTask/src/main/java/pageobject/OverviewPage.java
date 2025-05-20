package pageobject;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import static helpers.SwipeHelper.swipeToElement;

public class OverviewPage extends BasePage {

    public OverviewPage() {
        super();
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name CONTAINS \"Payment Information\"`]")
    private WebElement paymentSection;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name CONTAINS \"Shipping Information\"`]")
    private WebElement shippingInformationSection;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name CONTAINS \"Shipping Information\"`]")
    private WebElement priceSection;

    @iOSXCUITFindBy(accessibility = "test-FINISH")
    private WebElement finishButton;

    public boolean isPaymentSectionShown() {
        return paymentSection.isDisplayed();
    }

    public boolean isShippingSectionShown() {
        return shippingInformationSection.isDisplayed();
    }

    public boolean isPriceSectionShown() {
        return priceSection.isDisplayed();
    }

    public void clickFinishButton() {
        swipeToElement(finishButton);
        finishButton.click();
    }
}
