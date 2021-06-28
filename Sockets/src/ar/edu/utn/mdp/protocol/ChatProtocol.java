package ar.edu.utn.mdp.protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChatProtocol implements Protocol {
    @Override
    public String processInput(String input, int clientNumber) {
        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Client " + clientNumber + ": " + input);
        String response = "";

        try {
            response = systemIn.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return response;
    }
}
