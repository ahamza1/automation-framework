package org.testautomation.apps;

import org.apache.http.HttpStatus;
import org.testautomation.BaseAPITest;
import org.testng.annotations.Test;
import org.testautomation.apps.api.clients.PetstoreAPIClient;

public class ExampleAPITests extends BaseAPITest {

    @Test(groups = "api.test.example")
    public void verifyCanGetStoreInventory() {
        new PetstoreAPIClient()
                .getStoreInventory()
                .verifyStatusCode(HttpStatus.SC_OK);
    }

}
