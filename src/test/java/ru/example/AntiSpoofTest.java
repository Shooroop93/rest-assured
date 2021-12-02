package ru.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.example.method.antispoof.AntiSpoofMethod;

public class AntiSpoofTest {
    Integer statusCode200 = 200;

    @DataProvider(name = "test1")
    public static Object[][] testCase1() {
        return new Object[][] {{"Admin"}, {"admin"}, {"adm1n"}};
    }

    @Test(dataProvider = "test1")
    public void checkTestCaseOne(String name) {
        AntiSpoofMethod antiSpoofMethod = new AntiSpoofMethod();
        Assert.assertEquals(antiSpoofMethod.getStatusCode(name), statusCode200, "Status Code не совпадает");
        Assert.assertEquals(antiSpoofMethod.getUsernameGet(name), name, "Username не совпадает");
        Assert.assertEquals(antiSpoofMethod.getResultGet(name), "conflict", "result не совпадает");
        Assert.assertEquals(antiSpoofMethod.getNormalisedGet(name), "v2:ADMIN", "normalised не совпадает");
    }

}
