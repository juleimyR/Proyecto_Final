package Models.EstructuraDeDatos;

import Models.Nodos.Nodo_Administrador;
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

public class ListaDobleAdmin {

    private Nodo_Administrador cabA;
    private int nAdmins;

    public ListaDobleAdmin() {
        this.cabA = null;
        nAdmins = 0;
    }

    public Nodo_Administrador getCabA() {
        return cabA;
    }

    public void setCabA(Nodo_Administrador cabA) {
        this.cabA = cabA;
    }

    public int getnAdmins() {
        return nAdmins;
    }

    public void setnAdmins(int nAdmins) {
        this.nAdmins = nAdmins;
    }

    public void Alert(Alert.AlertType alertType, String tit, String mj) {
        Alert a = new Alert(alertType);
        a.setTitle(tit);
        a.setContentText(mj);
        a.showAndWait();
    }

    public Nodo_Administrador BuscarEmail(String email) {
        if (cabA == null) {
            return null;
        } else {
            Nodo_Administrador aux = cabA;
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

    public Nodo_Administrador getUltimo() {

        if (cabA == null) {
            return null;
        } else {
            Nodo_Administrador q = cabA;
            while (q.getSig() != null) {
                q = q.getSig();
            }
            return q;
        }
    }

    public Nodo_Administrador getCrearAdmin(TextField txtNombre, TextField txtEmail, TextField txtCell, TextField txtGen, PasswordField txtPassword) {

        Nodo_Administrador buscar = BuscarEmail(txtEmail.getText());

        try {
            if (buscar != null) {
                Alert(Alert.AlertType.WARNING, "Importante..!",
                        "Ya existe un administrador con este correo");
                return null;
            } else {
                Nodo_Administrador nuevoCust = new Nodo_Administrador(txtNombre.getText(), txtEmail.getText(), txtCell.getText(), txtPassword.getText(), txtGen.getText());
                Alert(Alert.AlertType.CONFIRMATION, "Dialogo de confirmación",
                        "Registro realizado con exito...!\n"
                        + "Felicidades...! ya haces parte de nuestros administradores :)");
                txtNombre.setText("");
                txtEmail.setText("");
                txtCell.setText("");
                txtGen.setText("");
                txtPassword.setText("");
                return nuevoCust;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    public void addAdmin(String nom, String email, String celular, String gen, String clave) {

        Nodo_Administrador ch = new Nodo_Administrador(nom, email, celular, clave, gen);
        if (ch != null) {
            if (cabA == null) {
                cabA = ch;
                nAdmins++;
            } else {
                Nodo_Administrador ultimo = getUltimo();
                ultimo.setSig(ch);
                ch.setAnt(ultimo);
                nAdmins++;
            }
        }
    }

    public void addAdminInicio(TextField txtNombre, TextField txtEmail, TextField txtCell, TextField txtGen, PasswordField txtPassword) {

        Nodo_Administrador ch = getCrearAdmin(txtNombre, txtEmail, txtCell, txtGen, txtPassword);
        if (ch != null) {
            if (cabA == null) {
                cabA = ch;
                nAdmins++;
            } else {
                ch.setSig(cabA);
                cabA.setAnt(ch);
                cabA = ch;
                nAdmins++;
            }
        }
    }

    public void guardarDatosEnArchivoAdmin(ListaDobleAdmin listaA) {

        String direccion = System.getProperty("user.dir") + "\\src\\ArchivosTXT\\Archivo_Admin.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {
            Nodo_Administrador nodoActual = listaA.getCabA();

            while (nodoActual != null) {
                writer.write(nodoActual.getNombre() + ", ");
                writer.write(nodoActual.getEmail() + ", ");
                writer.write(nodoActual.getNumCel() + ", ");
                writer.write(nodoActual.getPasswd() + ", ");
                writer.write(nodoActual.getGen());
                writer.newLine();

                nodoActual = nodoActual.getSig();
            }

            System.out.println("Datos guardados correctamente en el archivo de administradores.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo de administradores: " + e.getMessage());
        }
    }

    public void cargarDatosDesdeArchivoAdmin() {

        String direccion = System.getProperty("user.dir") + "\\src\\ArchivosTXT\\Archivo_Admin.txt";

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

                addAdmin(nombre, email, celular, genero, clave);
            }

            System.out.println("Datos cargados correctamente desde archivo de administradores.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde el archivo de administradores: " + e.getMessage());
        }
    }
}
