package org.testautomation.app.api.clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testautomation.app.api.models.User;
import org.testautomation.core.api.BaseAPIClient;

import java.util.List;

public class UsersClient extends BaseAPIClient<UsersClient> {
    private final String ENDPOINT = "/user";

    public UsersClient createUserWithArray(User[] users) {
        setResponse(RestAssured.given()
                .contentType(ContentType.JSON)
                .body(users)
                .when()
                .post(ENDPOINT + "/createWithArray")
        );

        return this;
    }

    public UsersClient createUserWithList(List<User> users) {
        setResponse(RestAssured.given()
                .contentType(ContentType.JSON)
                .body(users)
                .when()
                .post(ENDPOINT + "/createWithList")
        );

        return this;
    }

    public UsersClient getByUsername(String username) {
        setResponse(RestAssured.get(ENDPOINT + "/" + username));
        return this;
    }

    public UsersClient updateUser(String username, User user) {
        setResponse(RestAssured.given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .put(ENDPOINT + "/" + username)
        );

        return this;
    }

    public UsersClient deleteUser(String username) {
        setResponse(RestAssured.delete(ENDPOINT + "/" + username));
        return this;
    }

    public UsersClient createUser(User user) {
        setResponse(RestAssured.given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(ENDPOINT)
        );

        return this;
    }
}
