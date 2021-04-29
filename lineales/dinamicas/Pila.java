/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;
/**
 * @author Lizarrondo, Juan. FAI-2660
 * @author Bulgubure, Mauricio. FAI-2139
 */
public class Pila {
    private Nodo tope;
    
    public Pila(){
        this.tope = null;
    }
    
    public boolean apilar(Object nuevoElem) {

        Nodo nuevo = new Nodo(nuevoElem, this.tope);

        this.tope = nuevo;

        return true;
    }
    
    public boolean desapilar(){
        boolean exito = true;
        if (!esVacia())
            this.tope = this.tope.getEnlace();
        else
            exito = false;
        
        return exito;
    }
    
    public boolean esVacia(){
        boolean exito = false;
        
        if (this.tope == null)
            exito = true;
        
        return exito;
    }
    
    public void vaciar() {
       this.tope = null;
    }
    
    public Object obtenerTope(){
// Devuelve el elemento en el tope de la pila. Precondición: la pila no está vacía.
    Object elem;
    
    if (this.tope != null)
        elem = this.tope.getElem();
    else
        elem = null;
    return elem;
}
    
    public String toString(){
        String s = "";
        
        if (this.tope == null)
            s = "Pila vacia";
        else {
            Nodo aux = this.tope;
            s = "[";
            
            while (aux != null){
                s += aux.getElem().toString();                
                aux = aux.getEnlace();
                if (aux != null)
                    s += ",";
            }
            s += "]";
        }
        return s;
    }
    
    public Pila clone(){
        
        Pila clonPila = new Pila();
        Nodo aux1,aux2, nuevoNodo;
        
        if (this.tope != null){ // Pila no vacia
            aux1 = this.tope.getEnlace(); // Referencia pila "this"
            aux2 = new Nodo(this.tope.getElem(), null); //nuevo nodo con el elemento del tope de la pila "this"
            
            clonPila.tope = aux2; // 
            
            while(aux1 != null){
                nuevoNodo = new Nodo(aux1.getElem(), null);
                aux2.setEnlace(nuevoNodo);
                aux1 = aux1.getEnlace();
                aux2 =  aux2.getEnlace();
            }
        }
        
        return clonPila;
        
    }
}
