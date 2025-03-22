package ui.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import ui.pages.OrderPage;

public class OrderStepDef extends BaseTest {
    protected OrderPage orderPage = new OrderPage(driver);


    @Given("user is on the cart page")
    public void userClickLoginNavMenu(String productName) {
       orderPage.isOnCartPage();
    }

    @Then("user should see product {string} on the cart page")
    public void userShouldSeeProductOnTheCartPage(String productName) {
        orderPage.productInCart(productName);
    }

    @Then("user remove the first product")
    public void userRemoveTheFirstProduct() {
        orderPage.removeProductOnIndex(1);
    }

    @Then("user should NOT see {string} on the cart page")
    public void userShouldNOTSeeOnTheCartPage(String productName) {
        orderPage.productNotInCart(productName);
    }

    @Then("user click place order button")
    public void userClickPlaceOrderButton() {
        orderPage.clickPlaceOrderBtn();
    }

    @And("user should see place order modal")
    public void userShouldSeePlaceOrderModal() {
        orderPage.placeOrderModalShown();
    }

    @Then("user should input order details")
    public void userShouldInputOrderDetails() {
        orderPage.inputOrderDetails();
    }

    @And("click purchase button")
    public void clickPurchaseButton() {
        orderPage.clickPurchaseBtn();
    }

    @Then("success purchase modal is shown")
    public void successPurchaseModalIsShown() {
        orderPage.successModalShown();
    }
}
