package view;

import javafx.fxml.FXML;

import javafx.scene.control.*;
import viewmodel.*;

public class LoginViewController extends ViewController {
    @FXML
    private TextField inputField;
    @FXML
    private Label errorLabel;
    private LoginViewModel loginViewModel;

    @Override
    protected void init() {
        this.loginViewModel = getViewModelFactory().getLoginViewModel();
        errorLabel.textProperty().bindBidirectional(loginViewModel.getErrorProperty());
        inputField.textProperty().bindBidirectional((loginViewModel.getUsernameProperty()));
    }

    @FXML
    private void onEnter() {
        loginViewModel.setUsername();
        getViewHandler().openView("ChatView.fxml");
    }

    @FXML
    private void continueButton() {
        onEnter();
    }


}
