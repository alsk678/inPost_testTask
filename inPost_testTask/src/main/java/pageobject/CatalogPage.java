package pageobject;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.ClickHelper.tapBottomCenter;


public class CatalogPage extends BasePage {

    public CatalogPage() {
        super();
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"test-Item\"`]")
    private List<WebElement> catalogueItems;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"test-ADD TO CART\"`]")
    private List<WebElement> addToCartButtons;

    @iOSXCUITFindBy(accessibility = "test-REMOVE")
    private WebElement removeButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Cart\" and @label=\"1\"]")
    private WebElement cartWithItemButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"test-Item title\"`]")
    private List<WebElement> itemTitles;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"test-Price\"`]")
    private List<WebElement> itemsPrices;

    public boolean areItemsUpload() {
        return !catalogueItems.isEmpty();
    }

    public void clickAddToCartById(int id) {
        addToCartButtons.get(id - 1).click();
    }

    public boolean isRemoveButtonShown() {
        return removeButton.isDisplayed();
    }

    public boolean isCartWithItemShown() {
        return cartWithItemButton.isDisplayed();
    }

    public String getTitleFromItemById(int id) {
        return itemTitles.get(id - 1).getText();
    }

    public void clickCartButton() {
        tapBottomCenter(cartWithItemButton);
    }

    public String getItemPriceById(int id) {
        return itemsPrices.get(id - 1).getText();
    }
}
