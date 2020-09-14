package core.file_reader;

import org.testng.Assert;
import org.testng.ITestContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private final String PROPERTY_PATH = "src/test/resources/";
    private Properties properties;

    public PropertiesReader(ITestContext context) {
        properties = getProperty(context);
    }

    public PropertiesReader(String property) {
        properties = getProperty(property);
    }

    private Properties getProperty(ITestContext context) {
        String propertyName = context.getSuite().getParameter("env");
        return getProperty(propertyName);
    }

    private Properties getProperty(String propertyName) {
        FileInputStream fileInputStream;
        Properties property = new Properties();
        try {
            fileInputStream = new FileInputStream(PROPERTY_PATH + propertyName + ".properties");
            property.load(fileInputStream);
            return property;
        } catch (IOException e) {
            Assert.fail("Failed. Property File Name :: " + propertyName + ".properties not found.");
        }
        return null;
    }

    public Properties getProperties() {
        return properties;
    }
}

