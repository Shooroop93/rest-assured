package ru.example;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.example.method.LoginMethod;
import ru.example.wiki.utilities.BaseMethod;

import static io.restassured.RestAssured.given;

public class LoginTest {
    String lgname = "Bottest1";
    String lgpassword = "qwerty12345_";
    String lgtoken = "76987939cdcbcc364513d14d6735992661a8dcf2+\\";
    Integer statusCode200 = 200;

    @Test
    public void checkTestCaseEleven() {
       Assert.assertEquals(LoginMethod.getStatusCode(lgname, lgpassword), statusCode200);
       Assert.assertEquals(LoginMethod.getLoginResult(lgname, lgpassword), BaseMethod.messageLoginResult());

    }

    @Test
    public void checkTestCaseTwelve() {
        Assert.assertEquals(LoginMethod.getStatusCode(lgname,lgpassword, lgtoken), statusCode200);
        System.out.println(LoginMethod.getLoginResult(lgname, lgpassword, lgtoken));
    }
}

