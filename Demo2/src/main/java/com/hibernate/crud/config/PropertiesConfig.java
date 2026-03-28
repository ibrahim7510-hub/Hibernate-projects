package com.hibernate.crud.config;

import com.hibernate.crud.exception.InternalServiceException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class PropertiesConfig {

    private static final Properties PROPERTIES=new Properties();
    private static final PropertiesConfig instance=new PropertiesConfig();

    private PropertiesConfig()
    {
        List<String> filesToLoad=List.of("hibernate.properties","message.properties");

        filesToLoad.forEach(files->{
            InputStream input=getClass().getClassLoader().getResourceAsStream(files);
            try {
                if(input!=null){
                    try {
                        PROPERTIES.load(input);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }catch (InternalServiceException e){
                throw new InternalServiceException("Failed to load");
            }
        });
    }
    public static PropertiesConfig getInstance(){
        return instance;
    }
    public static String getProperties(String key){
        return PROPERTIES.getProperty(key);
    }
}
