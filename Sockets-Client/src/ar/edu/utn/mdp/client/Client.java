package ar.edu.utn.mdp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private final String host;
    private final int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws IOException {
        try (
                Socket socket = new Socket(host, port);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String inputLine, outputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server: " + inputLine);
                outputLine = systemIn.readLine();

                if (outputLine != null) {
                    System.out.println("Client: " + outputLine);
                    out.println(outputLine);
                }

                if (outputLine != null && (outputLine.equals("x") || outputLine.equals("X"))) {
                    inputLine = in.readLine();
                    System.out.println("Server: " + inputLine);
                    break;
                }
            }
        }
    }
}
