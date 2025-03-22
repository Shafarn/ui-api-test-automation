package ui.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void isOnCartPage() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.demoblaze.com/cart.html");
    }

    public void productInCart(String productName) {
        By locator = By.xpath("//td[text()='" + productName + "']");
        waitUntilVisible(locator);
        Assert.assertTrue(driver.findElement(locator).isDisplayed());
    }

    public void removeProductOnIndex(int index) {
        By locator = By.xpath("(//a[text()='Delete'])["+index+"]");
        waitUntilVisible(locator);
        driver.findElement(locator).click();
    }

    public void productNotInCart(String productName) {
        By locator = By.xpath("//td[text()='" + productName + "']");
        Assert.assertTrue(driver.findElements(locator).isEmpty());
    }

    public void clickPlaceOrderBtn() {
        By locator = By.xpath("//button[text()='Place Order']");
        waitUntilVisible(locator);
        driver.findElement(locator).click();
    }

    public void placeOrderModalShown() {
        By locator = By.id("orderModalLabel");
        waitUntilVisible(locator);
        Assert.assertTrue(driver.findElement(locator).isDisplayed());
    }

    public void inputOrderDetails() {
        driver.findElement(By.id("name")).sendKeys("Customer");
        driver.findElement(By.id("country")).sendKeys("Indonesia");
        driver.findElement(By.id("city")).sendKeys("Jakarta");
        driver.findElement(By.id("card")).sendKeys("1234567890");
        driver.findElement(By.id("month")).sendKeys("12");
        driver.findElement(By.id("year")).sendKeys("12");
    }

    public void clickPurchaseBtn() {
        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
    }

    public void successModalShown() {
        By locator = By.xpath("//h2[text()='Thank you for your purchase!']");
        waitUntilVisible(locator);
        Assert.assertTrue(driver.findElement(locator).isDisplayed());
    }
}
