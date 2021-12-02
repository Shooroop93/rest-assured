package ru.example.wiki.utilities;

import static ru.example.wiki.utilities.property.Property.getProperty;

public interface BaseMethod {

    static String baseUrlApiAntiSpoof() {
        return getProperty("baseUrlApiAntiSpoof");
    }

    static String messageStatusCode() {
        return getProperty("messageStatusCode");
    }

    static String messageUserName() {
        return getProperty("messageUserName");
    }

    static String messageResult() {
        return getProperty("messageResult");
    }

    static String messageNormalised() {
        return getProperty("messageNormalised");
    }
    static String messageError() {
        return getProperty("messageError");
    }

}
