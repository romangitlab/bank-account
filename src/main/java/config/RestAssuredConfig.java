package config;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RestAssuredConfig {
    public static RequestSpecification requestSpecWithoutApiKey;
    public static RequestSpecification requestSpecWithApiKey;

    public static void setupRequestSpecification() {
        requestSpecWithoutApiKey = new RequestSpecBuilder()
                .setBaseUri(URLConfigs.API_URL)
                .setBasePath("/api/v3/")
                .addFilter(new AllureRestAssured())
                .addHeader("Content-Type", "application/json")
                .build();

        requestSpecWithApiKey = new RequestSpecBuilder()
                .setBaseUri(URLConfigs.API_URL)
                .setBasePath("/api/v3/")
                .addFilter(new AllureRestAssured())
                .addHeader("Content-Type", "application/json")
                .addHeader("X-Auth-Key", URLConfigs.COMMAND_LINE_AUTH_KEY)
                .build();
    }
}
