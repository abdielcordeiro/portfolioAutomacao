package br.com.abdiel.mobile.core.dataProvider;


import br.com.abdiel.mobile.core.actions.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;

    public ConfigFileReader() {
        BufferedReader reader;
        String propertyFilePath = "src/test/resources/configs/configuration.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.setLog("ERROR", "Configuration.properties não encontrado em: " + propertyFilePath);
        }
    }

    public String getInfo(String info) {
        return properties.getProperty(info);
    }
}