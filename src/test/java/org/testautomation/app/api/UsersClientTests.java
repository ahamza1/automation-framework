package org.testautomation.app.api;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testautomation.app.api.clients.UsersClient;
import org.testautomation.app.api.models.User;
import org.testautomation.core.BaseAPITest;
import org.testautomation.core.constants.TestGroup;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsersClientTests extends BaseAPITest {
    private UsersClient usersClient;

    @BeforeMethod(groups = TestGroup.API)
    public void testSetup() {
        usersClient = new UsersClient();
    }

    @Test(groups = TestGroup.API)
    public void verifyCanCreateUser() {
        User user = new User(1L, "testuser", "John", "doe", "jdoe@test.com", "password", "123456", 1);

        usersClient.createUser(user)
                .assertStatusCode(HttpStatus.SC_OK);
    }

    @Test(groups = TestGroup.API)
    public void verifyCanGetUser() {
        Long userId = 2L;
        createUser(userId);

        usersClient.getByUsername("testuser")
                .assertStatusCode(HttpStatus.SC_OK)
                .assertContentType(ContentType.JSON);
    }

    private void createUser(Long userId) {
        User user = new User(userId, "testuser", "John", "doe", "jdoe@test.com", "password", "123456", 1);

        usersClient.createUser(user)
                .assertStatusCode(HttpStatus.SC_OK);
    }
}
