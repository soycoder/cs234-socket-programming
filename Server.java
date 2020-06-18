import java.io.*;
import java.net.*;

public class Server {

    private ServerSocket ss = null;
    private static Socket s = null;
    private Config c = null;

    public Server() throws NumberFormatException, IOException {
        this.c = new Config("server.config");
        this.ss = new ServerSocket(Integer.parseInt(c.getPort()));
        this.s = ss.accept();
        System.out.println("Server Start");
    }

    public void checkAuth() {

    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            while (true) {
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = (String) dis.readUTF();
                System.out.println("message= " + str);
                try {
                    System.out.println("path : " + c.getAbsPath());
                    FileWriter writer = new FileWriter(c.getAbsPath(), true);
                    // FileWriter writer = new FileWriter("message.txt", true);
                    writer.write(str);
                    writer.write("\r\n");
                    writer.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}