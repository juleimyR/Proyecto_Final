package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller_View_Register implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPass;
    @FXML
    private PasswordField txtPass1;
    @FXML
    private Button btnCre;
    @FXML
    private TextField txtCell;
    @FXML
    private TextField txtNom;
    @FXML
    public Label lblTXT;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void eventAction(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        if (event.getSource() == btnCre && "ADMIN".equals(lblTXT.getText())) {

            a.setContentText("Administardor registrado..!");
        } else if (event.getSource() == btnCre && "USER".equals(lblTXT.getText())) {
            
            a.setContentText("Usuario registrado..!");
        }
        a.show();

    }

    public void closeWindow1() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_LogIn_Admin.fxml"));

            Parent roott = loader.load();

            Scene scene = new Scene(roott);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

            Stage miStage = (Stage) this.btnCre.getScene().getWindow();
            miStage.close();
        } catch (IOException ex) {
            Logger.getLogger(Controller_View_Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeWindow2() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_LogIn.fxml"));

            Parent roott = loader.load();

            Scene scene = new Scene(roott);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

            Stage miStage = (Stage) this.btnCre.getScene().getWindow();
            miStage.close();
        } catch (IOException ex) {
            Logger.getLogger(Controller_View_Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
