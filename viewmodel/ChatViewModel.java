package viewmodel;

import clientmodel.Model;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.scene.control.TextArea;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ChatViewModel implements PropertyChangeListener {
    private Model model;
    private StringProperty chatLines;
    private ArrayList<String> chatSupportLines;
    private StringProperty input;


    public ChatViewModel(Model model) {
        this.model = model;
        model.addListener(this);
        input = new SimpleStringProperty();
        chatLines = new SimpleStringProperty();
        chatSupportLines = new ArrayList<>();
    }

    public void send() {
        model.send(input.get());
        input.set("");
    }

    public void getNumberOfPeople() {
        model.getNumberOfPeople();
    }

    public StringProperty chatLinesProperty() {
        return chatLines;
    }

    public StringProperty inputProperty() {
        return input;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() ->
        {
            String message = evt.getOldValue().toString() + ": " + evt.getNewValue().toString();
            chatSupportLines.add(message);

            String allMessagesInOneString = "";
            for (int i = 0; i < chatSupportLines.size(); i++) {
                allMessagesInOneString += chatSupportLines.get(i) + "\n";
            }
            chatLines.set(allMessagesInOneString);
        });
    }
}
