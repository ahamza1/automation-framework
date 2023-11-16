package org.testautomation.app.api;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testautomation.app.api.clients.StoresClient;
import org.testautomation.app.api.models.Order;
import org.testautomation.app.api.models.enums.OrderStatusEnum;
import org.testautomation.core.BaseAPITest;
import org.testautomation.core.constants.TestGroup;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StoresClientTests extends BaseAPITest {
    private StoresClient storesClient;

    @BeforeMethod(groups = TestGroup.API)
    public void testSetup() {
        storesClient = new StoresClient();
    }

    @Test(groups = TestGroup.API)
    public void verifyCanCreateOrder() {
        Order order = new Order(1L, 1L, 1, "2023-11-15T22:20:39.423+0000", OrderStatusEnum.PLACED, true);

        storesClient.createOrder(order)
                .assertStatusCode(HttpStatus.SC_OK)
                .assertContentType(ContentType.JSON)
                .assertResponseBody(order);
    }

    @Test(groups = TestGroup.API)
    public void verifyCanGetOrder() {
        Long orderId = 2L;
        createOrder(orderId);

        storesClient.getOrder(orderId)
                .assertStatusCode(HttpStatus.SC_OK)
                .assertContentType(ContentType.JSON)
                .assertResponseBody(orderId, "id");
    }

    @Test(groups = TestGroup.API)
    public void verifyCanDeleteOrder() {
        Long orderId = 3L;
        createOrder(orderId);

        storesClient.deleteOrder(orderId)
                .assertStatusCode(HttpStatus.SC_OK);

        storesClient.getOrder(orderId)
                .assertStatusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test(groups = TestGroup.API)
    public void verifyCanGetStoreInventory() {
        storesClient.getStoreInventory()
                .assertStatusCode(HttpStatus.SC_OK);
    }

    private void createOrder(Long orderId) {
        Order order = new Order(orderId, 1L, 1, "2023-11-15T22:20:39.423+0000", OrderStatusEnum.PLACED, true);

        storesClient.createOrder(order)
                .assertStatusCode(HttpStatus.SC_OK)
                .assertContentType(ContentType.JSON)
                .assertResponseBody(order);
    }
}
