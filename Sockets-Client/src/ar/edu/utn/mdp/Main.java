package ar.edu.utn.mdp;

import ar.edu.utn.mdp.client.Client;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length > 1) {
            String hostName = args[0];
            int portNumber;

            try {
                portNumber = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("The port number is invalid.");
                return;
            }

            Client client = new Client(hostName, portNumber);

            try {
                client.start();
            } catch (IOException exception) {
                System.out.println("There was an error in the connection, you must specify a correct hostname followed by a port number.\n" + exception.getMessage());
            }
        } else {
            System.out.println("A host name and a port must be supplied.");
        }
    }
}
