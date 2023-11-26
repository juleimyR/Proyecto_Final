package Models.EstructuraDeDatos;

import Models.Nodos.Nodo_Cliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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

    public Nodo_Cliente getUltimo() {

        if (cabC == null) {
            return null;
        } else {
            Nodo_Cliente q = cabC;
            while (q.getSig() != null) {
                q = q.getSig();
            }
            return q;
        }
    }

    public Nodo_Cliente getCrearClient(TextField txtNombre, TextField txtEmail, TextField txtCell, TextField txtGen, PasswordField txtPassword) {

        Nodo_Cliente buscar = BuscarEmail(txtEmail.getText());

        try {

            if (buscar != null) {
                Alert(Alert.AlertType.WARNING, "Importante..!",
                        "Ya existe un cliente con este correo");
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

    public void addClient(String nom, String email, String celular, String gen, String clave) {

        Nodo_Cliente ch = new Nodo_Cliente(nom, email, celular, clave, gen);
        if (ch != null) {
            if (cabC == null) {
                cabC = ch;
                nClientes++;
            } else {
                Nodo_Cliente ultimo = getUltimo();
                ultimo.setSig(ch);
                ch.setAnt(ultimo);
                nClientes++;
            }
        }
    }

    public void addClientInicio(TextField txtNombre, TextField txtEmail, TextField txtCell, TextField txtGen, PasswordField txtPassword) {

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

    public void guardarDatosEnArchivoClient(ListaDobleCliente listaC) {

        String direccion = System.getProperty("user.dir") + "\\src\\ArchivosTXT\\Archivo_Client.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {
            Nodo_Cliente nodoActual = listaC.getCabC();

            while (nodoActual != null) {
                writer.write(nodoActual.getNombre() + ", ");
                writer.write(nodoActual.getEmail() + ", ");
                writer.write(nodoActual.getNumCel() + ", ");
                writer.write(nodoActual.getPasswd() + ", ");
                writer.write(nodoActual.getGen());
                writer.newLine();

                nodoActual = nodoActual.getSig();
            }

            System.out.println("Datos guardados correctamente en el archivo de clientes.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo de clientes: " + e.getMessage());
        }
    }

    public void cargarDatosDesdeArchivoClient() {

        String direccion = System.getProperty("user.dir") + "\\src\\ArchivosTXT\\Archivo_Client.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(", ");

                String nombre = atributos[0];
                String email = atributos[1];
                String celular = atributos[2];
                String clave = atributos[3];
                String genero = atributos[4];

                addClient(nombre, email, celular, genero, clave);
            }

            System.out.println("Datos cargados correctamente desde archivo de clientes.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde el archivo de clientes: " + e.getMessage());
        }
    }
}
