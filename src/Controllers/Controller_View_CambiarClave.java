package Controllers;

import Models.EstructuraDeDatos.ListaDobleAdmin;
import Models.EstructuraDeDatos.ListaDobleCliente;
import Models.ModeloDeDatos;
import Models.Nodos.Nodo_Administrador;
import Models.Nodos.Nodo_Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller_View_CambiarClave implements Initializable {

    private ListaDobleCliente listaC = ModeloDeDatos.obtenerInstancia().getListaC();
    private ListaDobleAdmin listaA = ModeloDeDatos.obtenerInstancia().getListaA();

    //Text's
    @FXML
    private Text textCorreo;
    @FXML
    private Text textContra;
    @FXML
    private Text textIndice;
    @FXML
    private Text textContra1;
    @FXML
    private Text textContra2;

    //TextField and PasswordField's
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPass;
    @FXML
    private PasswordField txtPass2;
    @FXML
    private PasswordField txtPass3;

    //Button's
    @FXML
    private Button btnValidar;
    @FXML
    private Button btnAtras;
    @FXML
    private Button btnCambiar;

    //Pane's
    @FXML
    private Pane contendTXT;
    @FXML
    private Pane contendTXT2;

    public Text getTextIndice() {
        return textIndice;
    }

    public TextField getTxtUser() {
        return txtUser;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void eventAction(ActionEvent event) {

        if (event.getSource() == btnValidar && "ADMIN".equals(textIndice.getText())) {

            Nodo_Administrador admin = listaA.BuscarEmail(txtUser.getText());
            if (admin != null) {

                if ((admin.getPasswd()).equals(txtPass.getText())) {

                    listaA.Alert(Alert.AlertType.CONFIRMATION, "Correcto", "Proceda a ingresar la nueva clave..!");

                    txtPass.setText("");
                    contendTXT.setVisible(false);
                    contendTXT2.setVisible(true);
                    btnValidar.setVisible(false);
                    btnCambiar.setVisible(true);
                } else {

                    listaA.Alert(Alert.AlertType.WARNING, "Fatal", "Contraseña incorrecta");
                    txtPass.setText("");
                    txtPass.requestFocus();

                }
            } else {
                listaA.Alert(Alert.AlertType.CONFIRMATION, "Fatal", "Parece que el usuario no exite..!");
                txtUser.requestFocus();
                txtPass.setText("");
            }

        } else if (event.getSource() == btnValidar && "USER".equals(textIndice.getText())) {

            Nodo_Cliente client = listaC.BuscarEmail(txtUser.getText());
            if (client != null) {

                if ((client.getPasswd()).equals(txtPass.getText())) {

                    listaC.Alert(Alert.AlertType.CONFIRMATION, "Correcto", "Proceda a ingresar la nueva clave..!");

                    txtPass.setText("");
                    contendTXT.setVisible(false);
                    contendTXT2.setVisible(true);
                    btnValidar.setVisible(false);
                    btnCambiar.setVisible(true);
                } else {

                    listaC.Alert(Alert.AlertType.WARNING, "Fatal", "Contraseña incorrecta");
                    txtPass.setText("");
                    txtPass.requestFocus();

                }
            } else {
                listaC.Alert(Alert.AlertType.CONFIRMATION, "Fatal", "Parece que el usuario no exite..!");
                txtUser.requestFocus();
                txtPass.setText("");
            }

        } else if (event.getSource() == btnCambiar && "ADMIN".equals(textIndice.getText())) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Aviso");
            if (!txtPass2.getText().isEmpty()) {
                if (!txtPass3.getText().isEmpty()) {

                    if (txtPass2.getText().equals(txtPass3.getText())) {
                        Nodo_Administrador admin = listaA.BuscarEmail(txtUser.getText());
                        if (admin != null) {

                            String nuevaClave = txtPass2.getText();
                            admin.setPasswd(nuevaClave);
                            a.setAlertType(Alert.AlertType.INFORMATION);
                            a.setContentText("Cambio de contraseña exitoso..!");
                            a.showAndWait();
                            Stage stage = (Stage) this.btnCambiar.getScene().getWindow();
                            stage.close();
                            listaA.guardarDatosEnArchivoAdmin(listaA);

                        } else {
                            a.setContentText("No se encontró");
                            a.show();
                        }

                    } else {
                        a.setContentText("Verificación invalida"
                                + "La nueva contraseña no coincide");
                        a.show();
                        txtPass3.setText("");
                    }
                } else {
                    a.setContentText("El campo de verificación está vacio");
                    a.show();
                }
            } else {
                a.setContentText("Debe ingresar una nueva Contraseña");
                a.show();
            }

        } else if (event.getSource() == btnCambiar && "USER".equals(textIndice.getText())) {

            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Aviso");
            if (!txtPass2.getText().isEmpty()) {
                if (!txtPass3.getText().isEmpty()) {

                    if (txtPass2.getText().equals(txtPass3.getText())) {
                        Nodo_Cliente client = listaC.BuscarEmail(txtUser.getText());
                        if (client != null) {

                            String nuevaClave = txtPass2.getText();
                            client.setPasswd(nuevaClave);
                            a.setAlertType(Alert.AlertType.INFORMATION);
                            a.setContentText("Cambio de contraseña exitoso..!");
                            a.showAndWait();
                            Stage stage = (Stage) this.btnCambiar.getScene().getWindow();
                            stage.close();
                            listaC.guardarDatosEnArchivoClient(listaC);

                        } else {
                            a.setContentText("No se encontró");
                            a.show();
                        }

                    } else {
                        a.setContentText("Verificación invalida"
                                + "La nueva contraseña no coincide");
                        a.show();
                        txtPass3.setText("");
                    }
                } else {
                    a.setContentText("El campo de verificación está vacio");
                    a.show();
                }
            } else {
                a.setContentText("Debe ingresar una nueva Contraseña");
                a.show();
            }

        } else if (event.getSource() == btnAtras) {

            Stage stage = (Stage) this.btnAtras.getScene().getWindow();
            stage.close();

        }
    }

}
