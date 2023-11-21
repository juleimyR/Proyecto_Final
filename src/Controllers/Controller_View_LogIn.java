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
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class Controller_View_LogIn implements Initializable {

    //TextFields
    @FXML
    private TextField txtUser = new TextField();
    @FXML
    private PasswordField txtPass;
    //Buttons
    @FXML
    private Button btnIng;
    @FXML
    private Hyperlink btnRegH;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void eventAction(ActionEvent event) {
        if (event.getSource() == btnIng) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Catalogo_Usuario.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(scene);
                stage.show();

                Stage miStage = (Stage) this.btnIng.getScene().getWindow();
                miStage.close();
            } catch (IOException ex) {
                Logger.getLogger(Controller_View_LogIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == btnRegH) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Register.fxml"));
                Parent root = loader.load();

                Controller_View_Register controller = loader.getController();
                controller.lblTXT.setText("USER");
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UTILITY);
                stage.setScene(scene);
                stage.show();

                stage.setOnCloseRequest((WindowEvent value) -> {
                    controller.closeWindow2();
                });

                Stage miStage = (Stage) this.btnRegH.getScene().getWindow();
                miStage.close();
            } catch (IOException ex) {
                Logger.getLogger(Controller_View_LogIn_Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void closeWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Arranque.fxml"));

            Parent roott = loader.load();

            Scene scene = new Scene(roott);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);

            stage.setScene(scene);
            stage.show();

            Stage miStage = (Stage) this.btnIng.getScene().getWindow();
            miStage.close();
        } catch (IOException ex) {
            Logger.getLogger(Controller_View_LogIn_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
