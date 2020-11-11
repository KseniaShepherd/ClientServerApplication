import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8079);
        Socket clientSocket = serverSocket.accept();
        System.out.println("New connection accepted");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        final String name = in.readLine();

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

    }
}
