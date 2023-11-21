package Models;

import java.time.LocalDate;

public class Nodo_Administrador {
    
    private String nombre;
    private String email;
    private String numCel;
    private String passwd;
    private LocalDate fechaNac; 
    private String gen;
    Nodo_Administrador sig, ant;
    
    public Nodo_Administrador(String nombre, String email, String numCel, String passwd, LocalDate fechaNac, String gen) {
        this.nombre = nombre;
        this.email = email;
        this.numCel = numCel;
        this.passwd = passwd;
        this.fechaNac = fechaNac;    
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

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }
    
}
