import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"api.stepDef"},
        features = {"src/test/java/api/features"},
        plugin = {"pretty", "html:reports/cucumber.html", "json:reports/cucumber.json"},
        tags = "@api"
)
public class APITest {
}
