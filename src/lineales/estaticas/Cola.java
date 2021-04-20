/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author Escritorio
 */
public class Cola {
    private Object[] arreglo;
    private int frente;
    private int fin;
    private static final int TAMANIO = 10;
    
    public Cola(){
        this.arreglo = new Object[this.TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }
    
    /*
    Pone el elemento al final de la cola. Devuelve verdadero si el elemento 
    se pudo agregar en la estructura y falso en caso contrario.
    */
    
    public boolean poner(Object elemento){
    /*
    Pone el elemento al final de la cola. Devuelve verdadero si el elemento 
    se pudo agregar en la estructura y falso en caso contrario.*/
    
        boolean exito;        
        
        if ((this.fin + 1) == this.frente || this.fin == this.TAMANIO){
            exito = false;
        }
        else {
            exito = true;
            this.arreglo[this.fin] = elemento;
            this.fin = (this.fin + 1) % this.TAMANIO;
        }
        
        return exito;
    }
    
    public boolean sacar(){
        boolean exito = true;
        
        if (this.esVacia()) // la cola esta vacia, reporta error
        {
            exito = false;
        }else
        {
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1)%this.TAMANIO;
        }
        
        return exito;
    }
    
    
    public Object obtenerFrente() {
        // Devuelve el elemento que está en el frente. Precondición: la cola no está vacía.
        Object tipoElemento;

        if (this.frente != this.fin) {
            tipoElemento = arreglo[frente];
        } else {
            tipoElemento = null;
        }

        return tipoElemento;
    }
    
    public boolean esVacia() {
        boolean exito = true;
        
        if (this.frente != this.fin) {
            exito = false;
        }

        return exito;
    }
    
    public void vaciar(){
        // Saca todos los elementos de la estructura.
        this.frente = 0;
        this.fin=0;
    }
    
    public String toString(){
//Devuelve una cadena de caracteres formada por todos los elementos de la pila para poder mostrarla
//por pantalla. Es recomendable utilizar este método únicamente en la etapa de prueba y luego comentar el código 
    
        int i;
        String cadena = "";
        int inicio = this.frente;
        
        if (inicio == this.fin) {
            cadena = "Cola vacia";
        } else {
            cadena = "[";

            while(inicio != this.fin){
                cadena += this.arreglo[inicio] + ", ";
                inicio = (inicio +1) % this.TAMANIO;
            }
            /*
            for (i = 0; i < this.TAMANIO; i++) {
                if (i == 0) {
                    cadena += arreglo[i];
                } else {
                    cadena += "," + arreglo[i];
                }
            }*/
            cadena += "\b\b]";
        }
        return cadena;
    }
    
    public Cola clone(){
        
        Cola clonCola = new Cola();
        clonCola.fin = this.fin;
        clonCola.frente = this.frente;
        int i;
    
    for (i = 0; i< this.TAMANIO; i++){
        clonCola.arreglo[i] = this.arreglo[i];
    }
    
    return clonCola;
    }
}
