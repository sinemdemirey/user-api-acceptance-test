package org.example.helper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class GeneralApiController {
    private static final Logger LOGGER = LogManager.getLogger(GeneralApiController.class);

    private final RequestSpecification spec;

    public GeneralApiController(String baseUrl) {
        this.spec = new RequestSpecBuilder().setBaseUri(baseUrl).setBasePath("/").build();
    }

    protected ReadableResponse getRequest(String endPoint) {
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .get(endPoint)
                .then()
                .extract()
                .response();

        LOGGER.info(format("Get request is successful to %s", endPoint));

        return new ReadableResponse(response);
    }

    protected ReadableResponse postRequest(JSONObject jsonObject, String endPoint) {
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when()
                .post(endPoint)
                .then()
                .extract()
                .response();

        LOGGER.info(format("Post request is successful to %s, Body: %s ", endPoint, jsonObject));

        return new ReadableResponse(response);
    }

    protected ReadableResponse putRequest(JSONObject jsonObject, String endPoint) {
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when()
                .put(endPoint)
                .then()
                .extract()
                .response();

        LOGGER.info(format("Put request is successful to %s, Body: %s ", endPoint, jsonObject));

        return new ReadableResponse(response);
    }

    protected ReadableResponse deleteRequest(String endPoint) {
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .delete(endPoint)
                .then()
                .extract()
                .response();

        LOGGER.info(format("Delete request is successful to %s", endPoint));

        return new ReadableResponse(response);
    }
}
