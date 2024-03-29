package com.ita.edu.speakua.api.clients;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseClient {
    public final String baseUrl;
    public final ContentType contentType;

    public BaseClient() {
        this.baseUrl = "https://speak-ukrainian.org.ua/dev";
        this.contentType = ContentType.JSON;
    }

    public BaseClient(String url, ContentType contentType) {
        this.baseUrl = url;
        this.contentType = contentType;
    }

    public RequestSpecification prepareRequest() {
        return given()
                .baseUri(baseUrl)
                .contentType(contentType)
                .accept(contentType);
    }
}
