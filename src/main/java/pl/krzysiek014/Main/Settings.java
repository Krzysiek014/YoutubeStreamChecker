package pl.krzysiek014.Main;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Krzysiek014 on 24.02.2018.
 */
public class Settings {
    private final static Settings instance = new Settings();
    private Properties properties = new Properties();
    public static Settings getInstance() {
        return instance;
    }

    public void loadProperties() throws IOException {
        FileInputStream inputStream = new FileInputStream("global.properties");
        properties.load(inputStream);
    }

    public void saveProperties() throws IOException {
        FileOutputStream inputStream = new FileOutputStream("global.properties");
        properties.store(inputStream,null);
    }

    public void setProperty(String key, String val){
        properties.setProperty(key,val);
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }
}
