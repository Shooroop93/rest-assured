package ru.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.example.method.antispoof.AntiSpoofMethod;
import ru.example.wiki.utilities.BaseMethod;

public class AntiSpoofTest {
    Integer statusCode200 = 200;
    AntiSpoofMethod antiSpoofMethod = new AntiSpoofMethod();

    @DataProvider(name = "test1")
    public static Object[][] testCase1() {
        return new Object[][] {{"Admin"}, {"admin"}, {"adm1n"}};
    }

    @Test(dataProvider = "test1")
    public void checkTestCaseOne(String name) {
        Assert.assertEquals(antiSpoofMethod.getStatusCode(name), statusCode200, BaseMethod.messageStatusCode());
        Assert.assertEquals(antiSpoofMethod.getUsernameGet(name), name, BaseMethod.messageUserName());
        Assert.assertEquals(antiSpoofMethod.getResultGet(name), "conflict", BaseMethod.messageResult());
        Assert.assertEquals(antiSpoofMethod.getNormalisedGet(name), "v2:ADMIN", BaseMethod.messageNormalised());
    }

    
    @Test
    public void checkTestCaseTwo(String name){
        Assert.assertEquals(antiSpoofMethod.getStatusCode(name), statusCode200, BaseMethod.messageStatusCode());
        Assert.assertEquals(antiSpoofMethod.getUsernameGet(name), name, BaseMethod.messageUserName());
        Assert.assertEquals(antiSpoofMethod.getResultGet(name), "pass", BaseMethod.messageResult());
        Assert.assertEquals(antiSpoofMethod.getNormalisedGet(name), "v2:ADMINI", BaseMethod.messageNormalised());
    }

}
