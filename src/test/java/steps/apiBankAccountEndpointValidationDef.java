package steps;

import config.URLConfigs;
import config.RestAssuredConfig;
import endpoints.Endpoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.BankAccount;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class apiBankAccountEndpointValidationDef {

    RequestSpecification request;
    Response response;

    @Given("the bank account validation request without a JWT token")
    public void theBankAccountValidationRequestWithoutAJWTToken() {
        request = given(RestAssuredConfig.requestSpecWithoutApiKey);
    }

    @When("sample request is sent to the server")
    public void sampleRequestIsSentToTheServer() {
        response = request.
                           body(new BankAccount()).
                           post(Endpoints.BANK_ACCOUNT);
    }

    @Then("server responds with HTTP response code {int}")
    public void serverRespondsWithHTTPResponseCode(int code) {
        assertThat(response.getStatusCode(), equalTo(code));
    }

    @And("response body contains {string} message.")
    public void responseBodyContainsAuthorizationHasBeenDeniedForThisRequestMessage(String message) {
        assertThat(message, equalTo(JsonPath.from(response.asString()).get("message")));
    }

    @Given("the bank account validation request with a valid IBAN")
    public void theBankAccountValidationRequestWithAValidIBAN() {
        request = given(RestAssuredConfig.requestSpecWithApiKey)
                .body(new BankAccount());
    }

    @And("valid authentication token")
    public void validAuthenticationToken() {
        assertThat(URLConfigs.COMMAND_LINE_AUTH_KEY, equalTo(URLConfigs.STORED_AUTH_KEY));
    }

    @When("bank account validation request is sent to the server")
    public void bankAccountValidationRequestIsSentToTheServer() {
        response = request
                .post(Endpoints.BANK_ACCOUNT);
    }

    @And("response body contains isValid = true")
    public void responseBodyContainsIsValidTrue() {
        assertThat(response.getBody().as(BankAccount.class).getIsValid(), is(true));
    }
}
