import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientSide {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            Socket s = new Socket("localhost", 8080);
            System.out.println("Client Start");
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            String str = "";
            while (!str.equals("Logout")) {
                System.out.print("Enter msg: ");
                str = scan.nextLine();
                System.out.println("Send " + str + " to Server");
                dout.writeUTF(str);
                System.out.println(str.toUpperCase());
                Thread.sleep(1000);
            }

            dout.flush();
            dout.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}