package basetest;

import driver.DriverManager;
import listener.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pageobject.CartPage;
import pageobject.CatalogPage;
import pageobject.CompletePage;
import pageobject.InformationPage;
import pageobject.LoginPage;
import pageobject.OverviewPage;

@Listeners(TestListener.class)
public abstract class BaseTest {

    public LoginPage loginPage;
    public CatalogPage catalogPage;
    public CartPage cartPage;
    public InformationPage informationPage;
    public OverviewPage overviewPage;
    public CompletePage completePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.getDriver();
        initPages();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }

    public void initPages() {
        loginPage = new LoginPage();
        catalogPage = new CatalogPage();
        cartPage = new CartPage();
        informationPage = new InformationPage();
        overviewPage = new OverviewPage();
        completePage = new CompletePage();
    }
}
