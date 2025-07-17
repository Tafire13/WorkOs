
import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(3080);
            while (true) {
                Socket server = socket.accept();

                System.out.println("Connected to server......");
                BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
                PrintWriter out = new PrintWriter(server.getOutputStream());
                String name = in.readLine();
                String Sid = in.readLine();
                String ServerName = InetAddress.getLocalHost().getHostName();
                System.out.println("received " + name + " from client");
                System.out.println("received " + Sid + " from client");
                out.println(name);
                out.println(Sid);
                out.println(ServerName);
                System.out.println("Sending " + name + " to client");
                System.out.println("Sending " + Sid + " to client");
                System.out.println("Sending " + ServerName + " to client");
                out.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
