package api.objects;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Request {
    protected final String BASE_URL = "https://dummyapi.io/data/v1";
    protected final String TOKEN = "63a804408eb0cb069b57e43a";

    private Response response;
    private static final String APP_ID_HEADER = "app-id";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String ACCEPT_HEADER = "Accept";

    public void setEndpoint(String endpoint) {
        RestAssured.baseURI = BASE_URL + endpoint;
    }

    public void sendRequest(String method) {
        response = given().log().all()
                .header(APP_ID_HEADER, TOKEN)
                .accept(ACCEPT_HEADER + "application/json")
                .when()
                .request(method)
                .then().log().all()
                .extract().response();
}

    public void sendRequestWithBody(String method, String requestBody) {
        response = given().log().all()
                .header(APP_ID_HEADER, TOKEN)
                .header(CONTENT_TYPE_HEADER, "application/json")
                .body(requestBody)
                .when()
                .request(method)
                .then().log().all()
                .extract()
                .response();
    }

    public Response sendRequestWithId(String method, int id, String requestBody) {
        response = given().log().all()
                .header(APP_ID_HEADER, TOKEN)
                .contentType(CONTENT_TYPE_HEADER + "=application/json")
                .accept(ACCEPT_HEADER + "=application/json")
                .when()
                .request(method, "/" + id)
                .then().log().all()
                .extract().response();

        return response;
    }

    public void validateResponseStatusCode(int code) {
        Assertions.assertEquals(code, response.getStatusCode());
        System.out.println("The status code is correct");
    }

    public void validateResponseBody(String key, String value) {
        JsonPath jsonPath = new JsonPath(response.getBody().asString());
        String actualValue = jsonPath.get(key);
        Assertions.assertEquals(value, actualValue);
    }

    public String getIdFromResponse() {
        JsonPath jsonPath = new JsonPath(response.getBody().asString());
        return jsonPath.getString("id");
    }
}