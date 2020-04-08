import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private String ip = "";
    private String port = "";
    private String absPath = "";
    private String fileName = "";

    public Config(String fileName) {
        this.fileName = fileName;
        readConfig();
    }

    private void readConfig() {
        Properties prop = new Properties();
        InputStream is = null;
        try {
            is = new FileInputStream(this.fileName);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        try {
            prop.load(is);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        // * Test prop.getProperty() function
        // System.out.println(prop.getProperty("server.ip"));
        // System.out.println(prop.getProperty("server.port"));
        // System.out.println(prop.getProperty("server.absPath"));
        setIP(prop.getProperty("server.ip"));
        setPort(prop.getProperty("server.port"));
        setAbsPath(prop.getProperty("server.absPath"));
    }

    private void setIP(String ip) {
        this.ip = ip;
    }

    private void setPort(String port) {
        this.port = port;
    }

    private void setAbsPath(String absPath) {
        this.absPath = absPath;
    }

    public String getIP() {
        return this.ip;
    }

    public String getPort() {
        return this.port;
    }

    public String getAbsPath() {
        return this.absPath;
    }

    // * Main function : Testing
    public static void main(String[] args) {
        Config c = new Config("server.config");
        System.out.println(c.getAbsPath());
        System.out.println(c.getIP());
        System.out.println(c.getPort());

    }

}