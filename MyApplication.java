import javafx.application.Application;
import javafx.stage.Stage;
import clientmodel.Model;
import clientmodel.ModelManager;
import view.ViewHandler;
import view.ViewCreator;
import viewmodel.ViewModelFactory;

import java.io.IOException;

public class MyApplication extends Application {
    public void start(Stage primaryStage) {
        Model model = null;
        try {
            model = new ModelManager();
            ViewModelFactory viewModelFactory = new ViewModelFactory(model);
            ViewHandler view = new ViewHandler(viewModelFactory);
            view.start(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
