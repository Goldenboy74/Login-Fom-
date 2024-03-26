package login_form1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Login_Form1 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Login Form"); // Ajouter un titre à la fenêtre
        stage.setResizable(false); // Empêcher l'agrandissement de la fenêtre

        // Charger l'icône depuis le dossier "res"
       Image icon = new Image(getClass().getResourceAsStream("/res/user.png"));
        stage.getIcons().add(icon);


        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
