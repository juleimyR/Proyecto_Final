package Controllers;

import Models.EstructuraDeDatos.ListaDobleAdmin;
import Models.EstructuraDeDatos.ListaDobleCliente;
import Models.EstructuraDeDatos.PilaStack_Producto;
import Models.ModeloDeDatos;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class Controller_View_Arranque extends Application implements Initializable {

    private ListaDobleAdmin listaA = ModeloDeDatos.obtenerInstancia().getListaA();
    private ListaDobleCliente listaC = ModeloDeDatos.obtenerInstancia().getListaC();
    private PilaStack_Producto pilaP = ModeloDeDatos.obtenerInstancia().getPilaP();

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
    @FXML
    private Button Link1;
    @FXML
    private Button Link2;
    @FXML
    private Button Link3;
    @FXML
    private ImageView imaLink1;
    @FXML
    private ImageView imaLink2;
    @FXML
    private ImageView imaLink3;
    @FXML
    private Button Link4;
    @FXML
    private ImageView imaLink4;

    public Button getBtnMin() {
        return btnMin;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image imageNormal = new Image(getClass().getResourceAsStream("/Images/Icons/git1.png"));
        Image imageHover = new Image(getClass().getResourceAsStream("/Images/Icons/git2.png"));

        Link1.setOnMouseEntered(event -> imaLink1.setImage(imageHover));
        Link1.setOnMouseExited(event -> imaLink1.setImage(imageNormal));

        Image imageNormal2 = new Image(getClass().getResourceAsStream("/Images/Icons/insta1.png"));
        Image imageHover2 = new Image(getClass().getResourceAsStream("/Images/Icons/insta2.png"));

        Link2.setOnMouseEntered(event -> imaLink2.setImage(imageHover2));
        Link2.setOnMouseExited(event -> imaLink2.setImage(imageNormal2));

        Image imageNormal3 = new Image(getClass().getResourceAsStream("/Images/Icons/whats1.png"));
        Image imageHover3 = new Image(getClass().getResourceAsStream("/Images/Icons/whats2.png"));

        Link3.setOnMouseEntered(event -> imaLink3.setImage(imageHover3));
        Link3.setOnMouseExited(event -> imaLink3.setImage(imageNormal3));

        Image imageNormal4 = new Image(getClass().getResourceAsStream("/Images/Icons/face1.png"));
        Image imageHover4 = new Image(getClass().getResourceAsStream("/Images/Icons/face2.png"));

        Link4.setOnMouseEntered(event -> imaLink4.setImage(imageHover4));
        Link4.setOnMouseExited(event -> imaLink4.setImage(imageNormal4));

        listaA.cargarDatosDesdeArchivoAdmin();
        listaC.cargarDatosDesdeArchivoClient();
        pilaP.cargarProductos_MaDesdeArchivo();
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

            stage.initStyle(StageStyle.UNIFIED);
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest((WindowEvent event) -> {
                controller.closeWindow();
            });

            Stage miStage = (Stage) btnSign_In.getScene().getWindow();
            miStage.close();

        } else if (e.getSource() == btnLogin) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_LogIn.fxml"));
            Parent root = loader.load();

            Controller_View_LogIn controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initStyle(StageStyle.UNIFIED);
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest((WindowEvent event) -> {
                controller.closeWindow();
            });

            Stage miStage = (Stage) btnSign_In.getScene().getWindow();
            miStage.close();

        } else if (e.getSource() == btnSign_In) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Register.fxml"));
                Parent root = loader.load();

                Controller_View_Register controller = loader.getController();
                controller.lblTXT.setText("USER");

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.initStyle(StageStyle.UNIFIED);
                stage.setScene(scene);
                stage.show();

                stage.setOnCloseRequest((WindowEvent value) -> {
                    controller.closeWindow3();
                });

                Stage miStage = (Stage) btnSign_In.getScene().getWindow();
                miStage.close();
            } catch (IOException ex) {
                Logger.getLogger(Controller_View_LogIn_Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void minimizarVentana(ActionEvent event) {
        Stage currentStage = (Stage) btnMin.getScene().getWindow();
        currentStage.setIconified(true);
    }

    @FXML
    private void irLink(ActionEvent event) {
        if (event.getSource() == Link1) {

            String url = "https://github.com/juleimyR/Proyecto_Final";
            getHostServices().showDocument(url);

        } else if (event.getSource() == Link2) {
            String url = "";
        } else if (event.getSource() == Link3) {
            String url = "";
        } else if (event.getSource() == Link4) {
            String url = "";
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

}
