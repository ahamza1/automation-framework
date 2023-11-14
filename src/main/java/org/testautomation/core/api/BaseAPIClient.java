package org.testautomation.core.api;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.google.gson.Gson;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.javacrumbs.jsonunit.JsonAssert;
import net.javacrumbs.jsonunit.core.Configuration;
import org.hamcrest.Matcher;

import java.io.File;

@Getter
@SuppressWarnings({"unchecked", "unused", "UnusedReturnValue"})
public class BaseAPIClient<T extends BaseAPIClient<T>> {

    @Setter(AccessLevel.PROTECTED)
    private Response response;

    public T verifyStatusCode(int expectedStatusCode) {
        response.then().assertThat().statusCode(expectedStatusCode);
        return (T) this;
    }

    public T verifyBodyMatchesJsonSchema(File expectedJsonSchema) {
        var jsonSchemaFactory = JsonSchemaFactory.newBuilder()
                .setValidationConfiguration(
                        ValidationConfiguration.newBuilder()
                                .setDefaultVersion(SchemaVersion.DRAFTV4)
                                .freeze()).freeze();
        response.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(expectedJsonSchema).using(jsonSchemaFactory));
        return (T) this;
    }

    public <R> T verifyResponseBody(R expectedValue) {
        JsonAssert.assertJsonEquals(toJsonString(expectedValue), response.getBody().asString());
        return (T) this;
    }

    public <R> T verifyResponseBody(R expectedValue, Configuration configuration) {
        JsonAssert.assertJsonEquals(toJsonString(expectedValue), response.getBody().asString(), configuration);
        return (T) this;
    }

    public <R> T verifyResponseBody(R expectedValue, String jsonPath) {
        JsonAssert.assertJsonPartEquals(toJsonString(expectedValue), response.getBody().asString(), jsonPath);
        return (T) this;
    }

    public <R> T verifyResponseBody(R expectedValue, String jsonPath, Configuration configuration) {
        JsonAssert.assertJsonPartEquals(toJsonString(expectedValue), response.getBody().asString(), jsonPath,
                configuration);
        return (T) this;
    }

    public T verifyResponseBody(String path, Matcher<?> matcher, Object... additionalKeyMatcherPairs) {
        response.then().body(path, matcher, additionalKeyMatcherPairs);
        return (T) this;
    }

    private <R> String toJsonString(R expectedBody) {
        if (expectedBody instanceof String) {
            return expectedBody.toString();
        }
        return new Gson().toJson(expectedBody);
    }
}
