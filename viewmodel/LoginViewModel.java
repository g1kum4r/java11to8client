package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import clientmodel.*;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginViewModel {
    private StringProperty error;
    private StringProperty username;
    private Model model;

    public LoginViewModel(Model model) {
        this.model = model; //todo RESOLVE
        error = new SimpleStringProperty();
        username = new SimpleStringProperty();
    }

    public void clear() {
        error.set("");
        username.set("");
    }

    public StringProperty getErrorProperty() {
        return error;
    }

    public StringProperty getUsernameProperty() {
        return username;
    }

    public void setUsername() {
        model.setUsername(username.get());
    }
}
