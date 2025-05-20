package testscripts;

import basetest.BaseTest;
import org.testng.annotations.Test;
import utility.RetryAnalyzer;

import static org.testng.Assert.assertTrue;

public class EndToEndTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void e2ePerformItemCheckoutTest() {
        int productNumber = 1;

        loginPage.loginAsStandardUser();
        assertTrue(catalogPage.areItemsUpload(), "Items aren't upload");
        catalogPage.clickAddToCartById(productNumber);
        assertTrue(catalogPage.isRemoveButtonShown(), "Remove button isn't shown");
        assertTrue(catalogPage.isCartWithItemShown(), "Cart icon doesn't show item counter");
        String itemTitle = catalogPage.getTitleFromItemById(productNumber);
        String itemPrice = catalogPage.getItemPriceById(productNumber);
        catalogPage.clickCartButton();
        assertTrue(cartPage.isCartContainingItem(itemTitle), "Cart doesn't contain added item");
        assertTrue(cartPage.isCartContainingPrice(itemPrice), "Cart doesn't contain added price");
        cartPage.clickCheckoutButton();
        informationPage.fillCheckoutData();
        assertTrue(overviewPage.isPaymentSectionShown(), "Payment section is not shown");
        assertTrue(overviewPage.isPriceSectionShown(), "Price section is not shown");
        assertTrue(overviewPage.isShippingSectionShown(), "Shipping section is not shown");
        overviewPage.clickFinishButton();
        assertTrue(completePage.isConfirmationLabelShown(), "Confirmation label is not shown");
    }
}
