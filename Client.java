import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static String getToken(Socket s, String user, String pass) {
        try {
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            String data = user + "." + pass;
            dout.writeUTF(data);
            System.out.println(data);
        } catch (Exception e) {

        }
        return "";
    }

    public static void main(String[] args) {

        Config c = new Config("server.config");
        try {
            Scanner scan = new Scanner(System.in);
            Socket s = new Socket(c.getIP(), Integer.parseInt(c.getPort()));
            System.out.println("Client Start");
            System.out.println("Authentication");
            System.out.print("USER: ");
            String user = scan.nextLine();
            System.out.print("PASS: ");
            String pass = scan.nextLine();
            getToken(s, user, pass);
            // DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            // String str = "";
            // while (!str.equals("Logout")) {
            // System.out.print("Enter msg: ");
            // str = scan.nextLine();
            // dout.writeUTF(str);
            // System.out.println(str.toUpperCase());
            // Thread.sleep(1000);
            // }

            // dout.flush();
            // dout.close();
            // s.close();
            scan.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}