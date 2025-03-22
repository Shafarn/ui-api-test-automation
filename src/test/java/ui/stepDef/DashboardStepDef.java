package ui.stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.pages.DashboardPage;

public class DashboardStepDef extends BaseTest {
    protected DashboardPage dashboardPage = new DashboardPage(driver);

    private String currentProductName;

    @When("user click product with title {string}")
    public void userClickLoginNavMenu(String productName) {
        this.currentProductName = productName;
        dashboardPage.clickProduct(productName);
    }

    @Then("user will navigate to product detail")
    public void userWillNavigateToProductDetail() {
        dashboardPage.userIsOnProductDetailPage(currentProductName);
    }

    @When("user click add to cart")
    public void userClickAddToCart() {
        dashboardPage.addToCart();
    }

    @When("user go to this url {string}")
    public void userGoToThisUrl(String url) {
        dashboardPage.goToUrl(url);
    }

    @When("user add product {string} to the cart")
    public void userAddProductToTheCart(String productName) {
        dashboardPage.addProductToCart(productName);
    }

    @When("user navigate to the cart page")
    public void userNavigateToTheCartPage() {
        dashboardPage.clickCartNav();
    }

    @Then("user back to home page")
    public void userBackToHomePage() {
        dashboardPage.clickHomeNav();
    }
}
