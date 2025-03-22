package ui.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.pages.LoginPage;

public class LoginStepDef extends BaseTest {
    protected LoginPage loginPage = new LoginPage(driver);

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        loginPage.goToLoginPage();
    }

    @When("user click login nav menu")
    public void userClickLoginNavMenu() {
        loginPage.clickLoginModalButton();
    }

    @Then("modal login is shown")
    public void modalLoginIsShown() {
        loginPage.loginModalIsShown();
    }

    @And("user input username {string}")
    public void userInputUsername(String username) {
        loginPage.inputUsername(username);
    }


    @And("user input password {string}")
    public void userInputPassword(String password) {
        loginPage.inputPassword(password);
    }

    @And("user press login button")
    public void userPressLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {

    }

    @Then("alert will show {string}")
    public void alertWillShow(String message) {
        loginPage.alertMessageShown(message);
    }

    @Given("user login with username {string} and password {string}")
    public void userLoginWithUsernameAndPassword(String username, String password) {
        loginPage.login(username, password);
    }
}
