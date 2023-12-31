package Controllers;

import Models.EstructuraDeDatos.PilaStack_Producto;
import Models.ModeloDeDatos;
import Models.Nodos.Nodo_Producto;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller_View_Catalogo_Usuario implements Initializable {

    private PilaStack_Producto pilaP = ModeloDeDatos.obtenerInstancia().getPilaP();
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
    @FXML
    private Pane scrollPane01;
    @FXML
    private TextField txtTotal;
    @FXML
    private VBox contenPagados;
    @FXML
    private HBox panelFoto1;
    @FXML
    private Button btnVolver1;
    @FXML
    private HBox panelFoto2;
    @FXML
    private HBox panelFoto3;
    @FXML
    private HBox panelFoto4;
    @FXML
    private HBox panelFoto5;
    @FXML
    private HBox panelFoto6;
    @FXML
    private HBox panelFoto7;
    @FXML
    private Label gMarca;
    @FXML
    private Label gTipo;
    @FXML
    private Label gGenero;
    @FXML
    private Label gPrecio;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String[] valuesCmb = {"XS", "S", "M", "L", "XL"};
        cmbTalla1.setItems(FXCollections.observableArrayList(valuesCmb));
        cmbTalla2.setItems(FXCollections.observableArrayList(valuesCmb));
        cmbTalla3.setItems(FXCollections.observableArrayList(valuesCmb));
        cmbTalla4.setItems(FXCollections.observableArrayList(valuesCmb));
        cmbTalla5.setItems(FXCollections.observableArrayList(valuesCmb));
        cmbTalla6.setItems(FXCollections.observableArrayList(valuesCmb));
        cmbTalla7.setItems(FXCollections.observableArrayList(valuesCmb));
        cmbTalla8.setItems(FXCollections.observableArrayList(valuesCmb));
        cmbTallaP.setItems(FXCollections.observableArrayList(valuesCmb));

        almacenarImagen();
        mostrarImagenes();
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
        paneImageMap.put(img1, new Image("/Images/Catalogo_Hombres/OufitMen1.png"));
        paneImageMap.put(img2, new Image("/Images/Catalogo_Hombres/OufitMen2.png"));
        paneImageMap.put(img3, new Image("/Images/Catalogo_Hombres/OufitMen3.png"));
        paneImageMap.put(img4, new Image("/Images/Catalogo_Hombres/OufitMen4.png"));
        paneImageMap.put(img5, new Image("/Images/Catalogo_Hombres/OufitMen5.png"));
        paneImageMap.put(img6, new Image("/Images/Catalogo_Hombres/OufitMen6.png"));
        paneImageMap.put(img7, new Image("/Images/Catalogo_Hombres/OufitMen7.png"));
        paneImageMap.put(img8, new Image("/Images/Catalogo_Hombres/OufitMen8.png"));
        paneImageMap.put(panelFoto, new Image("/Images/Catalogo_Hombres/OufitMen1.png"));
        paneImageMap.put(panelFoto1, new Image("/Images/Catalogo_Hombres/OufitMen2.png"));
        paneImageMap.put(panelFoto2, new Image("/Images/Catalogo_Hombres/OufitMen3.png"));
        paneImageMap.put(panelFoto3, new Image("/Images/Catalogo_Hombres/OufitMen4.png"));
        paneImageMap.put(panelFoto4, new Image("/Images/Catalogo_Hombres/OufitMen5.png"));
        paneImageMap.put(panelFoto5, new Image("/Images/Catalogo_Hombres/OufitMen6.png"));
        paneImageMap.put(panelFoto6, new Image("/Images/Catalogo_Hombres/OufitMen7.png"));
        paneImageMap.put(panelFoto7, new Image("/Images/Catalogo_Hombres/OufitMen8.png"));
    }

    private void esconderPaneF(Pane p1, Pane p2, Pane p3, Pane p4, Pane p5, Pane p6, Pane p7) {
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
        p6.setVisible(false);
        p7.setVisible(false);
    }

    @FXML
    private void mostrarProducto(MouseEvent event) {
        Pane eventPane = (Pane) event.getSource();
        Image image = paneImageMap.get(eventPane);

        panelFoto.getChildren().clear();
        panelFoto1.getChildren().clear();
        panelFoto2.getChildren().clear();
        panelFoto3.getChildren().clear();
        panelFoto4.getChildren().clear();
        panelFoto5.getChildren().clear();
        panelFoto6.getChildren().clear();
        panelFoto7.getChildren().clear();

        ImageView imageViewAmpliada = new ImageView(image);
        imageViewAmpliada.setFitWidth(300);
        imageViewAmpliada.setFitHeight(300);

        switch (eventPane.getParent().getId()) {
            case "padre1":

                gMarca.setText(lblMarca01.getText());
                gTipo.setText(lblTipo01.getText());
                gGenero.setText(lblGenero01.getText());
                gPrecio.setText(lblPrecio01.getText());
                cmbTallaP.setValue(cmbTalla1.getValue());
                esconderPaneF(panelFoto1, panelFoto2, panelFoto3, panelFoto4, panelFoto5, panelFoto6, panelFoto7);
                panelFoto.getChildren().add(imageViewAmpliada);
                panelFoto.setVisible(true);
                break;
            case "padre2":

                gMarca.setText(lblMarca02.getText());
                gTipo.setText(lblTipo02.getText());
                gGenero.setText(lblGenero02.getText());
                gPrecio.setText(lblPrecio02.getText());
                cmbTallaP.setValue(cmbTalla2.getValue());
                esconderPaneF(panelFoto1, panelFoto2, panelFoto3, panelFoto4, panelFoto5, panelFoto6, panelFoto7);
                panelFoto.getChildren().add(imageViewAmpliada);
                panelFoto.setVisible(true);
                break;
            case "padre3":

                gMarca.setText(lblMarca03.getText());
                gTipo.setText(lblTipo03.getText());
                gGenero.setText(lblGenero03.getText());
                gPrecio.setText(lblPrecio03.getText());
                cmbTallaP.setValue(cmbTalla3.getValue());
                esconderPaneF(panelFoto1, panelFoto, panelFoto3, panelFoto4, panelFoto5, panelFoto6, panelFoto7);
                panelFoto2.getChildren().add(imageViewAmpliada);
                panelFoto2.setVisible(true);
                break;
            case "padre4":

                gMarca.setText(lblMarca04.getText());
                gTipo.setText(lblTipo04.getText());
                gGenero.setText(lblGenero04.getText());
                gPrecio.setText(lblPrecio04.getText());
                cmbTallaP.setValue(cmbTalla4.getValue());
                esconderPaneF(panelFoto1, panelFoto2, panelFoto, panelFoto4, panelFoto5, panelFoto6, panelFoto7);
                panelFoto3.getChildren().add(imageViewAmpliada);
                panelFoto3.setVisible(true);
                break;
            case "padre5":

                gMarca.setText(lblMarca05.getText());
                gTipo.setText(lblTipo05.getText());
                gGenero.setText(lblGenero05.getText());
                gPrecio.setText(lblPrecio05.getText());
                cmbTallaP.setValue(cmbTalla5.getValue());
                esconderPaneF(panelFoto1, panelFoto2, panelFoto3, panelFoto, panelFoto5, panelFoto6, panelFoto7);
                panelFoto4.getChildren().add(imageViewAmpliada);
                panelFoto4.setVisible(true);
                break;
            case "padre6":

                gMarca.setText(lblMarca06.getText());
                gTipo.setText(lblTipo06.getText());
                gGenero.setText(lblGenero06.getText());
                gPrecio.setText(lblPrecio06.getText());
                cmbTallaP.setValue(cmbTalla6.getValue());
                esconderPaneF(panelFoto1, panelFoto2, panelFoto3, panelFoto4, panelFoto, panelFoto6, panelFoto7);
                panelFoto5.getChildren().add(imageViewAmpliada);
                panelFoto5.setVisible(true);
                break;
            case "padre7":

                gMarca.setText(lblMarca07.getText());
                gTipo.setText(lblTipo07.getText());
                gGenero.setText(lblGenero07.getText());
                gPrecio.setText(lblPrecio07.getText());
                cmbTallaP.setValue(cmbTalla7.getValue());
                esconderPaneF(panelFoto1, panelFoto2, panelFoto3, panelFoto4, panelFoto5, panelFoto, panelFoto7);
                panelFoto6.getChildren().add(imageViewAmpliada);
                panelFoto6.setVisible(true);
                break;
            case "padre8":

                gMarca.setText(lblMarca08.getText());
                gTipo.setText(lblTipo08.getText());
                gGenero.setText(lblGenero08.getText());
                gPrecio.setText(lblPrecio08.getText());
                cmbTallaP.setValue(cmbTalla8.getValue());
                esconderPaneF(panelFoto1, panelFoto2, panelFoto3, panelFoto4, panelFoto5, panelFoto6, panelFoto);
                panelFoto7.getChildren().add(imageViewAmpliada);
                panelFoto7.setVisible(true);
                break;
            default:
                throw new AssertionError();
        }

        panelProducto.setVisible(true);

    }

    public boolean tomarDatosProducto(Label marca, Label tipo, Label precio, Label genero, ComboBox talla) {
        Alert a = new Alert(Alert.AlertType.NONE);
        if (talla.getValue() == null) {
            a.setAlertType(Alert.AlertType.WARNING);
            a.setContentText("Debe seleccionar una talla");
            a.show();
            return false;
        } else {
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Producto agregado..!");
            a.show();
            return true;
        }
    }

    private Node getNodeFromGridPane(GridPane gridPane, int rowIndex, int colIndex) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getRowIndex(node) == rowIndex && GridPane.getColumnIndex(node) == colIndex) {
                return node;
            }
        }
        return null;
    }

    @FXML
    private void aggCarrito(ActionEvent event) {
        Button eventBtn = (Button) event.getSource();
        Label lblTalla = new Label();
        Label lblPrecio = new Label();
        Label lblMarca = new Label();
        Label lblGenero = new Label();
        Label lblTipo = new Label();
        Pane Imag = new Pane();
        Image mini;
        ImageView miniV;
        Button btnComprar = new Button("Comprar");
        Button btnEliminar = new Button("Eliminar");
        btnComprar.getStylesheets().add(getClass().getResource("/Styles/Style.css").toExternalForm());
        btnComprar.getStyleClass().add("btnAdd");
        btnEliminar.getStylesheets().add(getClass().getResource("/Styles/Style.css").toExternalForm());
        btnEliminar.getStyleClass().add("btnAdd");

        GridPane contendElemtProductos = new GridPane();
        contendElemtProductos.setAlignment(Pos.CENTER);
        ColumnConstraints column = new ColumnConstraints();
        column.setPrefWidth(panelContenCarrito.getWidth() / 4);

        contendElemtProductos.getColumnConstraints().addAll(column);
        contendElemtProductos.prefWidth(panelContenCarrito.getMaxWidth());
        contendElemtProductos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        contendElemtProductos.getStylesheets().add(getClass().getResource("/Styles/Style.css").toExternalForm());
        contendElemtProductos.getStyleClass().add("gridCarro");

        btnEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Botón clickeado");
                System.out.println(btnEliminar.getId());
                panelContenCarrito.getChildren().remove(contendElemtProductos);
                double t = 0;
                for (int i = 0; i < panelContenCarrito.getChildren().size(); i++) {
                    if (panelContenCarrito.getChildren().get(i) instanceof GridPane) {

                        GridPane gridPane = (GridPane) panelContenCarrito.getChildren().get(i);

                        Node dato = getNodeFromGridPane(gridPane, 1, 1);

                        Label precio = (Label) dato;

                        double p = Double.parseDouble(precio.getText());

                        txtTotal.setText("$" + (p + t));
                        String[] to = txtTotal.getText().split("\\$");
                        t = Double.parseDouble(to[1]);
                    }
                }

                if (panelContenCarrito.getChildren().isEmpty()) {
                    txtTotal.setText("");
                }

            }
        }
        );

        btnComprar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                System.out.println("Botón clickeado");
                System.out.println(btnComprar.getId());

                Nodo_Producto producto = new Nodo_Producto();

                Node marcaProducto = getNodeFromGridPane(contendElemtProductos, 2, 0);
                Node tipoProducto = getNodeFromGridPane(contendElemtProductos, 0, 1);
                Node precioProducto = getNodeFromGridPane(contendElemtProductos, 1, 1);

                int id = 0;
                do {
                    id = (int) Math.floor(Math.random() * (5000 - 10 + 1) + 10);
                } while (pilaP.getProId_H(id) != null);

                Integer idP = id;

                Label marcaLabel = (Label) marcaProducto;
                String marca = marcaLabel.getText();

                Label tipoLabel = (Label) tipoProducto;
                String tipo = tipoLabel.getText();

                Label precioLabel = (Label) precioProducto;
                DecimalFormat formatoDecimal = new DecimalFormat(".00");
                float precio = 0;
                try {
                    precio = formatoDecimal.parse(precioLabel.getText()).floatValue();
                } catch (ParseException ex) {
                    Logger.getLogger(Controller_View_Catalogo_Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                String comprador = labelUser.getText();

                LocalDateTime fechaHoraActual = LocalDateTime.now();
                producto.setFechaCompra(fechaHoraActual);
                producto.setId(idP);
                producto.setMarca(marca);
                producto.setTipo(tipo);
                producto.setPrecio(precio);
                producto.setComprador(comprador);

                pilaP.setPushProducto_H(producto);
                pilaP.guardarDatosEnArchivoCompras(pilaP.getPilaPH());

                GridPane grid1 = (GridPane) btnComprar.getParent();
                Node image = getNodeFromGridPane(grid1, 1, 0);
                Node total = getNodeFromGridPane(grid1, 1, 1);

                Label pre = (Label) total;
                Label precioT = new Label();
                precioT.setText("Precio: " + pre.getText());

                Label estado = new Label();
                estado.setText("Estado: Enviado");

                Label fecha1 = new Label();
                Label fecha2 = new Label();
                String f = String.valueOf(fechaHoraActual);
                fecha1.setText(f);
                String[] date = fecha1.getText().split("T");
                fecha2.setText("Fecha envio: " + date[0]);

                GridPane grid2 = new GridPane();
                ColumnConstraints column = new ColumnConstraints();
                column.setPrefWidth(contenPagados.getWidth() / 3);

                grid2.getColumnConstraints().addAll(column);
                grid2.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
                grid2.getStylesheets().add(getClass().getResource("/Styles/Style.css").toExternalForm());
                grid2.getStyleClass().add("gridCarro");

                grid2.add(image, 0, 1);
                grid2.add(precioT, 1, 0);
                grid2.add(estado, 1, 1);
                grid2.add(fecha2, 1, 2);

                contenPagados.getChildren().add(grid2);

                panelContenCarrito.getChildren().remove(contendElemtProductos);
                double t = 0;
                for (int i = 0; i < panelContenCarrito.getChildren().size(); i++) {
                    if (panelContenCarrito.getChildren().get(i) instanceof GridPane) {

                        GridPane gridPane = (GridPane) panelContenCarrito.getChildren().get(i);

                        Node dato = getNodeFromGridPane(gridPane, 1, 1);

                        Label precio2 = (Label) dato;

                        double p = Double.parseDouble(precio2.getText());

                        txtTotal.setText("$" + (p + t));
                        String[] to = txtTotal.getText().split("\\$");
                        t = Double.parseDouble(to[1]);
                    }
                }

                if (panelContenCarrito.getChildren().isEmpty()) {
                    txtTotal.setText("");
                }
            }
        }
        );

        if (lblGenero01.getText()
                .equals("MASCULINO")) {
            switch (eventBtn.getId()) {
                case "btnAggCrto1":
                    mini = new Image("/Images/Catalogo_Hombres/OufitMen1.png");
                    miniV = new ImageView(mini);
                    miniV.setFitHeight(40);
                    miniV.setFitWidth(30);
                    Imag.getChildren().add(miniV);

                    lblTalla.setText(cmbTalla1.getValue());
                    lblPrecio.setText(lblPrecio01.getText());
                    lblMarca.setText(lblMarca01.getText());
                    lblGenero.setText(lblGenero01.getText());
                    lblTipo.setText(lblTipo01.getText());

                    contendElemtProductos.add(Imag, 0, 1);
                    contendElemtProductos.add(lblMarca, 0, 2);
                    contendElemtProductos.add(lblTipo, 1, 0);
                    contendElemtProductos.add(lblGenero, 2, 0);
                    contendElemtProductos.add(lblTalla, 2, 1);
                    contendElemtProductos.add(lblPrecio, 1, 1);
                    contendElemtProductos.add(btnComprar, 1, 2);
                    contendElemtProductos.add(btnEliminar, 2, 2);

                    if (tomarDatosProducto(lblMarca01, lblTipo01, lblPrecio01, lblGenero01, cmbTalla1)) {
                        panelContenCarrito.getChildren().add(contendElemtProductos);
                    }
                    break;
                case "btnAggCrto2":
                    mini = new Image("/Images/Catalogo_Hombres/OufitMen2.png");
                    miniV = new ImageView(mini);
                    miniV.setFitHeight(40);
                    miniV.setFitWidth(30);
                    Imag.getChildren().add(miniV);

                    lblTalla.setText(cmbTalla2.getValue());
                    lblPrecio.setText(lblPrecio02.getText());
                    lblMarca.setText(lblMarca02.getText());
                    lblGenero.setText(lblGenero02.getText());
                    lblTipo.setText(lblTipo02.getText());

                    contendElemtProductos.add(Imag, 0, 1);
                    contendElemtProductos.add(lblMarca, 0, 2);
                    contendElemtProductos.add(lblTipo, 1, 0);
                    contendElemtProductos.add(lblGenero, 2, 0);
                    contendElemtProductos.add(lblTalla, 2, 1);
                    contendElemtProductos.add(lblPrecio, 1, 1);
                    contendElemtProductos.add(btnComprar, 1, 2);
                    contendElemtProductos.add(btnEliminar, 2, 2);

                    if (tomarDatosProducto(lblMarca02, lblTipo02, lblPrecio02, lblGenero02, cmbTalla2)) {
                        panelContenCarrito.getChildren().add(contendElemtProductos);
                    }
                    break;

                case "btnAggCrto3":
                    mini = new Image("/Images/Catalogo_Hombres/OufitMen3.png");
                    miniV = new ImageView(mini);
                    miniV.setFitHeight(40);
                    miniV.setFitWidth(30);
                    Imag.getChildren().add(miniV);

                    lblTalla.setText(cmbTalla3.getValue());
                    lblPrecio.setText(lblPrecio03.getText());
                    lblMarca.setText(lblMarca03.getText());
                    lblGenero.setText(lblGenero03.getText());
                    lblTipo.setText(lblTipo03.getText());

                    contendElemtProductos.add(Imag, 0, 1);
                    contendElemtProductos.add(lblMarca, 0, 2);
                    contendElemtProductos.add(lblTipo, 1, 0);
                    contendElemtProductos.add(lblGenero, 2, 0);
                    contendElemtProductos.add(lblTalla, 2, 1);
                    contendElemtProductos.add(lblPrecio, 1, 1);
                    contendElemtProductos.add(btnComprar, 1, 2);
                    contendElemtProductos.add(btnEliminar, 2, 2);

                    if (tomarDatosProducto(lblMarca03, lblTipo03, lblPrecio03, lblGenero03, cmbTalla3)) {
                        panelContenCarrito.getChildren().add(contendElemtProductos);
                    }
                    break;
                case "btnAggCrto4":
                    mini = new Image("/Images/Catalogo_Hombres/OufitMen4.png");
                    miniV = new ImageView(mini);
                    miniV.setFitHeight(40);
                    miniV.setFitWidth(30);
                    Imag.getChildren().add(miniV);

                    lblTalla.setText(cmbTalla4.getValue());
                    lblPrecio.setText(lblPrecio04.getText());
                    lblMarca.setText(lblMarca04.getText());
                    lblGenero.setText(lblGenero04.getText());
                    lblTipo.setText(lblTipo04.getText());

                    contendElemtProductos.add(Imag, 0, 1);
                    contendElemtProductos.add(lblMarca, 0, 2);
                    contendElemtProductos.add(lblTipo, 1, 0);
                    contendElemtProductos.add(lblGenero, 2, 0);
                    contendElemtProductos.add(lblTalla, 2, 1);
                    contendElemtProductos.add(lblPrecio, 1, 1);
                    contendElemtProductos.add(btnComprar, 1, 2);
                    contendElemtProductos.add(btnEliminar, 2, 2);

                    if (tomarDatosProducto(lblMarca04, lblTipo04, lblPrecio04, lblGenero04, cmbTalla4)) {
                        panelContenCarrito.getChildren().add(contendElemtProductos);
                    }
                    break;
                case "btnAggCrto5":
                    mini = new Image("/Images/Catalogo_Hombres/OufitMen5.png");
                    miniV = new ImageView(mini);
                    miniV.setFitHeight(40);
                    miniV.setFitWidth(30);
                    Imag.getChildren().add(miniV);

                    lblTalla.setText(cmbTalla5.getValue());
                    lblPrecio.setText(lblPrecio05.getText());
                    lblMarca.setText(lblMarca05.getText());
                    lblGenero.setText(lblGenero05.getText());
                    lblTipo.setText(lblTipo05.getText());

                    contendElemtProductos.add(Imag, 0, 1);
                    contendElemtProductos.add(lblMarca, 0, 2);
                    contendElemtProductos.add(lblTipo, 1, 0);
                    contendElemtProductos.add(lblGenero, 2, 0);
                    contendElemtProductos.add(lblTalla, 2, 1);
                    contendElemtProductos.add(lblPrecio, 1, 1);
                    contendElemtProductos.add(btnComprar, 1, 2);
                    contendElemtProductos.add(btnEliminar, 2, 2);

                    if (tomarDatosProducto(lblMarca05, lblTipo05, lblPrecio05, lblGenero05, cmbTalla5)) {
                        panelContenCarrito.getChildren().add(contendElemtProductos);
                    }
                    break;
                case "btnAggCrto6":
                    mini = new Image("/Images/Catalogo_Hombres/OufitMen6.png");
                    miniV = new ImageView(mini);
                    miniV.setFitHeight(40);
                    miniV.setFitWidth(30);
                    Imag.getChildren().add(miniV);

                    lblTalla.setText(cmbTalla6.getValue());
                    lblPrecio.setText(lblPrecio06.getText());
                    lblMarca.setText(lblMarca06.getText());
                    lblGenero.setText(lblGenero06.getText());
                    lblTipo.setText(lblTipo06.getText());

                    contendElemtProductos.add(Imag, 0, 1);
                    contendElemtProductos.add(lblMarca, 0, 2);
                    contendElemtProductos.add(lblTipo, 1, 0);
                    contendElemtProductos.add(lblGenero, 2, 0);
                    contendElemtProductos.add(lblTalla, 2, 1);
                    contendElemtProductos.add(lblPrecio, 1, 1);
                    contendElemtProductos.add(btnComprar, 1, 2);
                    contendElemtProductos.add(btnEliminar, 2, 2);

                    if (tomarDatosProducto(lblMarca06, lblTipo06, lblPrecio06, lblGenero06, cmbTalla6)) {
                        panelContenCarrito.getChildren().add(contendElemtProductos);
                    }
                    break;
                case "btnAggCrto7":
                    mini = new Image("/Images/Catalogo_Hombres/OufitMen7.png");
                    miniV = new ImageView(mini);
                    miniV.setFitHeight(40);
                    miniV.setFitWidth(30);
                    Imag.getChildren().add(miniV);

                    lblTalla.setText(cmbTalla7.getValue());
                    lblPrecio.setText(lblPrecio07.getText());
                    lblMarca.setText(lblMarca07.getText());
                    lblGenero.setText(lblGenero07.getText());
                    lblTipo.setText(lblTipo07.getText());

                    contendElemtProductos.add(Imag, 0, 1);
                    contendElemtProductos.add(lblMarca, 0, 2);
                    contendElemtProductos.add(lblTipo, 1, 0);
                    contendElemtProductos.add(lblGenero, 2, 0);
                    contendElemtProductos.add(lblTalla, 2, 1);
                    contendElemtProductos.add(lblPrecio, 1, 1);
                    contendElemtProductos.add(btnComprar, 1, 2);
                    contendElemtProductos.add(btnEliminar, 2, 2);

                    if (tomarDatosProducto(lblMarca07, lblTipo07, lblPrecio07, lblGenero07, cmbTalla7)) {
                        panelContenCarrito.getChildren().add(contendElemtProductos);
                    }
                    break;
                case "btnAggCrto8":
                    mini = new Image("/Images/Catalogo_Hombres/OufitMen8.png");
                    miniV = new ImageView(mini);
                    miniV.setFitHeight(40);
                    miniV.setFitWidth(30);
                    Imag.getChildren().add(miniV);

                    lblTalla.setText(cmbTalla8.getValue());
                    lblPrecio.setText(lblPrecio08.getText());
                    lblMarca.setText(lblMarca08.getText());
                    lblGenero.setText(lblGenero08.getText());
                    lblTipo.setText(lblTipo08.getText());

                    contendElemtProductos.add(Imag, 0, 1);
                    contendElemtProductos.add(lblMarca, 0, 2);
                    contendElemtProductos.add(lblTipo, 1, 0);
                    contendElemtProductos.add(lblGenero, 2, 0);
                    contendElemtProductos.add(lblTalla, 2, 1);
                    contendElemtProductos.add(lblPrecio, 1, 1);
                    contendElemtProductos.add(btnComprar, 1, 2);
                    contendElemtProductos.add(btnEliminar, 2, 2);

                    if (tomarDatosProducto(lblMarca08, lblTipo08, lblPrecio08, lblGenero08, cmbTalla8)) {
                        panelContenCarrito.getChildren().add(contendElemtProductos);
                    }
                    break;

            }
        } else {
            switch (eventBtn.getId()) {
                case "btnAggCrto1":
                    mini = new Image("/Images/Catalogo_Mujeres/OufitWoman1.png");
                    miniV = new ImageView(mini);
                    miniV.setFitHeight(40);
                    miniV.setFitWidth(30);
                    Imag.getChildren().add(miniV);

                    lblTalla.setText(cmbTalla1.getValue());
                    lblPrecio.setText(lblPrecio01.getText());
                    lblMarca.setText(lblMarca01.getText());
                    lblGenero.setText(lblGenero01.getText());
                    lblTipo.setText(lblTipo01.getText());

                    contendElemtProductos.add(Imag, 0, 1);
                    contendElemtProductos.add(lblMarca, 0, 2);
                    contendElemtProductos.add(lblTipo, 1, 0);
                    contendElemtProductos.add(lblGenero, 2, 0);
                    contendElemtProductos.add(lblTalla, 2, 1);
                    contendElemtProductos.add(lblPrecio, 1, 1);
                    contendElemtProductos.add(btnComprar, 1, 2);
                    contendElemtProductos.add(btnEliminar, 2, 2);

                    if (tomarDatosProducto(lblMarca01, lblTipo01, lblPrecio01, lblGenero01, cmbTalla1)) {
                        panelContenCarrito.getChildren().add(contendElemtProductos);
                    }
                    break;
                case "btnAggCrto2":
                    mini = new Image("/Images/Catalogo_Mujeres/OufitWoman2.png");
                    miniV = new ImageView(mini);
                    miniV.setFitHeight(40);
                    miniV.setFitWidth(30);
                    Imag.getChildren().add(miniV);

                    lblTalla.setText(cmbTalla2.getValue());
                    lblPrecio.setText(lblPrecio02.getText());
                    lblMarca.setText(lblMarca02.getText());
                    lblGenero.setText(lblGenero02.getText());
                    lblTipo.setText(lblTipo02.getText());

                    contendElemtProductos.add(Imag, 0, 1);
                    contendElemtProductos.add(lblMarca, 0, 2);
                    contendElemtProductos.add(lblTipo, 1, 0);
                    contendElemtProductos.add(lblGenero, 2, 0);
                    contendElemtProductos.add(lblTalla, 2, 1);
                    contendElemtProductos.add(lblPrecio, 1, 1);
                    contendElemtProductos.add(btnComprar, 1, 2);
                    contendElemtProductos.add(btnEliminar, 2, 2);

                    if (tomarDatosProducto(lblMarca02, lblTipo02, lblPrecio02, lblGenero02, cmbTalla2)) {
                        panelContenCarrito.getChildren().add(contendElemtProductos);
                    }
                    break;

                case "btnAggCrto3":
                    mini = new Image("/Images/Catalogo_Mujeres/OufitWoman3.png");
                    miniV = new ImageView(mini);
                    miniV.setFitHeight(40);
                    miniV.setFitWidth(30);
                    Imag.getChildren().add(miniV);

                    lblTalla.setText(cmbTalla3.getValue());
                    lblPrecio.setText(lblPrecio03.getText());
                    lblMarca.setText(lblMarca03.getText());
                    lblGenero.setText(lblGenero03.getText());
                    lblTipo.setText(lblTipo03.getText());

                    contendElemtProductos.add(Imag, 0, 1);
                    contendElemtProductos.add(lblMarca, 0, 2);
                    contendElemtProductos.add(lblTipo, 1, 0);
                    contendElemtProductos.add(lblGenero, 2, 0);
                    contendElemtProductos.add(lblTalla, 2, 1);
                    contendElemtProductos.add(lblPrecio, 1, 1);
                    contendElemtProductos.add(btnComprar, 1, 2);
                    contendElemtProductos.add(btnEliminar, 2, 2);

                    if (tomarDatosProducto(lblMarca03, lblTipo03, lblPrecio03, lblGenero03, cmbTalla3)) {
                        panelContenCarrito.getChildren().add(contendElemtProductos);
                    }
                    break;
                case "btnAggCrto4":
                    mini = new Image("/Images/Catalogo_Mujeres/OufitWoman4.png");
                    miniV = new ImageView(mini);
                    miniV.setFitHeight(40);
                    miniV.setFitWidth(30);
                    Imag.getChildren().add(miniV);

                    lblTalla.setText(cmbTalla4.getValue());
                    lblPrecio.setText(lblPrecio04.getText());
                    lblMarca.setText(lblMarca04.getText());
                    lblGenero.setText(lblGenero04.getText());
                    lblTipo.setText(lblTipo04.getText());

                    contendElemtProductos.add(Imag, 0, 1);
                    contendElemtProductos.add(lblMarca, 0, 2);
                    contendElemtProductos.add(lblTipo, 1, 0);
                    contendElemtProductos.add(lblGenero, 2, 0);
                    contendElemtProductos.add(lblTalla, 2, 1);
                    contendElemtProductos.add(lblPrecio, 1, 1);
                    contendElemtProductos.add(btnComprar, 1, 2);
                    contendElemtProductos.add(btnEliminar, 2, 2);

                    if (tomarDatosProducto(lblMarca04, lblTipo04, lblPrecio04, lblGenero04, cmbTalla4)) {
                        panelContenCarrito.getChildren().add(contendElemtProductos);
                    }
                    break;
                case "btnAggCrto5":
                    mini = new Image("/Images/Catalogo_Mujeres/OufitWoman5.png");
                    miniV = new ImageView(mini);
                    miniV.setFitHeight(40);
                    miniV.setFitWidth(30);
                    Imag.getChildren().add(miniV);

                    lblTalla.setText(cmbTalla5.getValue());
                    lblPrecio.setText(lblPrecio05.getText());
                    lblMarca.setText(lblMarca05.getText());
                    lblGenero.setText(lblGenero05.getText());
                    lblTipo.setText(lblTipo05.getText());

                    contendElemtProductos.add(Imag, 0, 1);
                    contendElemtProductos.add(lblMarca, 0, 2);
                    contendElemtProductos.add(lblTipo, 1, 0);
                    contendElemtProductos.add(lblGenero, 2, 0);
                    contendElemtProductos.add(lblTalla, 2, 1);
                    contendElemtProductos.add(lblPrecio, 1, 1);
                    contendElemtProductos.add(btnComprar, 1, 2);
                    contendElemtProductos.add(btnEliminar, 2, 2);

                    if (tomarDatosProducto(lblMarca05, lblTipo05, lblPrecio05, lblGenero05, cmbTalla5)) {
                        panelContenCarrito.getChildren().add(contendElemtProductos);
                    }
                    break;
                case "btnAggCrto6":
                    mini = new Image("/Images/Catalogo_Mujeres/OufitWoman6.png");
                    miniV = new ImageView(mini);
                    miniV.setFitHeight(40);
                    miniV.setFitWidth(30);
                    Imag.getChildren().add(miniV);

                    lblTalla.setText(cmbTalla6.getValue());
                    lblPrecio.setText(lblPrecio06.getText());
                    lblMarca.setText(lblMarca06.getText());
                    lblGenero.setText(lblGenero06.getText());
                    lblTipo.setText(lblTipo06.getText());

                    contendElemtProductos.add(Imag, 0, 1);
                    contendElemtProductos.add(lblMarca, 0, 2);
                    contendElemtProductos.add(lblTipo, 1, 0);
                    contendElemtProductos.add(lblGenero, 2, 0);
                    contendElemtProductos.add(lblTalla, 2, 1);
                    contendElemtProductos.add(lblPrecio, 1, 1);
                    contendElemtProductos.add(btnComprar, 1, 2);
                    contendElemtProductos.add(btnEliminar, 2, 2);

                    if (tomarDatosProducto(lblMarca06, lblTipo06, lblPrecio06, lblGenero06, cmbTalla6)) {
                        panelContenCarrito.getChildren().add(contendElemtProductos);
                    }
                    break;
                case "btnAggCrto7":
                    mini = new Image("/Images/Catalogo_Mujeres/OufitWoman7.png");
                    miniV = new ImageView(mini);
                    miniV.setFitHeight(40);
                    miniV.setFitWidth(30);
                    Imag.getChildren().add(miniV);

                    lblTalla.setText(cmbTalla7.getValue());
                    lblPrecio.setText(lblPrecio07.getText());
                    lblMarca.setText(lblMarca07.getText());
                    lblGenero.setText(lblGenero07.getText());
                    lblTipo.setText(lblTipo07.getText());

                    contendElemtProductos.add(Imag, 0, 1);
                    contendElemtProductos.add(lblMarca, 0, 2);
                    contendElemtProductos.add(lblTipo, 1, 0);
                    contendElemtProductos.add(lblGenero, 2, 0);
                    contendElemtProductos.add(lblTalla, 2, 1);
                    contendElemtProductos.add(lblPrecio, 1, 1);
                    contendElemtProductos.add(btnComprar, 1, 2);
                    contendElemtProductos.add(btnEliminar, 2, 2);

                    if (tomarDatosProducto(lblMarca07, lblTipo07, lblPrecio07, lblGenero07, cmbTalla7)) {
                        panelContenCarrito.getChildren().add(contendElemtProductos);
                    }
                    break;
                case "btnAggCrto8":
                    mini = new Image("/Images/Catalogo_Mujeres/OufitWoman8.png");
                    miniV = new ImageView(mini);
                    miniV.setFitHeight(40);
                    miniV.setFitWidth(30);
                    Imag.getChildren().add(miniV);

                    lblTalla.setText(cmbTalla8.getValue());
                    lblPrecio.setText(lblPrecio08.getText());
                    lblMarca.setText(lblMarca08.getText());
                    lblGenero.setText(lblGenero08.getText());
                    lblTipo.setText(lblTipo08.getText());

                    contendElemtProductos.add(Imag, 0, 1);
                    contendElemtProductos.add(lblMarca, 0, 2);
                    contendElemtProductos.add(lblTipo, 1, 0);
                    contendElemtProductos.add(lblGenero, 2, 0);
                    contendElemtProductos.add(lblTalla, 2, 1);
                    contendElemtProductos.add(lblPrecio, 1, 1);
                    contendElemtProductos.add(btnComprar, 1, 2);
                    contendElemtProductos.add(btnEliminar, 2, 2);

                    if (tomarDatosProducto(lblMarca08, lblTipo08, lblPrecio08, lblGenero08, cmbTalla8)) {
                        panelContenCarrito.getChildren().add(contendElemtProductos);
                    }
                    break;

            }
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

    @FXML
    private void cambiarCatalogo(ActionEvent event) {

        if (event.getSource() == btnFem) {

            img1.getChildren().clear();
            img2.getChildren().clear();
            img3.getChildren().clear();
            img4.getChildren().clear();
            img5.getChildren().clear();
            img6.getChildren().clear();
            img7.getChildren().clear();
            img8.getChildren().clear();

            paneImageMap.clear();
            paneImageMap = new HashMap<>();

            paneImageMap.put(img1, new Image("/Images/Catalogo_Mujeres/OufitWoman1.png"));
            lblMarca01.setText("PUFF GIRL");
            lblGenero01.setText("FEMENINO");
            lblTipo01.setText("CAMISETA");
            lblPrecio01.setText("49254");

            paneImageMap.put(img2, new Image("/Images/Catalogo_Mujeres/OufitWoman2.png"));
            lblMarca02.setText("CALVIN KLEIN");
            lblGenero02.setText("FEMENINO");
            lblTipo02.setText("BUZO-BLANCO");
            lblPrecio02.setText("389900");

            paneImageMap.put(img3, new Image("/Images/Catalogo_Mujeres/OufitWoman3.png"));
            lblMarca03.setText("GENERICO");
            lblGenero03.setText("FEMENINO");
            lblTipo03.setText("BUZO HOODIE");
            lblPrecio03.setText("103000");

            paneImageMap.put(img4, new Image("/Images/Catalogo_Mujeres/OufitWoman4.png"));
            lblMarca04.setText("GENERICO");
            lblGenero04.setText("FEMENINO");
            lblTipo04.setText("BUZO HOODIE");
            lblPrecio04.setText("103000");

            paneImageMap.put(img5, new Image("/Images/Catalogo_Mujeres/OufitWoman5.png"));
            lblMarca05.setText("SHINYINYY");
            lblGenero05.setText("FEMENINO");
            lblTipo05.setText("MINI FALDA");
            lblPrecio05.setText("57835");

            paneImageMap.put(img6, new Image("/Images/Catalogo_Mujeres/OufitWoman6.png"));
            lblMarca06.setText("ZARA");
            lblGenero06.setText("FEMENINO");
            lblTipo06.setText("CONJUNTO");
            lblPrecio06.setText("126440");

            paneImageMap.put(img7, new Image("/Images/Catalogo_Mujeres/OufitWoman7.png"));
            lblMarca07.setText("REDANK");
            lblGenero07.setText("FEMENINO");
            lblTipo07.setText("JOGGER-SHORT");
            lblPrecio07.setText("31500");

            paneImageMap.put(img8, new Image("/Images/Catalogo_Mujeres/OufitWoman8.png"));
            lblMarca08.setText("MOVIES");
            lblGenero08.setText("FEMENINO");
            lblTipo08.setText("JOGGER");
            lblPrecio08.setText("94990");
            mostrarImagenes();

        } else if (event.getSource() == btnMas) {

            img1.getChildren().clear();
            img2.getChildren().clear();
            img3.getChildren().clear();
            img4.getChildren().clear();
            img5.getChildren().clear();
            img6.getChildren().clear();
            img7.getChildren().clear();
            img8.getChildren().clear();

            paneImageMap.clear();
            paneImageMap = new HashMap<>();

            paneImageMap.put(img1, new Image("/Images/Catalogo_Hombres/OufitMen1.png"));
            lblMarca01.setText("NIKE");
            lblGenero01.setText("MASCULINO");
            lblTipo01.setText("CAMISETA");
            lblPrecio01.setText("103900");

            paneImageMap.put(img2, new Image("/Images/Catalogo_Hombres/OufitMen2.png"));
            lblMarca02.setText("NIKE");
            lblGenero02.setText("MASCULINO");
            lblTipo02.setText("CAMISETA");
            lblPrecio02.setText("117900");

            paneImageMap.put(img3, new Image("/Images/Catalogo_Hombres/OufitMen3.png"));
            lblMarca03.setText("NIKE");
            lblGenero03.setText("MASCULINO");
            lblTipo03.setText("CAMISETA");
            lblPrecio03.setText("130900");

            paneImageMap.put(img4, new Image("/Images/Catalogo_Hombres/OufitMen4.png"));
            lblMarca04.setText("NIKE");
            lblGenero04.setText("MASCULINO");
            lblTipo04.setText("BUZO");
            lblPrecio04.setText("237900");

            paneImageMap.put(img5, new Image("/Images/Catalogo_Hombres/OufitMen5.png"));
            lblMarca05.setText("MOVIES");
            lblGenero05.setText("MASCULINO");
            lblTipo05.setText("JOGGER-BEIGE");
            lblPrecio05.setText("79995");

            paneImageMap.put(img6, new Image("/Images/Catalogo_Hombres/OufitMen6.png"));
            lblMarca06.setText("MOVIES");
            lblGenero06.setText("MASCULINO");
            lblTipo06.setText("JOGGER-GRIS");
            lblPrecio06.setText("74995");

            paneImageMap.put(img7, new Image("/Images/Catalogo_Hombres/OufitMen7.png"));
            lblMarca07.setText("HA");
            lblGenero07.setText("MASCULINO");
            lblTipo07.setText("JOGGER-NEGRO");
            lblPrecio07.setText("129900");

            paneImageMap.put(img8, new Image("/Images/Catalogo_Hombres/OufitMen8.png"));
            lblMarca07.setText("HA");
            lblGenero07.setText("MASCULINO");
            lblTipo07.setText("JOGGER");
            lblPrecio07.setText("94900");
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
                scrollPane01.setVisible(false);
            }
        } else if (event.getSource() == btnPerfil) {
            if (PmenuP.isVisible()) {

                PmenuP.setVisible(false);
            } else {

                Pmenu.setVisible(false);
                PmenuP.setVisible(true);
                panelContenProdPagados.setVisible(false);
                scrollPane.setVisible(false);
                scrollPane01.setVisible(false);
            }
        } else if (event.getSource() == btnCarro) {
            double t = 0;
            for (int i = 0; i < panelContenCarrito.getChildren().size(); i++) {
                if (panelContenCarrito.getChildren().get(i) instanceof GridPane) {

                    GridPane gridPane = (GridPane) panelContenCarrito.getChildren().get(i);

                    Node dato = getNodeFromGridPane(gridPane, 1, 1);

                    Label precio = (Label) dato;

                    double p = Double.parseDouble(precio.getText());

                    txtTotal.setText("$" + (p + t));
                    String[] to = txtTotal.getText().split("\\$");
                    t = Double.parseDouble(to[1]);
                }
            }

            if (panelContenCarrito.getChildren().isEmpty()) {
                txtTotal.setText("");
            }

            scrollPane.setVisible(!scrollPane.isVisible());
            scrollPane01.setVisible(!scrollPane01.isVisible());
            PmenuP.setVisible(false);
            Pmenu.setVisible(false);
            panelContenProdPagados.setVisible(false);
        } else if (event.getSource() == btnCerrarS) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
            alert.setContentText("Está apunto de cerrar la sesión\nEstá seguro de esto? :)");
            alert.setTitle("Confirmación");
            alert.showAndWait().ifPresent((ButtonType response) -> {
                if (response == ButtonType.YES) {
                    try {
                        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.FINISH);
                        alert2.setTitle("Información");
                        alert2.setHeaderText("Hasta la proxima..!");
                        alert2.setContentText("¡Cerrando sesión..!");
                        alert2.showAndWait();

                        Stage miStage = (Stage) this.btnCerrarS.getScene().getWindow();
                        miStage.close();

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Arranque.fxml"));

                        Parent roott = loader.load();

                        Scene scene = new Scene(roott);
                        Stage stage = new Stage();

                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.initStyle(StageStyle.UNDECORATED);

                        stage.setScene(scene);
                        stage.show();

                    } catch (IOException ex) {
                        Logger.getLogger(Controller_View_Catalogo_Usuario.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (response == ButtonType.NO) {
                    Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.FINISH);
                    alert2.setTitle("Información");
                    alert2.setHeaderText("Te quedaste?!");
                    alert2.setContentText("¡Sigue comprando...!");
                    alert2.show();
                    alert.close();
                }
            });
        } else if (event.getSource() == btnEnviado) {
            panelContenProdPagados.setVisible(!panelContenProdPagados.isVisible());
            PmenuP.setVisible(false);
            Pmenu.setVisible(false);
            scrollPane.setVisible(false);
            scrollPane01.setVisible(false);

        } else if (event.getSource() == btnCambC) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_CambiarClave.fxml"));

                Parent roott = loader.load();

                Controller_View_CambiarClave controller = loader.getController();
                controller.getTextIndice().setText("USER");
                controller.getTxtUser().setText(labelUser.getText());

                Scene scene = new Scene(roott);
                Stage stage = new Stage();

                stage.initStyle(StageStyle.UNDECORATED);

                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(Controller_View_Catalogo_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    private void pVisible(MouseEvent event) {
        PmenuP.setVisible(false);
        Pmenu.setVisible(false);
        scrollPane.setVisible(false);
        scrollPane01.setVisible(false);
        panelContenProdPagados.setVisible(false);
    }

    private void procesarImagen(Pane paneFoto, Image image) {
        Label lblTalla = new Label();
        Label lblPrecio = new Label();
        Label lblMarca = new Label();
        Label lblGenero = new Label();
        Label lblTipo = new Label();
        Pane Imag = new Pane();
        ImageView miniV;
        Button btnComprar = new Button("Comprar");
        Button btnEliminar = new Button("Eliminar");
        btnComprar.getStylesheets().add(getClass().getResource("/Styles/Style.css").toExternalForm());
        btnComprar.getStyleClass().add("btnAdd");
        btnEliminar.getStylesheets().add(getClass().getResource("/Styles/Style.css").toExternalForm());
        btnEliminar.getStyleClass().add("btnAdd");

        GridPane contendElemtProductos = new GridPane();
        contendElemtProductos.setAlignment(Pos.CENTER);
        contendElemtProductos.setMaxSize(375, 394);
        ColumnConstraints column = new ColumnConstraints();
        column.setPrefWidth(panelContenCarrito.getWidth() / 2);

        contendElemtProductos.getColumnConstraints().addAll(column);
        contendElemtProductos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        contendElemtProductos.getStylesheets().add(getClass().getResource("/Styles/Style.css").toExternalForm());
        contendElemtProductos.getStyleClass().add("gridCarro");

        btnEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Botón clickeado");
                System.out.println(btnEliminar.getId());
                panelContenCarrito.getChildren().remove(contendElemtProductos);
                double t = 0;
                for (int i = 0; i < panelContenCarrito.getChildren().size(); i++) {
                    if (panelContenCarrito.getChildren().get(i) instanceof GridPane) {

                        GridPane gridPane = (GridPane) panelContenCarrito.getChildren().get(i);

                        Node dato = getNodeFromGridPane(gridPane, 1, 1);

                        Label precio = (Label) dato;

                        double p = Double.parseDouble(precio.getText());

                        txtTotal.setText("$" + (p + t));
                        String[] to = txtTotal.getText().split("\\$");
                        t = Double.parseDouble(to[1]);
                    }
                }

                if (panelContenCarrito.getChildren().isEmpty()) {
                    txtTotal.setText("");
                }
            }
        });

        btnComprar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Botón clickeado");
                System.out.println(btnComprar.getId());

                Nodo_Producto producto = new Nodo_Producto();

                Node marcaProducto = getNodeFromGridPane(contendElemtProductos, 2, 0);
                Node tipoProducto = getNodeFromGridPane(contendElemtProductos, 0, 1);
                Node precioProducto = getNodeFromGridPane(contendElemtProductos, 1, 1);

                int id = 0;
                do {
                    id = (int) Math.floor(Math.random() * (5000 - 10 + 1) + 10);
                } while (pilaP.getProId_H(id) != null);

                Integer idP = id;

                Label marcaLabel = (Label) marcaProducto;
                String marca = marcaLabel.getText();

                Label tipoLabel = (Label) tipoProducto;
                String tipo = tipoLabel.getText();

                Label precioLabel = (Label) precioProducto;
                DecimalFormat formatoDecimal = new DecimalFormat("#.00");
                long precio = 0;
                try {
                    precio = formatoDecimal.parse(precioLabel.getText()).longValue();
                } catch (ParseException ex) {
                    Logger.getLogger(Controller_View_Catalogo_Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                String comprador = labelUser.getText();

                LocalDateTime fechaHoraActual = LocalDateTime.now();
                producto.setFechaCompra(fechaHoraActual);
                producto.setId(idP);
                producto.setMarca(marca);
                producto.setTipo(tipo);
                producto.setPrecio(precio);
                producto.setComprador(comprador);

                pilaP.setPushProducto_H(producto);
                pilaP.guardarDatosEnArchivoCompras(pilaP.getPilaPH());

                GridPane grid1 = (GridPane) btnComprar.getParent();
                Node image = getNodeFromGridPane(grid1, 1, 0);
                Node total = getNodeFromGridPane(grid1, 1, 1);

                Label pre = (Label) total;
                Label precioT = new Label();
                precioT.setText("Precio: " + pre.getText());

                Label estado = new Label();
                estado.setText("Estado: Enviado");

                Label fecha1 = new Label();
                Label fecha2 = new Label();
                String f = String.valueOf(fechaHoraActual);
                fecha1.setText(f);
                String[] date = fecha1.getText().split("T");
                fecha2.setText("Fecha envio: " + date[0]);

                GridPane grid2 = new GridPane();
                ColumnConstraints column = new ColumnConstraints();
                column.setPrefWidth(contenPagados.getWidth() / 3);

                grid2.getColumnConstraints().addAll(column);
                grid2.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
                grid2.getStylesheets().add(getClass().getResource("/Styles/Style.css").toExternalForm());
                grid2.getStyleClass().add("gridCarro");

                grid2.add(image, 0, 1);
                grid2.add(precioT, 1, 0);
                grid2.add(estado, 1, 1);
                grid2.add(fecha2, 1, 2);

                contenPagados.getChildren().add(grid2);

                panelContenCarrito.getChildren().remove(contendElemtProductos);
                double t = 0;
                for (int i = 0; i < panelContenCarrito.getChildren().size(); i++) {
                    if (panelContenCarrito.getChildren().get(i) instanceof GridPane) {

                        GridPane gridPane = (GridPane) panelContenCarrito.getChildren().get(i);

                        Node dato = getNodeFromGridPane(gridPane, 1, 1);

                        Label precio2 = (Label) dato;

                        double p = Double.parseDouble(precio2.getText());

                        txtTotal.setText("$" + (p + t));
                        String[] to = txtTotal.getText().split("\\$");
                        t = Double.parseDouble(to[1]);
                    }
                }

                if (panelContenCarrito.getChildren().isEmpty()) {
                    txtTotal.setText("");
                }
            }
        });

        if (paneFoto.isVisible()) {
            miniV = new ImageView(image);
            miniV.setFitHeight(40);
            miniV.setFitWidth(30);
            Imag.getChildren().add(miniV);

            lblTalla.setText(cmbTallaP.getValue());
            lblPrecio.setText(gPrecio.getText());
            lblMarca.setText(gMarca.getText());
            lblGenero.setText(gGenero.getText());
            lblTipo.setText(gTipo.getText());

            contendElemtProductos.add(Imag, 0, 1);
            contendElemtProductos.add(lblMarca, 0, 2);
            contendElemtProductos.add(lblTipo, 1, 0);
            contendElemtProductos.add(lblGenero, 2, 0);
            contendElemtProductos.add(lblTalla, 2, 1);
            contendElemtProductos.add(lblPrecio, 1, 1);
            contendElemtProductos.add(btnComprar, 1, 2);
            contendElemtProductos.add(btnEliminar, 2, 2);

            if (tomarDatosProducto(gMarca, gTipo, gPrecio, gGenero, cmbTallaP)) {
                panelContenCarrito.getChildren().add(contendElemtProductos);
            }
        }
    }

    @FXML
    private void agCarrito(ActionEvent event) {
        if (event.getSource() == btnAggCarritoP && panelFoto.isVisible()) {
            procesarImagen(panelFoto, paneImageMap.get(panelFoto));
        } else if (event.getSource() == btnAggCarritoP && panelFoto1.isVisible()) {
            procesarImagen(panelFoto1, paneImageMap.get(panelFoto1));
        } else if (event.getSource() == btnAggCarritoP && panelFoto2.isVisible()) {
            procesarImagen(panelFoto2, paneImageMap.get(panelFoto2));
        } else if (event.getSource() == btnAggCarritoP && panelFoto3.isVisible()) {
            procesarImagen(panelFoto3, paneImageMap.get(panelFoto3));
        } else if (event.getSource() == btnAggCarritoP && panelFoto4.isVisible()) {
            procesarImagen(panelFoto4, paneImageMap.get(panelFoto4));
        } else if (event.getSource() == btnAggCarritoP && panelFoto5.isVisible()) {
            procesarImagen(panelFoto5, paneImageMap.get(panelFoto5));
        } else if (event.getSource() == btnAggCarritoP && panelFoto6.isVisible()) {
            procesarImagen(panelFoto6, paneImageMap.get(panelFoto6));
        } else if (event.getSource() == btnAggCarritoP && panelFoto7.isVisible()) {
            procesarImagen(panelFoto7, paneImageMap.get(panelFoto7));
        }
    }

}
