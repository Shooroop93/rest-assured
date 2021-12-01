package ru.example.wiki.utilities.property;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Property {

    public static String getProperty(String propertyName) {
        Properties prop = new Properties();
        String separator = File.separator;
        try {
            prop.load(new FileReader("src"+separator+"main"+separator+"resources"+separator+"application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (String) prop.get(propertyName);
    }

}
