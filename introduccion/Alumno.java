/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introduccion;
/**
 *
 * @author Escritorio
 */
public class Alumno {

    private String legajo;
    private String nombre;
    private String apellido;
    private String tipoDni;
    private int dni;
    private String domicilio;
    private int telefono;
    private String usuario;
    private String clave;

    public Alumno(String leg) {

        legajo = leg;
        nombre = null;
        apellido = null;
        tipoDni = null;
        dni = 0;
        domicilio = null;
        telefono = 0;
        usuario = null;
        clave = null;
    }

    public Alumno(String leg, String nomb, String apel, String tDni,
            int doc, String direccion, int tel, String user, String contrasena) {

        legajo = leg;
        nombre = nomb;
        apellido = apel;
        tipoDni = tDni;
        dni = doc;
        domicilio = direccion;
        telefono = tel;
        usuario = user;
        clave = contrasena;
    }

    //Observadoras
    public String getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTipoDni() {
        return tipoDni;
    }

    public int getDni() {
        return dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public String toString() {
        return "Legajo: " + legajo + ", Nombre: " + nombre
                + ", Apellido: " + apellido + ", Tipo de documento: "
                + tipoDni + ", numero de dni: " + dni + ", domicilio: " + domicilio
                + ", Telefono: " + telefono + ", Usuario: " + usuario;
    }

    public boolean equals(Alumno alumn) {
        return legajo == alumn.getLegajo();
    }

//Modificadores
    public void setNombre(String nomb) {
        nombre = nomb;
    }

    public void setApellido(String apel) {
        apellido = apel;
    }

    public void setTipoDni(String tDni) {
        tipoDni = tDni;
    }

    public void setDni(int doc) {
        dni = doc;
    }

    public void setDni(String direccion) {
        domicilio = direccion;
    }

    public void setUsuario(String user) {
        usuario = user;
    }
}
