import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GreetClient {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        GreetClient client = new GreetClient();
        while (true) {
            client.startConnection("127.0.0.1", 777);
            Scanner scanner = new Scanner(
System.in
);
            System.out.println("0: hello server, 1: stop");
            int choice =  scanner.nextInt();
                System.out.println(choice);
                String response = "";
                switch (choice) {
                    case 0:
                        response = client.sendMessage("hello");
                        break;
                    case 1:
                        response = client.sendMessage("stop");
                        break;
                }
                System.out.println(response);
            }

        }
    } 