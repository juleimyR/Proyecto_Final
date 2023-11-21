package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class Controller_View_Arranque implements Initializable {

    @FXML
    private Button btnAdmin;
    @FXML
    private Button btnSign_In;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnSalir;
    @FXML
    private Button btnMin;

    public Button getBtnMin() {
        return btnMin;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void eventAction(ActionEvent e) throws IOException {

        if (e.getSource() == btnSalir) {

            System.exit(0);
        } else if (e.getSource() == btnMin) {

            minimizarVentana(e);
        } else if (e.getSource() == btnAdmin) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_LogIn_Admin.fxml"));
            Parent root = loader.load();

            Controller_View_LogIn_Admin controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UTILITY);
            stage.setScene(scene);
            stage.showAndWait();
            
            stage.setOnCloseRequest((WindowEvent event) -> {
                controller.closeWindow();
            });

        } else if (e.getSource() == btnLogin) {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_LogIn.fxml"));
            Parent root = loader.load();

            Controller_View_LogIn controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UTILITY);
            stage.setScene(scene);
            stage.showAndWait();
            
            stage.setOnCloseRequest((WindowEvent event) -> {
                controller.closeWindow();
            });
        }
    }

    private void minimizarVentana(ActionEvent event) {
        Stage currentStage = (Stage) btnMin.getScene().getWindow();
        currentStage.setIconified(true);
    }

}
