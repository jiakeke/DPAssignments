package mediator.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageCenter {
    private Map<String, Controller> users;

    public MessageCenter() {
        users = new HashMap<>();
    }

    public void register(Controller controller) {
        // Logic to register the controller with the message center
        users.put(controller.getUsername(), controller);
    }

    public void sendMessage(String message, String sender, String recipient) {
        // Logic to send a message to the recipient
        System.out.println("Sending message: " + message + " to " + recipient);
        Controller recipientController = users.get(recipient);
        System.out.println(users);
        if (recipientController != null) {
            recipientController.receiveMessage(message, sender);
        } else {
            System.out.println("User " + recipient + " not found.");
        }

    }
}
