package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Controller_View_Catalogo_Usuario implements Initializable {

    private Map<Pane, Image> paneImageMap;

    @FXML
    private GridPane contenedorCatalogo;
    //Pane's
    @FXML
    private Pane img1;
    @FXML
    private Pane img5;
    @FXML
    private Pane img2;
    @FXML
    private Pane img3;
    @FXML
    private Pane img4;
    @FXML
    private Pane img6;
    @FXML
    private Pane img7;
    @FXML
    private Pane img8;
    @FXML
    private Pane panelProducto;
    @FXML
    private Pane panelContenProdPagados;

    //BorderPane
    @FXML
    private BorderPane vtnVistaProducto;

    //HBox
    @FXML
    private HBox panelFoto;

    //VBox
    @FXML
    private VBox panelContenCarrito;

    //ScrollPane
    @FXML
    private ScrollPane scrollPane;

    //Combos
    @FXML
    private ComboBox<String> cmbTalla1;
    @FXML
    private ComboBox<String> cmbTalla5;
    @FXML
    private ComboBox<String> cmbTalla2;
    @FXML
    private ComboBox<String> cmbTalla3;
    @FXML
    private ComboBox<String> cmbTalla4;
    @FXML
    private ComboBox<String> cmbTalla6;
    @FXML
    private ComboBox<String> cmbTalla7;
    @FXML
    private ComboBox<String> cmbTalla8;
    @FXML
    private ComboBox<String> cmbTallaP;

    //Label's
    @FXML
    private Label lblMarca1;
    @FXML
    private Label lblGenero1;
    @FXML
    private Label lblTipo1;
    @FXML
    private Label lblPrecio1;
    @FXML
    private Label lblMarca5;
    @FXML
    private Label lblGenero5;
    @FXML
    private Label lblTipo5;
    @FXML
    private Label lblPrecio5;
    @FXML
    private Label lblMarca2;
    @FXML
    private Label lblGenero2;
    @FXML
    private Label lblTipo2;
    @FXML
    private Label lblPrecio2;
    @FXML
    private Label lblMarca3;
    @FXML
    private Label lblGenero3;
    @FXML
    private Label lblTipo3;
    @FXML
    private Label lblPrecio3;
    @FXML
    private Label lblMarca4;
    @FXML
    private Label lblGenero4;
    @FXML
    private Label lblTipo4;
    @FXML
    private Label lblPrecio4;
    @FXML
    private Label lblGenero6;
    @FXML
    private Label lblTipo6;
    @FXML
    private Label lblMarca7;
    @FXML
    private Label lblGenero7;
    @FXML
    private Label lblTipo7;
    @FXML
    private Label lblPrecio7;
    @FXML
    private Label lblMarca8;
    @FXML
    private Label lblGenero8;
    @FXML
    private Label lblTipo8;
    @FXML
    private Label lblPrecio8;
    @FXML
    private Label lblMarcaP;
    @FXML
    private Label lblTipoP;
    @FXML
    private Label lblPrecioP;
    @FXML
    private Label lblDescriptionP;
    @FXML
    private Label lblGeneroP;

    //Buttons
    @FXML
    private Button btnAggCrto1;
    @FXML
    private Button btnAggCrto4;
    @FXML
    private Button btnAggCrto2;
    @FXML
    private Button btnAggCrto3;
    @FXML
    private Button btnAggCrto5;
    @FXML
    private Button btnAggCrto7;
    @FXML
    private Button btnAggCrto8;
    @FXML
    private Button btnAggCarritoP;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnPagarProduct;
    @FXML
    private Button btnGen;
    @FXML
    private Pane Pmenu;
    @FXML
    private Button btnFem;
    @FXML
    private Button btnMas;
    @FXML
    private Label lblMarca01;
    @FXML
    private Label lblTipo01;
    @FXML
    private Label lblGenero01;
    @FXML
    private Label lblMarca02;
    @FXML
    private Label lblTipo02;
    @FXML
    private Label lblPrecio02;
    @FXML
    private Label lblGenero02;
    @FXML
    private Label lblMarca03;
    @FXML
    private Label lblTipo03;
    @FXML
    private Label lblPrecio03;
    @FXML
    private Label lblMarca05;
    @FXML
    private Label lblTipo05;
    @FXML
    private Label lblPrecio05;
    @FXML
    private Label lblGenero05;
    @FXML
    private Button btnAggCrto6;
    @FXML
    private Label lblMarca6;
    @FXML
    private Label lblPrecio6;
    @FXML
    private Label lblMarca06;
    @FXML
    private Label lblPrecio06;
    @FXML
    private Label lblGenero06;
    @FXML
    private Label lblMarca07;
    @FXML
    private Label lblTipo07;
    @FXML
    private Label lblPrecio07;
    @FXML
    private Label lblGenero07;
    @FXML
    private Label lblMarca08;
    @FXML
    private Label lblTipo08;
    @FXML
    private Label lblPrecio08;
    @FXML
    private Label lblGenero08;
    @FXML
    private Label lblTipo06;
    @FXML
    private Label lblGenero03;
    @FXML
    private Label lblGenero04;
    @FXML
    private Button btnPerfil;
    @FXML
    private Button btnEnviado;
    @FXML
    private Button btnCarro;
    @FXML
    private Pane PmenuP;
    @FXML
    private Button btnCerrarS;
    @FXML
    private Button btnCambC;
    @FXML
    private Label lblTipo04;
    @FXML
    private Label lblPrecio01;
    @FXML
    private Label lblMarca04;
    @FXML
    private Label lblPrecio04;
    @FXML
    public Label labelUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    private void mostrarImagenes() {
        for (Map.Entry<Pane, Image> entry : paneImageMap.entrySet()) {
            Pane pane = entry.getKey();
            Image image = entry.getValue();

            ImageView imageView = new ImageView(image);
            pane.getChildren().add(imageView);
        }
    }

    private void almacenarImagen() {
        paneImageMap = new HashMap<>();
//        paneImageMap.put(img1, new Image("/Images/Catalogo_Hombres/OufitMen1.png"));
//        paneImageMap.put(img2, new Image("/Images/Catalogo_Hombres/OufitMen2.png"));
//        paneImageMap.put(img3, new Image("/Images/Catalogo_Hombres/"));
//        paneImageMap.put(img4, new Image("/Images/Catalogo_Hombres/"));
//        paneImageMap.put(img5, new Image("/Images/Catalogo_Hombres/"));
//        paneImageMap.put(img6, new Image("/Images/Catalogo_Hombres/"));
//        paneImageMap.put(img7, new Image("/Images/Catalogo_Hombres/"));
//        paneImageMap.put(img8, new Image("/Images/Catalogo_Hombres/"));
    }

    @FXML
    private void mostrarProducto(MouseEvent event) {
        Pane eventPane = (Pane) event.getSource();
        String paneId = eventPane.getId();

        Image image = paneImageMap.get(eventPane);

        panelFoto.getChildren().clear();

        ImageView imageViewAmpliada = new ImageView(image);
        imageViewAmpliada.setFitWidth(200);
        imageViewAmpliada.setFitHeight(200);

        panelFoto.getChildren().add(imageViewAmpliada);
        panelProducto.setVisible(true);
    }

    public void tomarValor(Label marca, Label tipo, Label precio, Label genero, ComboBox talla) {
        if (talla == null) {

        } else {
            String strMarca = marca.getText().substring(marca.getText().indexOf(" "));
            String strTipo = tipo.getText().substring(tipo.getText().indexOf(" "));
            String strPrecio = precio.getText().substring(precio.getText().indexOf(" "));
            String strGenero = genero.getText().substring(genero.getText().indexOf(" "));
            String strTalla = talla.getValue().toString();

        }

    }

    @FXML
    private void aggCarrito(ActionEvent event) {
        Button eventBtn = (Button) event.getSource();
        Label lblTalla = new Label();
        Label lblPrecio = new Label();
        Label lblMarca = new Label();
        Label lblGenero = new Label();
        Label lblTipo = new Label();
        Button btnEliminar = new Button("Eliminar Carrito");
        GridPane contendElemtProductos = new GridPane();
        ColumnConstraints column = new ColumnConstraints();
        btnEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Botón clickeado");
                System.out.println(btnEliminar.getId());
                panelContenCarrito.getChildren().remove(contendElemtProductos);
            }
        });

        switch (eventBtn.getId()) {
            case "btnAggCrto1":
                lblTalla.setText(cmbTalla1.getValue());
                lblPrecio.setText(lblPrecio01.getText());
                lblMarca.setText(lblMarca01.getText());
                lblGenero.setText(lblGenero01.getText());
                lblTipo.setText(lblTipo01.getText());

                column.setPrefWidth(panelContenCarrito.getWidth() / 2);

                contendElemtProductos.getColumnConstraints().addAll(column);
                contendElemtProductos.prefWidth(panelContenCarrito.getMaxWidth());
                contendElemtProductos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

                contendElemtProductos.add(lblMarca, 0, 0);
                contendElemtProductos.add(lblTipo, 1, 0);
                contendElemtProductos.add(lblGenero, 0, 1);
                contendElemtProductos.add(lblTalla, 1, 1);
                contendElemtProductos.add(lblPrecio, 0, 2);
                contendElemtProductos.add(btnEliminar, 1, 2);

                //tomarValor(lblMarca01, lblTipo01, lblPrecio01, lblGenero01, cmbTalla1);
                panelContenCarrito.getChildren().add(contendElemtProductos);

                break;
            case "btnAggCrto2":
                lblTalla.setText(cmbTalla2.getValue());
                lblPrecio.setText(lblPrecio02.getText());
                lblMarca.setText(lblMarca02.getText());
                lblGenero.setText(lblGenero02.getText());
                lblTipo.setText(lblTipo02.getText());

                column.setPrefWidth(panelContenCarrito.getWidth() / 2);

                contendElemtProductos.getColumnConstraints().addAll(column);
                contendElemtProductos.prefWidth(panelContenCarrito.getMaxWidth());
                contendElemtProductos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

                contendElemtProductos.add(lblMarca, 0, 0);
                contendElemtProductos.add(lblTipo, 1, 0);
                contendElemtProductos.add(lblGenero, 0, 1);
                contendElemtProductos.add(lblTalla, 1, 1);
                contendElemtProductos.add(lblPrecio, 0, 2);
                contendElemtProductos.add(btnEliminar, 1, 2);

                //tomarValor(lblMarca02, lblTipo02, lblPrecio02, lblGenero02, cmbTalla2);
                panelContenCarrito.getChildren().add(contendElemtProductos);

                break;

            case "btnAggCrto3":
                lblTalla.setText(cmbTalla3.getValue());
                lblPrecio.setText(lblPrecio03.getText());
                lblMarca.setText(lblMarca03.getText());
                lblGenero.setText(lblGenero03.getText());
                lblTipo.setText(lblTipo03.getText());

                column.setPrefWidth(panelContenCarrito.getWidth() / 2);

                contendElemtProductos.getColumnConstraints().addAll(column);
                contendElemtProductos.prefWidth(panelContenCarrito.getMaxWidth());
                contendElemtProductos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

                contendElemtProductos.add(lblMarca, 0, 0);
                contendElemtProductos.add(lblTipo, 1, 0);
                contendElemtProductos.add(lblGenero, 0, 1);
                contendElemtProductos.add(lblTalla, 1, 1);
                contendElemtProductos.add(lblPrecio, 0, 2);
                contendElemtProductos.add(btnEliminar, 1, 2);

                //tomarValor(lblMarca03, lblTipo03, lblPrecio03, lblGenero03, cmbTalla3);
                panelContenCarrito.getChildren().add(contendElemtProductos);
                break;
            case "btnAggCrto4":
                lblTalla.setText(cmbTalla4.getValue());
                lblPrecio.setText(lblPrecio04.getText());
                lblMarca.setText(lblMarca04.getText());
                lblGenero.setText(lblGenero04.getText());
                lblTipo.setText(lblTipo04.getText());

                column.setPrefWidth(panelContenCarrito.getWidth() / 2);

                contendElemtProductos.getColumnConstraints().addAll(column);
                contendElemtProductos.prefWidth(panelContenCarrito.getMaxWidth());
                contendElemtProductos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

                contendElemtProductos.add(lblMarca, 0, 0);
                contendElemtProductos.add(lblTipo, 1, 0);
                contendElemtProductos.add(lblGenero, 0, 1);
                contendElemtProductos.add(lblTalla, 1, 1);
                contendElemtProductos.add(lblPrecio, 0, 2);
                contendElemtProductos.add(btnEliminar, 1, 2);

                //tomarValor(lblMarca04, lblTipo04, lblPrecio04, lblGenero04, cmbTalla4);
                panelContenCarrito.getChildren().add(contendElemtProductos);
                break;
            case "btnAggCrto5":
                lblTalla.setText(cmbTalla5.getValue());
                lblPrecio.setText(lblPrecio05.getText());
                lblMarca.setText(lblMarca05.getText());
                lblGenero.setText(lblGenero05.getText());
                lblTipo.setText(lblTipo05.getText());

                column.setPrefWidth(panelContenCarrito.getWidth() / 2);

                contendElemtProductos.getColumnConstraints().addAll(column);
                contendElemtProductos.prefWidth(panelContenCarrito.getMaxWidth());
                contendElemtProductos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

                contendElemtProductos.add(lblMarca, 0, 0);
                contendElemtProductos.add(lblTipo, 1, 0);
                contendElemtProductos.add(lblGenero, 0, 1);
                contendElemtProductos.add(lblTalla, 1, 1);
                contendElemtProductos.add(lblPrecio, 0, 2);
                contendElemtProductos.add(btnEliminar, 1, 2);

                //tomarValor(lblMarca05, lblTipo05, lblPrecio05, lblGenero05, cmbTalla5);
                panelContenCarrito.getChildren().add(contendElemtProductos);
                break;
            case "btnAggCrto6":
                lblTalla.setText(cmbTalla6.getValue());
                lblPrecio.setText(lblPrecio06.getText().substring(20));
                lblMarca.setText(lblMarca06.getText());
                lblGenero.setText(lblGenero06.getText());
                lblTipo.setText(lblTipo06.getText());

                column.setPrefWidth(panelContenCarrito.getWidth() / 2);

                contendElemtProductos.getColumnConstraints().addAll(column);
                contendElemtProductos.prefWidth(panelContenCarrito.getMaxWidth());
                contendElemtProductos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

                contendElemtProductos.add(lblMarca, 0, 0);
                contendElemtProductos.add(lblTipo, 1, 0);
                contendElemtProductos.add(lblGenero, 0, 1);
                contendElemtProductos.add(lblTalla, 1, 1);
                contendElemtProductos.add(lblPrecio, 0, 2);
                contendElemtProductos.add(btnEliminar, 1, 2);

                //tomarValor(lblMarca06, lblTipo06, lblPrecio06, lblGenero06, cmbTalla6);
                panelContenCarrito.getChildren().add(contendElemtProductos);
                break;
            case "btnAggCrto7":
                lblTalla.setText(cmbTalla7.getValue());
                lblPrecio.setText(lblPrecio07.getText());
                lblMarca.setText(lblMarca07.getText());
                lblGenero.setText(lblGenero07.getText());
                lblTipo.setText(lblTipo07.getText());

                column.setPrefWidth(panelContenCarrito.getWidth() / 2);

                contendElemtProductos.getColumnConstraints().addAll(column);
                contendElemtProductos.prefWidth(panelContenCarrito.getMaxWidth());
                contendElemtProductos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

                contendElemtProductos.add(lblMarca, 0, 0);
                contendElemtProductos.add(lblTipo, 1, 0);
                contendElemtProductos.add(lblGenero, 0, 1);
                contendElemtProductos.add(lblTalla, 1, 1);
                contendElemtProductos.add(lblPrecio, 0, 2);
                contendElemtProductos.add(btnEliminar, 1, 2);

                //tomarValor(lblMarca07, lblTipo07, lblPrecio07, lblGenero07, cmbTalla7);
                panelContenCarrito.getChildren().add(contendElemtProductos);
                break;
            case "btnAggCrto8":
                lblTalla.setText(cmbTalla8.getValue());
                lblPrecio.setText(lblPrecio08.getText());
                lblMarca.setText(lblMarca08.getText());
                lblGenero.setText(lblGenero08.getText());
                lblTipo.setText(lblTipo08.getText());

                column.setPrefWidth(panelContenCarrito.getWidth() / 2);

                contendElemtProductos.getColumnConstraints().addAll(column);
                contendElemtProductos.prefWidth(panelContenCarrito.getMaxWidth());
                contendElemtProductos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

                contendElemtProductos.add(lblMarca, 0, 0);
                contendElemtProductos.add(lblTipo, 1, 0);
                contendElemtProductos.add(lblGenero, 0, 1);
                contendElemtProductos.add(lblTalla, 1, 1);
                contendElemtProductos.add(lblPrecio, 0, 2);
                contendElemtProductos.add(btnEliminar, 1, 2);

                //tomarValor(lblMarca08, lblTipo08, lblPrecio08, lblGenero08, cmbTalla8);
                panelContenCarrito.getChildren().add(contendElemtProductos);
                break;

        }

    }

    @FXML
    private void cambiarCursor(MouseEvent event) {
    }

    @FXML
    private void volverCatalogo(ActionEvent event) {
        panelProducto.setVisible(false);
        ObservableList<Node> elementos = panelFoto.getChildren();
        for (Node elemento : elementos) {
            System.out.println(elemento);
        }
    }

    @FXML
    private void realizarPago(ActionEvent event) {
    }

    public void ponerTextoWoman(String marca, String tipo, String gender, String precio) {
        lblGenero01.setText(gender);
        lblGenero02.setText(gender);
        lblGenero03.setText(gender);
        lblGenero04.setText(gender);
        lblGenero05.setText(gender);
        lblGenero06.setText(gender);
        lblGenero07.setText(gender);
        lblGenero08.setText(gender);

        lblTipo01.setText(tipo);
        lblTipo02.setText(tipo);
        lblTipo03.setText(tipo);
        lblTipo04.setText(tipo);
        lblTipo05.setText(tipo);
        lblTipo06.setText(tipo);
        lblTipo07.setText(tipo);
        lblTipo08.setText(tipo);

    }

    @FXML
    private void cambiarCatalogo(ActionEvent event) {

        if (event.getSource() == btnFem) {
            paneImageMap.clear();
            paneImageMap = new HashMap<>();
//            paneImageMap.put(img1, new Image("/Images/Catalogo_Mujeres/OufitWoman1.png"));
            lblMarca01.setText("");
            lblGenero01.setText("");
            lblTipo01.setText("");
            lblPrecio01.setText("");
//            paneImageMap.put(img2, new Image("/Images/Catalogo_Mujeres/OufitWoman2.png"));
            lblMarca02.setText("");
            lblGenero02.setText("");
            lblTipo02.setText("");
            lblPrecio02.setText("");
//            paneImageMap.put(img3, new Image("/Images/shoesWoman3.jpg"));
            lblMarca01.setText("");
            lblGenero01.setText("");
            lblTipo01.setText("");
            lblPrecio01.setText("");
//            paneImageMap.put(img4, new Image("/Images/shoesWoman4.jpg"));
            lblMarca01.setText("");
            lblGenero01.setText("");
            lblTipo01.setText("");
            lblPrecio01.setText("");
//            paneImageMap.put(img5, new Image("/Images/shoesWoman5.jpg"));
            lblMarca01.setText("");
            lblGenero01.setText("");
            lblTipo01.setText("");
            lblPrecio01.setText("");
//            paneImageMap.put(img6, new Image("/Images/shoesWoman6.jpg"));
            lblMarca01.setText("");
            lblGenero01.setText("");
            lblTipo01.setText("");
            lblPrecio01.setText("");
//            paneImageMap.put(img7, new Image("/Images/shoesWoman7.jpg"));
            lblMarca01.setText("");
            lblGenero01.setText("");
            lblTipo01.setText("");
            lblPrecio01.setText("");
//            paneImageMap.put(img8, new Image("/Images/shoesWoman8.jpg"));
            lblMarca01.setText("");
            lblGenero01.setText("");
            lblTipo01.setText("");
            lblPrecio01.setText("");
            mostrarImagenes();
            ponerTextoWoman("", "", "", "");
        } else if (event.getSource() == btnMas) {
            paneImageMap.clear();
            paneImageMap = new HashMap<>();
//            paneImageMap.put(img1, new Image("/Images/Catalogo_Hombres/OufitMen1.png"));
//            paneImageMap.put(img2, new Image("/Images/Catalogo_Hombres/OufitMen2.png"));
//            paneImageMap.put(img3, new Image("/Images/shoesMen3.jpg"));
//            paneImageMap.put(img4, new Image("/Images/shoesMen4.jpg"));
//            paneImageMap.put(img5, new Image("/Images/shoesMen5.jpg"));
//            paneImageMap.put(img6, new Image("/Images/shoesMen6.jpg"));
//            paneImageMap.put(img7, new Image("/Images/shoesMen7.jpg"));
//            paneImageMap.put(img8, new Image("/Images/shoesMen8.jpg"));
            mostrarImagenes();
        }

    }

    @FXML
    private void actionEvent(ActionEvent event) throws IOException {
        if (event.getSource() == btnGen) {
            if (Pmenu.isVisible()) {

                Pmenu.setVisible(false);
            } else {

                Pmenu.setVisible(true);
                PmenuP.setVisible(false);
                panelContenProdPagados.setVisible(false);
                scrollPane.setVisible(false);
            }
        } else if (event.getSource() == btnPerfil) {
            if (PmenuP.isVisible()) {

                PmenuP.setVisible(false);
            } else {

                Pmenu.setVisible(false);
                PmenuP.setVisible(true);
                panelContenProdPagados.setVisible(false);
                scrollPane.setVisible(false);
            }
        } else if (event.getSource() == btnCarro) {
            scrollPane.setVisible(!scrollPane.isVisible());
            PmenuP.setVisible(false);
            Pmenu.setVisible(false);
            panelContenProdPagados.setVisible(false);
        } else if (event.getSource() == btnCerrarS) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
            alert.setContentText("Está apunto de cerrar la sesión\nEstá seguro de esto? :)");
            alert.setTitle("Confirmación");
            alert.showAndWait().ifPresent((ButtonType response) -> {
                if (response == ButtonType.YES) {
                    Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.FINISH);
                    alert2.setTitle("Información");
                    alert2.setHeaderText("Este es un mensaje informativo");
                    alert2.setContentText("¡Cerrando sesión..!");
                    alert2.showAndWait();
                    Stage miStage = (Stage) this.btnCerrarS.getScene().getWindow();
                    miStage.close();

                } else if (response == ButtonType.NO) {
                    JOptionPane.showMessageDialog(null, "Está bien..!");
                    alert.close();
                }
            });
        } else if (event.getSource() == btnEnviado) {
            panelContenProdPagados.setVisible(!panelContenProdPagados.isVisible());
            PmenuP.setVisible(false);
            Pmenu.setVisible(false);
            scrollPane.setVisible(false);

        }
    }

    @FXML
    private void pVisible(MouseEvent event) {
        PmenuP.setVisible(false);
        Pmenu.setVisible(false);
        scrollPane.setVisible(false);
        panelContenProdPagados.setVisible(false);
    }

}
