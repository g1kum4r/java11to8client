package viewmodel;

import clientmodel.Model;

//import javax.swing.text.View;

public class ViewModelFactory {
    private ChatViewModel chatViewModel;
    private LoginViewModel loginViewModel;

    public ViewModelFactory(Model model) {
        this.chatViewModel = new ChatViewModel(model);
        this.loginViewModel = new LoginViewModel(model);
    }

    public ChatViewModel getChatViewModel() {
        return chatViewModel;
    }

    public LoginViewModel getLoginViewModel() {
        return loginViewModel;
    }
}
