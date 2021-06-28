package ar.edu.utn.mdp.server;

import ar.edu.utn.mdp.protocol.Protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final int port;
    private int clientNumber = 0;

    public Server(int port) {
        this.port = port;
    }

    public void start(Protocol protocol) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started at port " + port + ".");

        while (true) {
            Socket clientSocket = serverSocket.accept();

            Thread clientThread = new Thread(() -> {
                try {
                    handleClient(clientSocket, protocol, clientNumber);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });

            clientNumber++;
            clientThread.start();
        }
    }

    private void handleClient(Socket clientSocket, Protocol protocol, int clientNumber) throws IOException {
        try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine, outputLine;

            outputLine = protocol.processInput(null, clientNumber);
            System.out.println("Server: " + outputLine);
            out.println(outputLine);


            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client " + clientNumber + ": " + inputLine);
                outputLine = protocol.processInput(inputLine, clientNumber);
                System.out.println("Server: " + outputLine);
                out.println(outputLine);

                if (inputLine.equals("x") || inputLine.equals("X") || outputLine.equals("x") || outputLine.equals("X")) {
                    clientSocket.close();
                    break;
                }
            }
        }
    }
}
