package org.testautomation.app.api.clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testautomation.app.api.models.Order;
import org.testautomation.core.api.BaseAPIClient;

public class StoresClient extends BaseAPIClient<StoresClient> {
    private final String ENDPOINT = "/store";

    public StoresClient createOrder(Order order) {
        setResponse(RestAssured.given()
                .contentType(ContentType.JSON)
                .body(order)
                .when()
                .post(ENDPOINT + "/order")
        );

        return this;
    }

    public StoresClient getOrder(Long id) {
        setResponse(RestAssured.get(ENDPOINT + "/order/" + id));
        return this;
    }

    public StoresClient deleteOrder(Long id) {
        setResponse(RestAssured.delete(ENDPOINT + "/order/" + id));
        return this;
    }

    public StoresClient getStoreInventory() {
        setResponse(RestAssured.get(ENDPOINT + "/inventory"));
        return this;
    }
}
