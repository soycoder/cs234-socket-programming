import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        try {
            System.out.println("Server Start");
            ServerSocket ss = new ServerSocket(1234);
            while (true) {
                Socket s = ss.accept();// establishes connection
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = (String) dis.readUTF();
                System.out.println("message= " + str);
                str = (String) dis.readUTF();
                ss.close();
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}