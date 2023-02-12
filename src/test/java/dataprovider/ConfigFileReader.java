package dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private static Properties properties;
    private final String propertyFilePath= "configs//configuration.properties";

    private static ConfigFileReader configFileReaderObject;

    private ConfigFileReader(){
    }

    public static ConfigFileReader getInstance(){
        if(configFileReaderObject == null){
            System.out.println("Creating a new instance of ConfigFileReader.");
            configFileReaderObject = new ConfigFileReader();
        }
        return configFileReaderObject;
    }

    public void loadProperties(){
        BufferedReader reader;
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
            throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getChromeDriverPath(){
        String driverPath = properties.getProperty("chromeWebDriverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the configuration.properties file.");
    }

    public static String getEdgeDriverPath(){
        String driverPath = properties.getProperty("edgeWebDriverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the configuration.properties file.");
    }

    public String getCustomerRegisterPageUrl() {
        String url = properties.getProperty("customerRegisterPageUrl");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the configuration.properties file.");
    }

    public String getCustomerLoginPageUrl() {
        String url = properties.getProperty("customerLoginPageUrl");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the configuration.properties file.");
    }
}