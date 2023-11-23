package Controllers;

import Models.EstructuraDeDatos.ListaDobleAdmin;
import Models.EstructuraDeDatos.ListaDobleCliente;
import Models.ModeloDeDatos;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class Controller_View_Register implements Initializable {

    private ListaDobleAdmin listaA = ModeloDeDatos.obtenerInstancia().getListaA();
    private ListaDobleCliente listaC = ModeloDeDatos.obtenerInstancia().getListaC();

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
    @FXML
    private TextField txtGen;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void eventAction(ActionEvent event) {

        if (event.getSource() == btnCre && "ADMIN".equals(lblTXT.getText())) {

            AgregarAdmins(txtNom, txtUser, txtCell, txtGen, txtPass);
            closeWindow1();

        } else if (event.getSource() == btnCre && "USER".equals(lblTXT.getText())) {
            
            AgregarClients(txtNom, txtUser, txtCell, txtGen, txtPass);
            closeWindow2();
        }

    }

    public void AgregarAdmins(TextField txtNombre, TextField txtEmail, TextField txtCell, TextField txtGen, PasswordField txtPassword) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setHeaderText("Mensaje de informacion");
        a.setTitle("Dialogo de advertencia");

        if (!"".equals(txtNombre.getText())) {

            if (!"".equals(txtEmail.getText())) {

                if (!"".equals(txtCell.getText())) {

                    if (!"".equals(txtGen.getText())) {

                        if (!"".equals(txtPassword.getText())) {

                            if (txtPassword.getText().equals(txtPass1.getText())) {

                                listaA.addAdminInicio(txtNombre, txtEmail, txtCell, txtGen, txtPassword);
                                listaA.guardarDatosEnArchivoAdmin(listaA);
                                txtNombre.setText("");
                                txtEmail.setText("");
                                txtCell.setText("");
                                txtGen.setText("");
                                txtPassword.setText("");
                            } else {
                                a.setContentText("Verifique su contraseña");
                                a.showAndWait();
                            }

                        } else {

                            a.setContentText("Esnecesario que se escriba una contraseña");
                            a.showAndWait();
                        }
                    } else {

                        a.setContentText("Esnecesario que se escriba un Genero");
                        a.showAndWait();
                    }
                } else {

                    a.setContentText("Esnecesario que se escriba un"
                            + "\nnumero de numero de telefono");
                    a.showAndWait();
                }

            } else {

                a.setContentText("Esnecesario que se escriba un Correo / Usuario");
                a.showAndWait();
            }
        } else {

            a.setContentText("Es necesario que se escriba un nombre");
            a.showAndWait();
        }
    }

    public void AgregarClients(TextField txtNombre, TextField txtEmail, TextField txtCell, TextField txtGen, PasswordField txtPassword) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setHeaderText("Mensaje de informacion");
        a.setTitle("Dialogo de advertencia");

        if (!"".equals(txtNombre.getText())) {

            if (!"".equals(txtEmail.getText())) {

                if (!"".equals(txtCell.getText())) {

                    if (!"".equals(txtGen.getText())) {

                        if (!"".equals(txtPassword.getText())) {

                            if (txtPassword.getText().equals(txtPass1.getText())) {

                                listaC.addClientInicio(txtNombre, txtEmail, txtCell, txtGen, txtPassword);
                                listaC.guardarDatosEnArchivoClient(listaC);
                                txtNombre.setText("");
                                txtEmail.setText("");
                                txtCell.setText("");
                                txtGen.setText("");
                                txtPassword.setText("");
                            } else {
                                a.setContentText("Verifique su contraseña");
                                a.showAndWait();
                            }

                        } else {

                            a.setContentText("Esnecesario que se escriba una contraseña");
                            a.showAndWait();
                        }
                    } else {

                        a.setContentText("Esnecesario que se escriba un Genero");
                        a.showAndWait();
                    }
                } else {

                    a.setContentText("Esnecesario que se escriba un"
                            + "\nnumero de numero de telefono");
                    a.showAndWait();
                }

            } else {

                a.setContentText("Esnecesario que se escriba un Correo / Usuario");
                a.showAndWait();
            }
        } else {

            a.setContentText("Es necesario que se escriba un nombre");
            a.showAndWait();
        }
    }

    public void closeWindow1() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_LogIn_Admin.fxml"));

            Parent roott = loader.load();

            Controller_View_LogIn_Admin controller = loader.getController();

            Scene scene = new Scene(roott);
            Stage stage = new Stage();

            stage.initStyle(StageStyle.UNIFIED);
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest((WindowEvent value) -> {
                controller.closeWindow();
            });

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

            Controller_View_LogIn controller = loader.getController();

            Scene scene = new Scene(roott);
            Stage stage = new Stage();

            stage.initStyle(StageStyle.UNIFIED);
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest((WindowEvent value) -> {
                controller.closeWindow();
            });

            Stage miStage = (Stage) this.btnCre.getScene().getWindow();
            miStage.close();
        } catch (IOException ex) {
            Logger.getLogger(Controller_View_Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeWindow3() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Arranque.fxml"));

            Parent roott = loader.load();

            Scene scene = new Scene(roott);
            Stage stage = new Stage();

            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();

            Stage miStage = (Stage) this.btnCre.getScene().getWindow();
            miStage.close();
        } catch (IOException ex) {
            Logger.getLogger(Controller_View_Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
