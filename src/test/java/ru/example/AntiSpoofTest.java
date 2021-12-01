package ru.example;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.example.method.antispoof.AntiSpoofMethod;
import ru.example.wiki.utilities.BaseMethod;

import static io.restassured.RestAssured.given;

public class AntiSpoofTest {

    @Test
    public void checkTestCaseOne() {
        AntiSpoofMethod antiSpoofMethod = new AntiSpoofMethod();
        
    }

}
