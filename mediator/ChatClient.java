package mediator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import clientmodel.*;
import com.google.gson.Gson;
import clientmodel.Message;
import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

public class ChatClient implements UnnamedPropertyChangeSubject {
    private String host;
    private int port;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private PropertyChangeSupport property;
    private String username;
    private Gson gson;

    public ChatClient(Model model, String host, int port) throws IOException {
        this.host = host;
        this.port = port;
        gson = new Gson();
        property = new PropertyChangeSupport(this);
    }

    public void connect() throws IOException {
        socket = new Socket(host,
                port); //lowercase hostport, because thats what is called in the constructor.
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(),
                true); //autoflush true, otherwise we might not see the result on the client side
        ChatClientReader receiver = new ChatClientReader(this, in);
        Thread receiverThread = new Thread(receiver);
        receiverThread.start();
    }

    public void receive(Message fromJson) {
        //We get the object from the server and we check if it is String - the number of people,
        //If it is Message object then we parse it. We fire the events and send it to the ModelManager.
        if (fromJson.isPrivateRequest()) {
            System.out.println(fromJson);
            property.firePropertyChange("Number", fromJson.getUsername(),
                    fromJson.getText());
        } else {
            System.out.println(fromJson);
            property.firePropertyChange("Message", fromJson.getUsername(),
                    fromJson.getText());
        }
    }

    public void getNumberOfPeople() {
        String numberOfPeople = gson.toJson(new Message("1", getUsername(), true));
        out.println(numberOfPeople);
    }

    public void send(String text) {
        Message message = new Message(text, getUsername());
        System.out.println(message.getText());
        String gsonMessage = gson.toJson(message, Message.class);
        out.println(gsonMessage);
    }

    public void disconnect() throws IOException {
        in.close();
        out.close();
        socket.close();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }
}
