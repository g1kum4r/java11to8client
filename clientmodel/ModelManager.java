package clientmodel;

import mediator.ChatClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;

public class ModelManager implements Model, PropertyChangeListener {
    private ChatClient client;
    private PropertyChangeSupport property;

    public ModelManager() throws IOException {
        this.client = new ChatClient(this, "localhost", 1122);
        client.connect();
        client.addListener(this);
        property = new PropertyChangeSupport(this);
    }

    @Override
    public void send(String text) {
        client.send(text);
    }


    @Override
    public void getNumberOfPeople() {
        client.getNumberOfPeople();
    }

    @Override
    public void setUsername(String username) {
        client.setUsername(username);
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        property.firePropertyChange(evt);
    }
}
