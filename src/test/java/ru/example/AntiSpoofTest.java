package ru.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.example.method.AntiSpoofMethod;
import ru.example.wiki.utilities.BaseMethod;

public class AntiSpoofTest {
    Integer statusCode200 = 200;
    AntiSpoofMethod antiSpoofMethod = new AntiSpoofMethod();

    @DataProvider(name = "testData1")
    public static Object[][] testData1() {
        return new Object[][]{{"Admin"}, {"admin"}, {"adm1n"}};
    }

    @DataProvider(name = "testData2")
    public static Object[][] testData2() {
        return new Object[][]{{"Admin1"}, {"admin1"}, {"adMin1"}, {"admin1#"}};
    }

    @DataProvider(name = "testData3")
    public static Object[][] testData3() {
        return new Object[][]{{"1"}, {" "}, {"2231@"}, {"#"}};
    }

    @DataProvider(name = "testData4")
    public static Object[][] testData4() {
        return new Object[][]{{"Админ"}, {"админ"}, {"адмиН"}};
    }

    @DataProvider(name = "testData5")
    public static Object[][] testData5() {
        return new Object[][]{{"Админ1"}, {"админ1@"}, {"адмиН"}};
    }


    @Test(dataProvider = "testData1")
    public void checkTestCaseOne(String name) {
        Assert.assertEquals(antiSpoofMethod.getStatusCodeGet(name), statusCode200, BaseMethod.messageStatusCode());
        Assert.assertTrue(antiSpoofMethod.getUsernameGet(name).equals(name), BaseMethod.messageUserName());
        Assert.assertTrue(antiSpoofMethod.getResultGet(name).equals("conflict"), BaseMethod.messageResult());
        Assert.assertTrue(antiSpoofMethod.getNormalisedGet(name).equals("v2:ADMIN"), BaseMethod.messageNormalised());
    }

    @Test(dataProvider = "testData2")
    public void checkTestCaseTwo(String name) {
        Assert.assertEquals(antiSpoofMethod.getStatusCodeGet(name), statusCode200, BaseMethod.messageStatusCode());
        Assert.assertTrue(antiSpoofMethod.getUsernameGet(name).equals(name), BaseMethod.messageUserName());
        Assert.assertTrue(antiSpoofMethod.getResultGet(name).equals("pass"), BaseMethod.messageResult());
        Assert.assertTrue(antiSpoofMethod.getNormalisedGet(name).equals("v2:ADMINI"), BaseMethod.messageNormalised());
    }

    @Test(dataProvider = "testData3")
    public void checkTestCaseThree(String name) {
        Assert.assertEquals(antiSpoofMethod.getStatusCodeGet(name), statusCode200, BaseMethod.messageStatusCode());
        Assert.assertTrue(antiSpoofMethod.getUsernameGet(name).equals(name), BaseMethod.messageUserName());
        Assert.assertTrue(antiSpoofMethod.getResultGet(name).equals("error"), BaseMethod.messageResult());
        Assert.assertTrue(antiSpoofMethod.getErrorGet(name).equals("Does not contain any letters"), BaseMethod.messageError());
    }

    @Test(dataProvider = "testData1")
    public void checkTestCaseFour(String name) {
        Assert.assertEquals(antiSpoofMethod.getStatusCodePost(name), statusCode200, BaseMethod.messageStatusCode());
        Assert.assertTrue(antiSpoofMethod.getUsernamePost(name).equals(name), BaseMethod.messageUserName());
        Assert.assertTrue(antiSpoofMethod.getResultPost(name).equals("conflict"), BaseMethod.messageResult());
        Assert.assertTrue(antiSpoofMethod.getNormalisedPost(name).equals("v2:ADMIN"), BaseMethod.messageNormalised());
    }

    @Test(dataProvider = "testData2")
    public void checkTestCaseFive(String name) {
        Assert.assertEquals(antiSpoofMethod.getStatusCodePost(name), statusCode200, BaseMethod.messageStatusCode());
        Assert.assertTrue(antiSpoofMethod.getUsernamePost(name).equals(name), BaseMethod.messageUserName());
        Assert.assertTrue(antiSpoofMethod.getResultPost(name).equals("pass"), BaseMethod.messageResult());
        Assert.assertTrue(antiSpoofMethod.getNormalisedPost(name).equals("v2:ADMINI"), BaseMethod.messageNormalised());
    }

    @Test(dataProvider = "testData3")
    public void checkTestCaseSix(String name) {
        Assert.assertEquals(antiSpoofMethod.getStatusCodeGet(name), statusCode200, BaseMethod.messageStatusCode());
        Assert.assertTrue(antiSpoofMethod.getUsernameGet(name).equals(name), BaseMethod.messageUserName());
        Assert.assertTrue(antiSpoofMethod.getResultGet(name).equals("error"), BaseMethod.messageResult());
        Assert.assertTrue(antiSpoofMethod.getErrorGet(name).equals("Does not contain any letters"), BaseMethod.messageError());
    }

    @Test
    public void checkTestCaseSeven() {
        Assert.assertEquals(antiSpoofMethod.getStatusCodeGet(""), statusCode200, BaseMethod.messageStatusCode());
        Assert.assertTrue(antiSpoofMethod.getUsernameGet("").equals(""), BaseMethod.messageUserName());
        Assert.assertTrue(antiSpoofMethod.getResultGet("").equals("error"), BaseMethod.messageResult());
        Assert.assertTrue(antiSpoofMethod.getErrorGet("").equals("Empty string"), BaseMethod.messageError());

        Assert.assertEquals(antiSpoofMethod.getStatusCodePost(""), statusCode200, BaseMethod.messageStatusCode());
        Assert.assertTrue(antiSpoofMethod.getUsernamePost("").equals(""), BaseMethod.messageUserName());
        Assert.assertTrue(antiSpoofMethod.getResultPost("").equals("error"), BaseMethod.messageResult());
        Assert.assertTrue(antiSpoofMethod.getErrorPost("").equals("Empty string"), BaseMethod.messageError());
    }

    @Test(dataProvider = "testData4")
    public void checkTestCaseEight(String name) {
        Assert.assertEquals(antiSpoofMethod.getStatusCodeGet(name), statusCode200, BaseMethod.messageStatusCode());
        Assert.assertTrue(antiSpoofMethod.getUsernameGet(name).equals(name), BaseMethod.messageUserName());
        Assert.assertTrue(antiSpoofMethod.getResultGet(name).equals("pass"), BaseMethod.messageResult());
        Assert.assertTrue(antiSpoofMethod.getNormalisedGet(name).equals("v2:AдMИH"), BaseMethod.messageError());
    }

    @Test(dataProvider = "testData4")
    public void checkTestCaseNine(String name) {
        Assert.assertEquals(antiSpoofMethod.getStatusCodePost(name), statusCode200, BaseMethod.messageStatusCode());
        Assert.assertTrue(antiSpoofMethod.getUsernamePost(name).equals(name), BaseMethod.messageUserName() + name);
        Assert.assertTrue(antiSpoofMethod.getResultPost(name).equals("error"), BaseMethod.messageResult());
        Assert.assertTrue(antiSpoofMethod.getNormalisedPost(name).equals("v2:AдMИH"), BaseMethod.messageError());
    }

    @Test(dataProvider = "testData5")
    public void checkTestCaseTen(String name) {
        Assert.assertEquals(antiSpoofMethod.getStatusCodeGet(name), statusCode200, BaseMethod.messageStatusCode());
        Assert.assertTrue(antiSpoofMethod.getUsernameGet(name).equals(name), BaseMethod.messageUserName());
        Assert.assertTrue(antiSpoofMethod.getResultGet(name).equals("pass"), BaseMethod.messageResult());
        Assert.assertTrue(antiSpoofMethod.getNormalisedGet(name).equals("v2:AдMИHI"), BaseMethod.messageError());
    }

    @Test(dataProvider = "testData5")
    public void check(String name) {
        Assert.assertEquals(antiSpoofMethod.getStatusCodePost(name), statusCode200, BaseMethod.messageStatusCode());
        Assert.assertTrue(antiSpoofMethod.getUsernamePost(name).equals(name), BaseMethod.messageUserName());
        Assert.assertTrue(antiSpoofMethod.getResultPost(name).equals("conflict"), BaseMethod.messageResult());
        Assert.assertTrue(antiSpoofMethod.getNormalisedPost(name).equals("v2:AдMИHI"), BaseMethod.messageNormalised());
    }

}
