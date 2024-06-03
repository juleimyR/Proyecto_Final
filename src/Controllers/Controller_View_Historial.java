package Controllers;

import Models.EstructuraDeDatos.PilaStack_Producto;
import Models.ModeloDeDatos;
import Models.Nodos.Nodo_Producto;
import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class Controller_View_Historial implements Initializable {

    private PilaStack_Producto pilaPH = ModeloDeDatos.obtenerInstancia().getPilaP();

    @FXML
    private Button btnEliminH;
    @FXML
    private Button btnExpH;
    @FXML
    private Button btnCerrar;
    @FXML
    private TableView<Nodo_Producto> tableHistory;
    @FXML
    private TableColumn<Nodo_Producto, Integer> col1;
    @FXML
    private TableColumn<Nodo_Producto, String> col2;
    @FXML
    private TableColumn<Nodo_Producto, String> col3;
    @FXML
    private TableColumn<Nodo_Producto, Float> col4;
    @FXML
    private TableColumn<Nodo_Producto, String> col5;
    @FXML
    private TableColumn<Nodo_Producto, LocalDateTime> col6;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        col1.setStyle("-fx-alignment: CENTER");
        col2.setCellValueFactory(new PropertyValueFactory<>("marca"));
        col2.setStyle("-fx-alignment: CENTER");
        col3.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        col3.setStyle("-fx-alignment: CENTER");
        col4.setCellValueFactory(new PropertyValueFactory<>("precio"));
        col4.setCellFactory(tc -> new FormattedTableCell<>("%.2f"));
        col4.setStyle("-fx-alignment: CENTER");
        col5.setCellValueFactory(new PropertyValueFactory<>("comprador"));
        col5.setStyle("-fx-alignment: CENTER");
        col6.setCellValueFactory(new PropertyValueFactory<>("fechaCompra"));
        col6.setStyle("-fx-alignment: CENTER");
        actualizarTabla();
    }

    @SuppressWarnings("PublicInnerClass")
    public class FormattedTableCell<S, T> extends javafx.scene.control.TableCell<S, T> {

        private final String format;

        public FormattedTableCell(String format) {
            this.format = format;
        }

        @Override
        protected void updateItem(T item, boolean empty) {
            super.updateItem(item, empty);

            if (item == null || empty) {
                setText(null);
            } else {
                setText(String.format(format, item));
            }
        }
    }

    @FXML
    private void eventAction(ActionEvent e) {
        if (e.getSource() == btnEliminH) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
            alert.setContentText("Está apunto de eliminar todo el historial de compras\n"
                    + "Los datos eliminados tambien se eliminarán de la base de datos\n"
                    + "Está seguro de esto? -_-");
            alert.setTitle("Confirmación");
            alert.showAndWait().ifPresent((ButtonType response) -> {
                if (response == ButtonType.YES) {

                    if (!pilaPH.getPilaPH().isEmpty()) {

                        while (!pilaPH.getPilaPH().isEmpty()) {
                            pilaPH.getPilaPH().pop();
                        }
                        pilaPH.guardarDatosEnArchivoCompras(pilaPH.getPilaPH());
                        actualizarTabla();
                    } else {

                        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.OK);
                        alert2.setTitle("Información");
                        alert2.setContentText("¡No hay elementos por eliminar!");
                        alert2.show();
                        alert.close();
                    }
                } else if (response == ButtonType.NO) {
                    Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.FINISH);
                    alert2.setTitle("Información");
                    alert2.setContentText("¡No se eliminaron los datos...!");
                    alert2.show();
                    alert.close();
                }
            });

        } else if (e.getSource() == btnExpH) {

            ExportarH();

        } else if (e.getSource() == btnCerrar) {

            pilaPH.guardarDatosEnArchivoCompras(pilaPH.getPilaPH());
            actualizarTabla();
            Stage miStage = (Stage) this.btnCerrar.getScene().getWindow();
            miStage.close();
        }
    }

    public void ExportarH() {
        Stage stage = new Stage();
        stage.setTitle("Exportar Historial");

        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("src"));

        Button button = new Button("Select Directory");
        button.setOnAction((ActionEvent ex) -> {
            try {
                File selectedDirectory = directoryChooser.showDialog(stage);
                pilaPH.ExportarHistorialComprasPDF(selectedDirectory.getAbsolutePath() + "\\", pilaPH.getPilaPH());
                stage.close();
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Archivo Guardado Exitosamente");
                a.showAndWait();
            } catch (Exception e) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("No se Pudo Guardar el archivo");
                a.showAndWait();
                System.out.println("No se Pudo Guardar el archivo: " + e.getMessage());
            }

        });

        HBox vs = new HBox(new Label("Selecciona Direccion de Carpeta: "), button);
        vs.setAlignment(Pos.CENTER);
        vs.setPadding(new Insets(10));
        vs.setSpacing(10);

        Scene scene = new Scene(vs);

        stage.setScene(scene);
        stage.show();
    }

    @SuppressWarnings("unchecked")
    public void actualizarTabla() {
        tableHistory.getItems().clear();

        if (!pilaPH.getPilaPH().isEmpty()) {
            ObservableList<Nodo_Producto> data = FXCollections.observableArrayList();
            Stack<Nodo_Producto> pilaAux = new Stack<>();

            pilaAux.addAll(pilaPH.getPilaPH());

            data.addAll(pilaAux);

            tableHistory.setItems(data);
        }
    }
}
