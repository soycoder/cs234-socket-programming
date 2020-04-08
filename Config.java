import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private String ip = "";
    private String port = "";
    private String fileName = "";
    public Config(String fileName) {
        this.fileName = fileName;
    }
    private void readConfig(){
        Properties prop = new Properties();
        InputStream is = null;
        try {
            is = new FileInputStream(fileName);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        try {
            prop.load(is);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        System.out.println(prop.getProperty("server.ip"));
        System.out.println(prop.getProperty("server.port"));
    }

    private void set() {
        
    }
}