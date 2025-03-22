package ui.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    By usernameInputField = By.xpath("//input[@id=\"loginusername\"]");
    By passwordInputField = By.xpath("//input[@id=\"loginpassword\"]");
    By loginModalButton = By.id("login2");
    By loginButton = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    String url = "https://www.demoblaze.com";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void inputUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputField));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));
        driver.findElement(usernameInputField).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
    }

    public void loginModalIsShown() {
        driver.findElement(By.id("logInModal")).isDisplayed();
    }

    public void clickLoginModalButton() {
        driver.findElement(loginModalButton).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void userIsLoggedIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By welcomeText = By.xpath("//*[@id=\"nameofuser\"]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText));
        driver.findElement(welcomeText).isDisplayed();
    }

    public void login(String username, String password) {
        this.driver.get(this.getUrl());
        this.clickLoginModalButton();
        this.inputUsername(username);
        this.inputPassword(password);
        this.clickLoginButton();
        this.userIsLoggedIn();
    }

    public void goToLoginPage() {
        driver.get(this.getUrl());
    }

    public void alertMessageShown(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(actualMessage, message);
    }
}