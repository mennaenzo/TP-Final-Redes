package ar.edu.utn.mdp.protocol;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class SimpleProtocol implements Protocol {

    private Map<String, String> possibleInputs;

    public SimpleProtocol() {
        possibleInputs = new HashMap<>();
        possibleInputs.put("Hello", "Welcome client {clientNumber}");
        possibleInputs.put("Hi", "Welcome client {clientNumber}");
        possibleInputs.put("Time", "It's " + Time.valueOf(LocalTime.now()));
        possibleInputs.put("Day", "Today is " + Date.valueOf(LocalDate.now()).toLocalDate());
        possibleInputs.put("X", "Goodbye client {clientNumber}");
    }

    @Override
    public String processInput(String input, int clientNumber) {
        AtomicReference<String> output = new AtomicReference<>();

        if (input != null) {
            possibleInputs.forEach((possibleInput, response) -> {
                if (input.toUpperCase().contains(possibleInput.toUpperCase())) {
                    output.set(response.replace("{clientNumber}", Integer.toString(clientNumber)));
                }
            });
        } else {
            output.set("Connected to the server...");
        }

        if (output.get() == null) {
            output.set("Command not found.");
        }

        return output.get();
    }

}
