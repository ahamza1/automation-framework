package org.testautomation.apps.api.clients;

import io.restassured.RestAssured;
import org.testautomation.core.api.BaseAPIClient;

public class PetstoreAPIClient extends BaseAPIClient<PetstoreAPIClient> {

    public PetstoreAPIClient getStoreInventory() {
        setResponse(RestAssured.get("/store/inventory"));
        return this;
    }
}
