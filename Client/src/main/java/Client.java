import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket clientSocket;
    private static PrintWriter out;
    private static BufferedReader in;
    public void start() throws IOException {
        clientSocket = new Socket("127.0.0.1", 777);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.start();
        Scanner scanner = new Scanner(System.in);
        System.out.println("hello, stop");
        String choice = scanner.nextLine();
            out.println(choice);
            String responce = in.readLine();
        System.out.println(responce);
    }
}
