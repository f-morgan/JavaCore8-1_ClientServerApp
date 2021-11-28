import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8099;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("New connection accepted");
        in.readLine();
        out.println("Write your name");
        final String name = in.readLine();
        out.println("Are you child? (yes/no)");
        final String resp = in.readLine();
        if (resp.equals("yes")) {
            out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
        } else if (resp.equals("no")) {
            out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
        } else {
            out.println("Try again later");
        }
        //out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
    }
}
