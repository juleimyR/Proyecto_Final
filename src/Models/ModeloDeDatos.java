package Models;

import Models.EstructuraDeDatos.ListaDobleAdmin;
import Models.EstructuraDeDatos.ListaDobleCliente;
import Models.EstructuraDeDatos.PilaStack_Producto;

public class ModeloDeDatos {

    private static ModeloDeDatos instancia;
    private final ListaDobleAdmin listaA;
    private final ListaDobleCliente listaC;
    private final PilaStack_Producto pilaP;

    public ModeloDeDatos() {
        listaA = new ListaDobleAdmin();
        listaC = new ListaDobleCliente();
        pilaP = new PilaStack_Producto();
    }

    public static ModeloDeDatos obtenerInstancia() {
        if (instancia == null) {
            instancia = new ModeloDeDatos();
        }
        return instancia;
    }

    public ListaDobleAdmin getListaA() {
        return listaA;
    }

    public ListaDobleCliente getListaC() {
        return listaC;
    }

    public PilaStack_Producto getPilaP() {
        return pilaP;
    }

}
