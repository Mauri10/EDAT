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
public class Lista {
    
    private Nodo cabecera;
    
    public Lista() {
        this.cabecera = null;
}

    public int longitud(){
        int i = 0;
        Nodo aux = this.cabecera;
        boolean fin=false;

        if (aux == null){//si no tenemos elementos retornamos 0
            return i;
        }
        else{
            while(!fin){//si hay elementos comenzamos a recorrer la Lista
                aux = aux.getEnlace();
                if (aux != null){
                    i++;
                }
                else{
                    i++;
                    fin = true;
                }
            }
        }
        return i;
    }
       
    public boolean insertar(Object nuevoElem, int pos) {
        // inserta el elemento nuevo en la posicion pos
        // detecta y reporta error en poscion invalida
        boolean exito = true;
        int largo =  this.longitud();
        if (pos < 1 || pos > largo + 1) {
            exito = false; // si la posicion es menor a 1 o mayor a longitud +1 no guarda elemento
        } else {
            if (pos == 1) // crea nuevo nodo y se enlaza con la cabecera
            {
                this.cabecera = new Nodo(nuevoElem, this.cabecera);
            } else { // avanza hasta el elemento en posicion pos-1
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                // crea el nodo y lo enlaza
                Nodo nuevo = new Nodo(nuevoElem, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        return exito;
    }
    
    public boolean eliminar(int pos) {
        boolean exito = true;
        int largo =  this.longitud();
       
        if (!esVacia() && (1 <= pos && pos <= largo)) { // verifica si esta vacia y su es menor que el largo
            if (pos == 1 && largo == 1) { // caso si hay un solo elemento
                this.cabecera = null;
            } else if (pos == 1){ // caso si es el primer elemento a eliminar
                this.cabecera = this.cabecera.getEnlace();
            }
            else { // resto de los elementos a eliminar
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
        } else {
            exito = false;
        }
        return exito;
    }

    public boolean esVacia() {
        boolean exito = false;
        if (this.cabecera == null) {
            exito = true;
        }
        return exito;
    }

    public Object recuperar(int pos) {
        // Devuelve el elemento de la posición pos. La precondición es que la posición sea válida.       
        Object elem = null;
        int largo =  this.longitud();
        if (pos > 0 && pos <= largo) {
            Nodo aux = this.cabecera;
            int i = 1;
            while (i < pos ) {
                aux = aux.getEnlace();
                i++;
            }
            elem = aux.getElem();
        }
        return elem;
    }

    public int localizar(Object elem) {
        // Devuelve la posición en la que se encuentra la primera ocurrencia de elem
        // dentro de la lista. En caso de no encontrarlo devuelve -1.
        int largo =  this.longitud();
        int contador = -1;
        if (!esVacia()) {
            Nodo aux = this.cabecera;
            contador = 1;
            while (elem != aux.getElem() && contador <= largo) {
                if (aux.getEnlace() != null) {
                    aux = aux.getEnlace();
                }
                contador++;
            }
            if (elem != aux.getElem()) {
                contador = -1;
            }
        }
        return contador;
    }
        
    public void vaciar() {
        this.cabecera = null;    
    }
    
    
    public Lista clone() {
      
        Lista clonLista = new Lista();
        int largo = this.longitud();
        Nodo aux1, aux2;
        if (!esVacia()){
            
            clonLista.cabecera = new Nodo(this.cabecera.getElem(), null);
            aux1 = this.cabecera;
            aux2 = clonLista.cabecera;
            
            aux1 = aux1.getEnlace();
            
            while(aux1 != null){
                aux2.setEnlace(new Nodo(aux1.getElem(),null));
                aux1 = aux1.getEnlace();
                aux2 = aux2.getEnlace();                                
            }
        }            
        return clonLista;
    }
    
    public String toString(){
        String s = "";
        
        if (this.cabecera == null)
            s = "Lista vacia";
        else {
            Nodo aux = this.cabecera;
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
}