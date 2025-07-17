
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3080);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner sc = new Scanner(System.in);
            System.out.print("Input name :");
            String name = sc.nextLine();
            System.out.print("Input student ID :");
            String Sid = sc.nextLine();
            out.println(name);
            out.println(Sid);
            System.out.println("Sending to server");
            String callbackName = in.readLine();
            String callbackSid = in.readLine();
            String callbackServerName = in.readLine();
            System.out.println("Name :" + callbackName);
            System.out.println("Student ID :" + callbackSid);
            System.out.println("Server Name :" + callbackServerName);
            out.close();
            sc.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
