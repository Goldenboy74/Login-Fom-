/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package login_form1;

//import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import java.sql.Connection;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Golden74
 */
public class FXMLDocumentController implements Initializable {
	
    @FXML
    private Button bt_Login;

    @FXML
    private Button bt_Signup;

    @FXML
    private AnchorPane pane_Login;

    @FXML
    private AnchorPane pane_Signup;

    @FXML
    private TextField txt_email_up;

    @FXML
    private PasswordField txt_password;

    @FXML
    private TextField txt_password_up;

    @FXML
    private TextField txt_username;

    @FXML
    private TextField txt_username_up;

    @FXML
    private ComboBox type;

    @FXML
    private ComboBox type_Up;
    
    Connection cn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

	public void LoginpaneShow(){
		pane_Login.setVisible(true);
		pane_Signup.setVisible(false);
		
	}
	public void SignuppaneShow(){
		pane_Login.setVisible(false);
		pane_Signup.setVisible(true);
	}
	@FXML
        private void Login(ActionEvent event) throws Exception {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ? AND type = ?";

            try (Connection cn = mysqlconnect.ConnectDb()) {
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, txt_username.getText());
                pst.setString(2, txt_password.getText());
                pst.setString(3, type.getValue().toString());
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Nom d'utilisateur et Mot de Passe correct");
                    
                    bt_Login.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("CPanel.fxml"));
                    Stage mainStage = new Stage();
                    Scene scene = new Scene(root);
                    mainStage.setScene(scene);
                    mainStage.show();
                } else {
                    JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou Mot de Passe Incorrect");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erreur de connexion : " + e.getMessage());
            }
        }
        public void Signup(ActionEvent event){
            cn = mysqlconnect.ConnectDb();
            String sql = "insert into users (username,password,type,email) values (?,?,?,?)";
            try{
                pst = cn.prepareStatement(sql);
                pst.setString(1, txt_username_up.getText());
                pst.setString(2, txt_password_up.getText());
                pst.setString(3, type_Up.getValue().toString());
                pst.setString(4, txt_email_up.getText());
                pst.execute();
                txt_username_up.setText("");
                txt_password_up.setText("");
                type_Up.setValue("");
                txt_email_up.setText("");
                
                JOptionPane.showMessageDialog(null, "Enrégistré !");
            }catch (Exception e){
                 JOptionPane.showMessageDialog(null, "Erreur de connexion : " + e.getMessage());
            }
        }

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
               type_Up.getItems().addAll("Admin","client","caissier","magazinier");
               type.getItems().addAll("Admin","client","caissier","magazinier");
	}	
	
}
