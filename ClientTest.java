import clientmodel.Message;
import clientmodel.Model;
import clientmodel.ModelManager;
import mediator.ChatClient;

import java.io.IOException;

public class ClientTest {
    public static void main(String[] args) {
        try {
            Model model = new ModelManager();
            model.getNumberOfPeople();
            model.send("Hello fucker");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
