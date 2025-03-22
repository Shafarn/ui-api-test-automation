package ui.stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHook extends BaseTest {
    @Before(order = 1)
    public void beforeTest() {
        getDriver();
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}
