package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataProperties {

    public static String dataReader(String key) throws IOException {
     String filepath =System.getProperty("user.dir") +"/src/test/resources/data.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(filepath);
            Properties prop = new Properties();
            prop.load(fileInputStream);
            return prop.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }


}
