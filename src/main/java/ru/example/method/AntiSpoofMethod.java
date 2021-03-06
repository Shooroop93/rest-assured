package ru.example.method;

import ru.example.wiki.utilities.BaseMethod;

import static io.restassured.RestAssured.given;

public class AntiSpoofMethod {

    public String getUsernameGet(String name) {
        return
                given()
                        .when()
                        .param("username", name)
                        .get(BaseMethod.UrlApiAntiSpoof())
                        .then()
                        .extract().body().jsonPath().getString("antispoof.username");
    }

    public String getNormalisedGet(String name) {
        return
                given()
                        .when()
                        .param("username", name)
                        .get(BaseMethod.UrlApiAntiSpoof())
                        .then()
                        .extract().body().jsonPath().getString("antispoof.normalised");
    }

    public String getResultGet(String name) {
        return
                given()
                        .when()
                        .param("username", name)
                        .get(BaseMethod.UrlApiAntiSpoof())
                        .then()
                        .extract().body().jsonPath().getString("antispoof.result");
    }

    public String getUsernamePost(String name) {
        return
                given()
                        .when()
                        .param("username", name)
                        .post(BaseMethod.UrlApiAntiSpoof())
                        .then()
                        .extract().body().jsonPath().getString("antispoof.username");
    }

    public String getNormalisedPost(String name) {
        return
                given()
                        .when()
                        .param("username", name)
                        .post(BaseMethod.UrlApiAntiSpoof())
                        .then()
                        .extract().body().jsonPath().getString("antispoof.normalised");
    }

    public String getResultPost(String name) {
        return
                given()
                        .when()
                        .param("username", name)
                        .post(BaseMethod.UrlApiAntiSpoof())
                        .then()
                        .extract().body().jsonPath().getString("antispoof.result");
    }

    public Integer getStatusCodePost(String name) {
        return
                given()
                        .when()
                        .param("username", name)
                        .post(BaseMethod.UrlApiAntiSpoof())
                        .getStatusCode();
    }

    public Integer getStatusCodeGet(String name) {
        return
                given()
                        .when()
                        .param("username", name)
                        .post(BaseMethod.UrlApiAntiSpoof())
                        .getStatusCode();
    }

    public String getErrorPost(String name) {
        return
                given()
                        .when()
                        .param("username", name)
                        .post(BaseMethod.UrlApiAntiSpoof())
                        .then()
                        .extract().body().jsonPath().getString("antispoof.error");
    }

    public String getErrorGet(String name) {
        return
                given()
                        .when()
                        .param("username", name)
                        .post(BaseMethod.UrlApiAntiSpoof())
                        .then()
                        .extract().body().jsonPath().getString("antispoof.error");
    }

}
