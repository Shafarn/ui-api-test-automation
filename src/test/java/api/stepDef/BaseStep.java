package api.stepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import api.objects.Request;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseStep {
    Request req = new Request();
    private String requestBody;
    Faker faker = new Faker();
    private final String fakeFirstName = faker.name().firstName();
    private final String fakeLastName = faker.name().lastName();
    private final String fakeEmail = faker.name().username() + "@shafa.com";
    private String userId;

    @Given("send {string} request to {string} endpoint")
        public void sendRequestForToEndpoint(String requestMethod, String endpoint) {
        req.setEndpoint(endpoint);
        req.sendRequest(requestMethod);
    }

    @When("send {string} request to {string} endpoint with request body")
    public void sendRequestForToEndpointWithBody(String requestMethod, String endpoint) {
        req.setEndpoint(endpoint);
        req.sendRequestWithBody(requestMethod, requestBody);
    }

    @Given("send {string} request to fake user endpoint")
    public void sendRequestForSpecificUser(String requestMethod) {
        req.setEndpoint("/user/"+this.userId);
        System.out.println("Generated User Id" + this.userId);
        req.sendRequest(requestMethod);
    }

    @When("send {string} request to fake user endpoint with request body")
    public void sendRequestForSpecificUserWithBody(String requestMethod) {
        req.setEndpoint("/user/"+this.userId);
        req.sendRequestWithBody(requestMethod, requestBody);
    }

    @Then("the response code should be {int}")
    public void theResponseCodeShouldBe(int statusCode) {
        req.validateResponseStatusCode(statusCode);
    }

    @Then("save the created user id")
    public void saveTheCreatedUserId() {
        this.userId = req.getIdFromResponse();
    }

    @Given("I have a user data")
    public void iHaveAUserData() {
        this.requestBody = """
                {
                   "title": "%s",
                   "firstName": "%s",
                   "lastName": "%s",
                   "email": "%s"
                }""".formatted(
                "ms",
                fakeFirstName,
                fakeLastName,
                fakeEmail
        );
    }

    @Given("Create a User")
    public void createAUser() {
        iHaveAUserData();
        sendRequestForToEndpointWithBody("POST","/user/create");
        theResponseCodeShouldBe(200);
        validateTheFollowingFieldsInTheResponseBody("title, firstName, lastName, email");
        saveTheCreatedUserId();
    }

    @And("the response body should contain object with key {string} and value {string}")
    public void theResponseBodyShouldContainKeyTitleAndValueMs(String key, String value) {
        req.validateResponseBody(key, value);
    }

    @And("validate the following fields in the response body: {string}")
    public void validateTheFollowingFieldsInTheResponseBody(String field) {
        switch (field) {
            case "title":
                req.validateResponseBody(field, "ms");
                break;
            case "firstName":
                req.validateResponseBody(field, fakeFirstName);
                break;
            case "lastName":
                req.validateResponseBody(field, fakeLastName);
                break;
            case "email":
                req.validateResponseBody(field, fakeEmail);
                break;
        }
    }

    @And("the response body should contain the created userId")
    public void theResponseBodyShouldContainTheCreatedUserId() {
        req.validateResponseBody("id", this.userId);
    }

    @And("the response body should contain error message indicating that the user was not found")
    public void theResponseBodyShouldContainErrorMessageIndicatingThatTheUserWasNotFound() {
        req.validateResponseBody("error", "RESOURCE_NOT_FOUND");
    }
}
