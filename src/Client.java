import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //String host = "netology.ru";
        String host = "netology.homework";
        int port = 8099;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            //out.println("GET / HTTP/1.1\n" + "Host: netology.ru\n\n\n");
            out.println("Hello");
            System.out.println("Hello");
            String resp = in.readLine();
            System.out.println(resp);
            out.println("UserName");
            System.out.println("UserName");
            resp = in.readLine();
            System.out.println(resp);
            out.println("yes");
            System.out.println("yes");
            resp = in.readLine();
            System.out.println(resp);
        }
    }
}
