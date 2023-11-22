package Models.EstructuraDeDatos;

import Models.Nodos.Nodo_Administrador;
import Models.Nodos.Nodo_Cliente;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ListaDobleCliente {

    private Nodo_Cliente cabC;
    private int nClientes;

    public ListaDobleCliente() {
        this.cabC = null;
        this.nClientes = 0;
    }

    public Nodo_Cliente getCabC() {
        return cabC;
    }

    public void setCabC(Nodo_Cliente cabC) {
        this.cabC = cabC;
    }

    public int getnClientes() {
        return nClientes;
    }

    public void setnClientes(int nClientes) {
        this.nClientes = nClientes;
    }

    public void Alert(Alert.AlertType alertType, String tit, String mj) {
        Alert a = new Alert(alertType);
        a.setTitle(tit);
        a.setContentText(mj);
        a.showAndWait();
    }

    public Nodo_Cliente BuscarEmail(String email) {
        if (getCabC() == null) {
            return null;
        } else {
            Nodo_Cliente aux = getCabC();
            while (aux != null) {
                if (aux.getEmail().equals(email)) {
                    return aux;
                } else {
                    aux = aux.getSig();
                }
            }
            return null;
        }
    }

    public Nodo_Cliente getCrearClient(TextField txtNombre, TextField txtEmail, TextField txtCell, TextField txtGen, PasswordField txtPassword) {
        Nodo_Cliente buscar = null;
        try {
            buscar = BuscarEmail(txtEmail.getText());
            if (buscar != null) {

                return null;
            } else {
                Nodo_Cliente nuevoCust = new Nodo_Cliente(txtNombre.getText(), txtEmail.getText(), txtCell.getText(), txtPassword.getText(), txtGen.getText());
                Alert(Alert.AlertType.CONFIRMATION, "Dialogo de confirmación",
                        "Registro realizado con exito...!\n"
                        + "Felicidades...! ya haces parte de nuestros clientes :)");
                txtNombre.setText("");
                txtEmail.setText("");
                txtCell.setText("");
                txtPassword.setText("");
                return nuevoCust;
            }

        } catch (Exception e) {
            return null;
        }

    }

    public void addClientInicio(TextField txtNombre, TextField txtEmail, TextField txtCell, TextField txtGen, PasswordField txtPassword) {

        if (this.BuscarEmail(txtEmail.getText()) != getCabC()) {
            Alert(Alert.AlertType.ERROR, "Importante..!",
                    "Ya existe un administrador con este correo");
            return;
        }

        Nodo_Cliente ch = getCrearClient(txtNombre, txtEmail, txtCell, txtGen, txtPassword);
        if (ch != null) {
            if (getCabC() == null) {
                setCabC(ch);
                nClientes++;
                Alert(Alert.AlertType.INFORMATION, "Aviso", "Se ha registrado");
            } else {
                ch.setSig(getCabC());
                getCabC().setAnt(ch);
                setCabC(ch);
                nClientes++;
                Alert(Alert.AlertType.INFORMATION, "Aviso", "Se ha registrado al inicio");
            }
        }
    }

    public boolean validarCuenta(TextField txtEmail, PasswordField txtPass) {

        Nodo_Cliente buscar = BuscarEmail(txtEmail.getText());
        if (buscar != null) {
            if ((buscar.getPasswd()).equals(txtPass.getText())) {
                System.out.println("contraseña correcta");
                Alert(Alert.AlertType.CONFIRMATION, "Bienvenido", "Simon's le da la binevenida..!");
                return true;
            } else {
                System.out.println("contraseña incorrecta");
                Alert(Alert.AlertType.ERROR, "Aviso", "Contraseña incorrecta");
                txtPass.setText("");
                txtPass.requestFocus();
                return false;
            }
        } else {

            txtEmail.setText("");
            txtPass.setText("");
            txtEmail.requestFocus();
            return false;

        }
    }

    public void guardarDatosEnArchivoBase(ListaDobleCliente listaC) {
        String nombre = "Archivo_Base.txt";
        Path ubicacion = Paths.get(System.getProperty("user.dir"), nombre);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ubicacion.toFile()))) {
            Nodo_Cliente nodoActual = listaC.getCabC();

            while (nodoActual != null) {
                writer.write(nodoActual.getNombre() + ", ");
                writer.write(nodoActual.getEmail() + ", ");
                writer.write(nodoActual.getPasswd() + ", ");
                writer.write(nodoActual.getNumCel() + ", ");
                writer.write(nodoActual.getGen());
                writer.newLine();

                nodoActual = nodoActual.getSig();
            }

            System.out.println("Datos guardados correctamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo: " + e.getMessage());
        }
    }
}
