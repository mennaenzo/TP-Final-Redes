package ar.edu.utn.mdp;

import ar.edu.utn.mdp.protocol.SimpleProtocol;
import ar.edu.utn.mdp.server.Server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            int portNumber = Integer.parseInt(args[0]);

            Server server = new Server(portNumber);

            try {
                       server.start(new SimpleProtocol());
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        } else {
            System.out.println("A port must be supplied.");
        }
    }
}
