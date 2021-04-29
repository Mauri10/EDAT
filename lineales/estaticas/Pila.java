/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;
/**
 * @author Lizarrondo, Juan. FAI-2660
 * @author Bulgubure, Mauricio. FAI-2139
 */
public class Pila {

private Object[] arreglo;
private int tope;
private static final int TAMANIO = 10;
    
public Pila(){
    this.arreglo = new Object[TAMANIO];
    this.tope = -1;
}

public boolean apilar(Object nuevoElem){
/* Pone el elemento nuevoElem en el tope de la pila. Devuelve verdadero si el 
elemento se pudo apilar y falso en caso contrario.*/

    boolean exito;
    
    if (this.tope+1 >= this.TAMANIO)
        // Error: pila llena
        exito = false;
    else{
        // pone el elemento en el tope de la pila e inctrementa tope
        this.tope++;
        this.arreglo[tope]=nuevoElem;
        exito = true;
}
    return exito;
}

public boolean desapilar(){
    /* Saca el elemento del tope de la pila. Devuelve verdadero si la pila no estaba 
vacía al momento de desapilar (es decir que se pudo desapilar) y falso en caso contrario.*/
    
    boolean exito;
    
    if (this.tope<=-1)
        // Error: pila vacia
        exito = false;
    else{
        // desapila el elemento y decrementa tope
        this.arreglo[tope]=null;
        this.tope--;
        exito = true;
    }
    return exito;
}


public Object obtenerTope(){
// Devuelve el elemento en el tope de la pila. Precondición: la pila no está vacía.

    Object elem;
    if (this.tope > -1)
        elem = arreglo[tope];
    else
        elem = null;
    return elem;
}

public boolean esVacia(){
 // Devuelve verdadero si la pila no tiene elementos y falso en caso contrario.

    return (this.tope == -1);
}


public void vaciar(){
  // Saca todos los elementos de la pila.
  this.tope =  -1;
}


public Pila clone(){
/* Devuelve una copia exacta de los datos en la estructura original, y respetando el orden de los mismos,
en otra estructura del mismo tipo */
    
    Pila clonPila = new Pila();
    clonPila.tope = this.tope;
    int i;
    
    for (i = 0; i<= this.tope; i++){
        clonPila.arreglo[i] = this.arreglo[i];
    }
    
    return clonPila;
}

    public String toString() {
//Devuelve una cadena de caracteres formada por todos los elementos de la pila para poder mostrarla
//por pantalla. Es recomendable utilizar este método únicamente en la etapa de prueba y luego comentar el código 

        int i;
        String cadena = "";
        if (this.tope != -1) {
            for (i = 0; i <= this.tope; i++) {
                cadena = cadena + " " + arreglo[i];
            }
        } else {
            cadena = "Pila vacia";
        }
        return cadena;
}
}
