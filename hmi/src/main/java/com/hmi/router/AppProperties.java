/*
 * The purpose of this class is to retrieve the base urls for the various APIs
 * from a properties file.
 */
package com.hmi.router;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {

    private static AppProperties instance;
    private String environmentInfrastructureBaseUrl;
    private String routesBaseUrl;
    private String weatherBaseUrl;
    private String geographyBaseUrl;
    
    public AppProperties() {
        try (InputStream input = new FileInputStream("src/main/resources/app.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            environmentInfrastructureBaseUrl = prop.getProperty("environmentInfrastructureBaseUrl");
            routesBaseUrl = prop.getProperty("routesBaseUrl");
            weatherBaseUrl = prop.getProperty("weatherBaseUrl");
            geographyBaseUrl = prop.getProperty("geographyBaseUrl");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public String getEnvironmentInfrastructureBaseUrl() {
        return environmentInfrastructureBaseUrl;
    }
    
    public String getRoutesBaseUrl() {
        return routesBaseUrl;
    }
    
    public String getWeatherBaseUrl() {
        return weatherBaseUrl;
    }

    public String getGeographyBaseUrl() {
        return geographyBaseUrl;
    }

    public static AppProperties getInstance() {
        if (instance == null) {
            instance = new AppProperties();
        }
        return instance;
    }
}