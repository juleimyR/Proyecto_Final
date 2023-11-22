package Models.EstructuraDeDatos;

import Models.Nodos.Nodo_Administrador;
import java.io.BufferedWriter;
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
    
    public Nodo_Administrador getCrearAdmin(TextField txtNombre, TextField txtEmail, TextField txtCell, TextField txtGen, PasswordField txtPassword) {
        Nodo_Administrador buscar = null;
        try {
            buscar = BuscarEmail(txtEmail.getText());
            if (buscar != null) {
                
                return null;
            } else {
                Nodo_Administrador nuevoCust = new Nodo_Administrador(txtNombre.getText(), txtEmail.getText(), txtCell.getText(), txtPassword.getText(), txtGen.getText());
                Alert(Alert.AlertType.CONFIRMATION, "Dialogo de confirmación",
                        "Registro realizado con exito...!\n"
                        + "Felicidades...! ya haces parte de nuestros administradores :)");
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
    
    public void addAdminInicio(TextField txtNombre, TextField txtEmail, TextField txtCell, TextField txtGen, PasswordField txtPassword) {
        
        if (this.BuscarEmail(txtEmail.getText()) != getCabA()) {
            Alert(Alert.AlertType.ERROR, "Importante..!",
                    "Ya existe un administrador con este correo");
            return;
        }
        
        Nodo_Administrador ch = getCrearAdmin(txtNombre, txtEmail, txtCell, txtGen, txtPassword);
        if (ch != null) {
            if (getCabA() == null) {
                setCabA(ch);
                nAdmins++;
                Alert(Alert.AlertType.INFORMATION, "Aviso", "Se ha registrado");
            } else {
                ch.setSig(getCabA());
                getCabA().setAnt(ch);
                setCabA(ch);
                nAdmins++;
                Alert(Alert.AlertType.INFORMATION, "Aviso", "Se ha registrado al inicio");
            }
        }
    }
    
    public boolean validarCuenta(TextField txtEmail, PasswordField txtPass) {
        
        Nodo_Administrador buscar = BuscarEmail(txtEmail.getText());
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
    
    public void guardarDatosEnArchivoBase(ListaDobleAdmin listaA) {
        String nombre = "Archivo_Base.txt";
        Path ubicacion = Paths.get(System.getProperty("user.dir"), nombre);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ubicacion.toFile()))) {
            Nodo_Administrador nodoActual = listaA.getCabA();
            
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
