package mediator.chat;

import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private String username;
    private List users;
    private ListView<String> messages;
    private MessageCenter messageCenter;

    public Controller(String username, String[] users, MessageCenter messageCenter) {
        this.username = username;
        this.users = new ArrayList<>();
        for (String user : users) {
            if (username.equals(user)) {
                continue;
            }
            this.users.add(user);
        }
        this.messageCenter = messageCenter;
    }

    public void setMessages(ListView<String> messages) {
        this.messages = messages;
    }

    public String getUsername() {
        return username;
    }

    public List getUsers() {
        return users;
    }

    public void sendMessage(String message, String recipient) {
        // Logic to send a message to the recipient
        System.out.println("Sending message: " + message + " to " + recipient);
        this.messages.getItems().add(username + " to " + recipient + ": " + message);
        this.messageCenter.sendMessage(message, username, recipient);
    }

    public void receiveMessage(String message, String sender) {
        // Logic to receive a message from the sender
        System.out.println("Received message: " + message + " from " + sender);
        this.messages.getItems().add(sender + " to " + username + ": " + message);
    }
}
