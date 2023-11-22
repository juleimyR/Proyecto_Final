package Models.Nodos;

public class Nodo_Administrador {
    
    private String nombre;
    private String email;
    private String numCel;
    private String passwd;
    private String gen;
    private Nodo_Administrador sig, ant;
    
    public Nodo_Administrador(String nombre, String email, String numCel, String passwd, String gen) {
        this.nombre = nombre;
        this.email = email;
        this.numCel = numCel;
        this.passwd = passwd;
        this.gen = gen;
        this.sig = null;
        this.ant = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumCel() {
        return numCel;
    }

    public void setNumCel(String numCel) {
        this.numCel = numCel;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public Nodo_Administrador getSig() {
        return sig;
    }

    public void setSig(Nodo_Administrador sig) {
        this.sig = sig;
    }

    public Nodo_Administrador getAnt() {
        return ant;
    }

    public void setAnt(Nodo_Administrador ant) {
        this.ant = ant;
    }
    
    
}
