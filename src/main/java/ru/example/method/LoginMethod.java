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
    public static Integer getStatusCode(String lgname, String lgpassword, String lgtoken) {
        return given().
                when()
                .contentType(ContentType.JSON)
                .param("action", "login")
                .param("format", "json")
                .param("lgname", lgname)
                .param("lgpassword", lgpassword)
                .param("lgtoken", lgtoken)
                .post(BaseMethod.UrlApiLogin())
                .getStatusCode();
    }

    public static String getLoginResult(String lgname, String lgpassword) {
        return given().
                auth().
                basic(lgname, lgpassword)
                .when()
                .post("https://en.wikipedia.org/w/api.php?action=login&format=json")
                .then()
                .extract().body().jsonPath().getString("login.result");
    }
    public static String getLoginResult(String lgname, String lgpassword, String lgtoken) {
        return given()
                .param("lgname", lgname)
                .param("lgpassword", lgpassword)
                .param("lgtoken", lgtoken)
                .when()
                .post("https://en.wikipedia.org/w/api.php?action=login&format=json")
                .then().log().all()
                .extract().body().jsonPath().getString("login.result");
    }

}
