package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.*;

import java.awt.*;

public class ChatViewController extends ViewController {

    private ChatViewModel chatViewModel;
    @FXML
    private TextArea textArea;
    @FXML
    private TextField input;

    @Override
    protected void init() {
        //All the buttons labels stuff :))
        this.chatViewModel = getViewModelFactory().getChatViewModel();
        textArea.textProperty()
                .bind(chatViewModel.chatLinesProperty());
        input.textProperty().bindBidirectional(chatViewModel.inputProperty());
    }

    @FXML
    private void onClick() {
        chatViewModel.getNumberOfPeople();
    }

    @FXML
    private void onEnter() {
        chatViewModel.send();
    }


}
