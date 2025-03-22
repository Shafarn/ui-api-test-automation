package ui.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    WebDriver driver;

    private final By addToCartBtn = By.xpath("//a[text()='Add to cart']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProduct(String productName) {
        By productLink = By.xpath("//a[text()='" + productName + "']");
        waitUntilVisible(productLink);
        driver.findElement(productLink).isDisplayed();
        driver.findElement(productLink).click();
    }

    public void userIsOnProductDetailPage(String productName) {
        By productTitle = By.xpath("//*[@id=\"tbodyid\"]/h2[text()='" + productName + "']");
        waitUntilVisible(productTitle);
        driver.findElement(productTitle).isDisplayed();
        driver.findElement(By.className("price-container")).isDisplayed();
        driver.findElement(addToCartBtn).isDisplayed();
    }

    public void addToCart() {
        waitUntilVisible(addToCartBtn);
        driver.findElement(addToCartBtn).click();
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public void waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void alertMessageShown(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(actualMessage, message);
    }

    public void addProductToCart(String productName) {
        clickProduct(productName);
        userIsOnProductDetailPage(productName);
        addToCart();
        alertMessageShown("Product added.");
        driver.switchTo().alert().accept();
    }

    public void clickCartNav() {
        By cartNav = By.xpath("//a[text()='Cart']");
        waitUntilVisible(cartNav);
        driver.findElement(cartNav).click();
    }

    public void clickHomeNav() {
        By homeNav = By.xpath("//a[text()='Home ']");
        waitUntilVisible(homeNav);
        driver.findElement(homeNav).click();
    }
}
