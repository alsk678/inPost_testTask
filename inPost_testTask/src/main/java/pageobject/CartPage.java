package pageobject;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utility.WaitUtils.waitForElementToBeVisible;

public class CartPage extends BasePage {

    public CartPage() {
        super();
    }

    @iOSXCUITFindBy(accessibility = "test-CHECKOUT")
    private WebElement checkoutButton;

    public boolean isCartContainingItem(String id) {
        return driver.findElement(By.id(id)).isDisplayed();
    }

    public boolean isCartContainingPrice(String price) {
        return driver.findElement(By.id(price)).isDisplayed();
    }

    public void clickCheckoutButton() {
        waitForElementToBeVisible(checkoutButton);
        checkoutButton.click();
    }
}
