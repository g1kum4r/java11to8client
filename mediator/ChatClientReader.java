package mediator;

import clientmodel.Message;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;

public class ChatClientReader implements Runnable {
    ChatClient client;
    private BufferedReader in;
    private Gson gson;

    public ChatClientReader(ChatClient client, BufferedReader in) {
        this.client = client;
        this.in = in;
        gson = new Gson();
    }

    public void close() throws IOException {
        client.disconnect();
    }

    public void run() {
        try {
            while (true) {
                Message fromJson = gson.fromJson(in.readLine(), Message.class);
                client.receive(fromJson);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
