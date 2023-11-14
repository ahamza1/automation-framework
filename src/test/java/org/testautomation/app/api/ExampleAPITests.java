package org.testautomation.app.api;

import org.apache.http.HttpStatus;
import org.testautomation.core.BaseAPITest;
import org.testautomation.core.constants.TestGroup;
import org.testng.annotations.Test;

public class ExampleAPITests extends BaseAPITest {

    @Test(groups = TestGroup.API)
    public void verifyCanGetStoreInventory() {
        new PetstoreAPIClient()
                .getStoreInventory()
                .verifyStatusCode(HttpStatus.SC_OK);
    }

}
