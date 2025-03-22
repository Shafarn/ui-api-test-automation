import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"ui.stepDef"},
        features = {"src/test/java/ui/features"},
        plugin = {"pretty", "html:reports/cucumber.html", "json:reports/cucumber.json"},
        tags = "@web"
)

public class UITest {
}