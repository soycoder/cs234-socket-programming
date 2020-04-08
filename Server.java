import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        Config c = new Config("server.config");
        try {
            System.out.println("Server Start");
            ServerSocket ss = new ServerSocket(Integer.parseInt(c.getPort()));
            while (true) {
                Socket s = ss.accept();// establishes connection
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = (String) dis.readUTF();
                System.out.println("message= " + str);
                try {
                    System.out.println("path : "   + c.getAbsPath());
                    FileWriter myWriter = new FileWriter(c.getAbsPath(),   true);
                    // FileWriter myWriter = new FileWriter("message.txt", true);
                    myWriter.write(str);
                    myWriter.write("\r\n");
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}