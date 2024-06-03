package Controllers;

import Models.EstructuraDeDatos.ListaDobleAdmin;
import Models.ModeloDeDatos;
import Models.Nodos.Nodo_Administrador;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class Controller_View_LogIn_Admin implements Initializable {

    private ListaDobleAdmin listaA = ModeloDeDatos.obtenerInstancia().getListaA();

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPass;
    @FXML
    public Button btnIng;
    @FXML
    private Hyperlink btnRegH;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void iniciarSesion(ActionEvent event) {

        if (txtUser.getText().isEmpty() && txtPass.getText().isEmpty()) {

            listaA.Alert(Alert.AlertType.WARNING, "Aviso", "No se puede verificar\n"
                    + "Los campos están vacios");

        } else if (txtUser.getText().isEmpty()) {

            listaA.Alert(Alert.AlertType.WARNING, "Aviso", "No se puede verificar\n"
                    + "Debe ingresar un correo");

        } else if (txtPass.getText().isEmpty()) {

            listaA.Alert(Alert.AlertType.WARNING, "Aviso", "No se puede verificar\n"
                    + "Debe ingresar una contraseña");

        } else if (!txtUser.getText().isEmpty() && !txtPass.getText().isEmpty()) {

            Nodo_Administrador buscar = listaA.BuscarEmail(txtUser.getText());

            if (buscar != null) {

                if ((buscar.getPasswd()).equals(txtPass.getText())) {

                    listaA.Alert(Alert.AlertType.CONFIRMATION, "Bienvenido", "SIMON'S le da la Bienvenida..!");
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Catalogo_Principal.fxml"));
                        Parent root = loader.load();

                        Controller_View_Catalogo_Principal controller = loader.getController();
                        controller.labelUser.setText(txtUser.getText());

                        Scene scene = new Scene(root);
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
                    txtUser.setText("");
                    txtPass.setText("");

                } else {

                    listaA.Alert(Alert.AlertType.WARNING, "Aviso", "Contraseña incorrecta");
                    txtPass.setText("");
                    txtPass.requestFocus();

                }
            } else {
                listaA.Alert(Alert.AlertType.WARNING, "Aviso", "Correo no registrado o erroneo, por favor verifique");
                txtUser.setText("");
                txtPass.setText("");
                txtUser.requestFocus();
            }
        }
    }

    @FXML
    private void eventAction(ActionEvent event) {
        if (event.getSource() == btnIng) {
            iniciarSesion(event);
        } else if (event.getSource() == btnRegH) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Register.fxml"));
                Parent root = loader.load();

                Controller_View_Register controller = loader.getController();
                controller.lblTXT.setText("ADMIN");

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.initStyle(StageStyle.UNIFIED);
                stage.setScene(scene);
                stage.show();

                stage.setOnCloseRequest((WindowEvent value) -> {
                    controller.closeWindow1();
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
