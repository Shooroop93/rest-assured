package ru.example.method.antispoof;

import ru.example.wiki.utilities.BaseMethod;

import static io.restassured.RestAssured.given;

public class AntiSpoofMethod {

    public String getUsernameGet(String name) {
        return
                given()
                        .when()
                        .param("username", name)
                        .get(BaseMethod.baseUrlApiAntiSpoof())
                        .then()
                        .extract().body().jsonPath().getString("antispoof.username");
    }

    public String getNormalisedGet(String name) {
        return
                given()
                        .when()
                        .param("username", name)
                        .get(BaseMethod.baseUrlApiAntiSpoof())
                        .then()
                        .extract().body().jsonPath().getString("antispoof.normalised");
    }

    public String getResultGet(String name) {
        return
                given()
                        .when()
                        .param("username", name)
                        .get(BaseMethod.baseUrlApiAntiSpoof())
                        .then()
                        .extract().body().jsonPath().getString("antispoof.result");
    }

    public String getUsernamePost(String name) {
        return
                given()
                        .when()
                        .param("username", name)
                        .post(BaseMethod.baseUrlApiAntiSpoof())
                        .then()
                        .extract().body().jsonPath().getString("antispoof.username");
    }

    public String getNormalisedPost(String name) {
        return
                given()
                        .when()
                        .param("username", name)
                        .post(BaseMethod.baseUrlApiAntiSpoof())
                        .then()
                        .extract().body().jsonPath().getString("antispoof.normalised");
    }

    public String getResultPost(String name) {
        return
                given()
                        .when()
                        .param("username", name)
                        .post(BaseMethod.baseUrlApiAntiSpoof())
                        .then()
                        .extract().body().jsonPath().getString("antispoof.result");
    }

}
