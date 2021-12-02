package ru.example.wiki.utilities;

import static ru.example.wiki.utilities.property.Property.getProperty;

public interface BaseMethod {

    static String UrlApiAntiSpoof() {
        return getProperty("UrlApiAntiSpoof");
    }

    static String UrlApiLogin() {
        return getProperty("UrlApiLogin");
    };

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

    static String messageLoginResult() {
        return getProperty("messageLoginResult");
    }

}
