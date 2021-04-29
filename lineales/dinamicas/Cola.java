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
public class Cola {

    private Nodo frente;
    private Nodo fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public boolean poner (Object tipoElemento){
        Nodo nuevoNodo = new Nodo(tipoElemento, null);

        if (this.frente == null){ // si es verdadero la cola esta vacia
            this.frente = nuevoNodo;
        }else{      // el nodo fin de la cola va a a puntar a nodoNuevo
            this.fin.setEnlace(nuevoNodo);
        }           // el puntero de fin de cola apunta a nodoNuevo
        this.fin = nuevoNodo;

        return true;
    }

    public boolean sacar(){
        boolean exito = true;
        if (this.frente == null){ // cola vacia, reporta error
            exito = false;
        }else{  // al menos hay un elemento
                // quita el primer elemento y actualiza frente (y fin si queda vacia)
            this.frente = this.frente.getEnlace();
            if (this.frente == null)
                this.fin = null;
        }
        return exito;
    }

    public Object obtenerFrente(){
        Object tipoElemento;

        if (this.frente != null) {
            tipoElemento = this.frente.getElem();
        } else {
            tipoElemento = null;
        }
        return tipoElemento;
    }

    public boolean esVacia(){
        boolean exito = true;

        if (this.frente != null)
            exito = false;

        return exito;
    }

    public void vaciar(){
        this.frente = null;
        this.fin = null;
    }

    public String toString(){
        String s = "";

        if (this.frente == null)
            s = "Cola vacia";
        else {
            Nodo aux = this.frente;
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

    public Cola clone() {

        Cola clonCola = new Cola();

        if (!esVacia()){
            Nodo aux1 = this.frente;
            clonCola.frente = new Nodo(aux1.getElem(), null);
            aux1 = aux1.getEnlace();
            Nodo aux2 = clonCola.frente;

            while(aux1 != null){
                aux2.setEnlace(new Nodo(aux1.getElem(), null));
                aux2 = aux2.getEnlace();
                aux1 =  aux1.getEnlace();
            }

            clonCola.fin = aux2;

        }


        return clonCola;
    }
}
