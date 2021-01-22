package ethos;
import java.util.*;
import java.util.Properties;

public class ServerProperties {
    Properties configFile;
    public ServerProperties() {
        configFile = new java.util.Properties();
        String configFilePath = "./Data/cfg/server_properties.cfg";
        try {
            configFile.load(this.getClass().getClassLoader().
                    getResourceAsStream(configFilePath));
        } catch(Exception eta) {
            System.out.println("Unable to open "+configFilePath+" Not a required file");
        }
    }

    public String getProperty(String key) {
        String value = this.configFile.getProperty(key);
        return value;
    }
    public int getPropertyInt(String key) {
        int value = 0;
        try {
            value = Integer.parseInt(this.configFile.getProperty(key));
        } catch(Exception e) {
            value = 0;
        }
        return value;
    }
}
