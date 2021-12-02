package ru.example.method;

import io.restassured.http.ContentType;
import ru.example.wiki.utilities.BaseMethod;

import static io.restassured.RestAssured.given;

public class LoginMethod {

    public static Integer getStatusCode(String lgname, String lgpassword) {
        return given().
                when()
                .contentType(ContentType.JSON)
                .param("action", "login")
                .param("format", "json")
                .param("lgname", lgname)
                .param("lgpassword", lgpassword)
                .post(BaseMethod.UrlApiLogin())
                .getStatusCode();
    }

    public static String getLoginResultNoToken(String lgname, String lgpassword) {
        return given().
                auth().
                basic(lgname, lgpassword)
                .when()
                .post("https://en.wikipedia.org/w/api.php?action=login&format=json")
                .then()
                .extract().body().jsonPath().getString("login.result");
    }

}
