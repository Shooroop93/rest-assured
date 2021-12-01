package ru.example.wiki.utilities;

import static ru.example.wiki.utilities.property.Property.getProperty;

public interface BaseMethod {

    static String baseUrlApiAntiSpoof() {
        return getProperty("baseUrlApiAntiSpoof");
    }

}
