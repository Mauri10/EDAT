/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;
/**
 * @author Lizarrondo, Juan. FAI-2660
 * @author Bulgubure, Mauricio. FAI-2139
 */
public class ArbolBin {
       
    private NodoArbol raiz;    
    
    public ArbolBin(){
        this.raiz = null;
    }
    
    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
    // Inserta elemNuevo como hijo del primer nodo encontrado en preorden
    // igual a elemPadre, como izquierdo (I) o derecho (D), segun
    // lo indique el parametro lugar
    
        boolean exito = true;

        if (this.raiz == null) {
            // si el arbol esta vacio, ponemos el elem nuevo en la raiz
            this.raiz = new NodoArbol(elemNuevo);
        } else {
            // si no esta vacio, se busca el padre
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elemPadre);
            if (nodoPadre != null) {
                if (lugar == 'I' && nodoPadre.getIzquierdo() == null) // si el padre existe y no tiene HI se lo agrega
                {
                    nodoPadre.setIzquierdo(new NodoArbol(elemNuevo));
                } else {
                    if (lugar == 'D' && nodoPadre.getDerecho() == null) // si el padre existe y no tiene HD se lo agrega
                    {
                        nodoPadre.setDerecho(new NodoArbol(elemNuevo));
                    } else // si el padre no existe o ya tiene ese hijo, da error
                    {
                        exito = false;
                    }
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }
    
    private NodoArbol obtenerNodo(NodoArbol n, Object buscado){
        // metodo Privado que busca un elemento y devuelve el nodo que
        // lo contiene. Si no se encuentra buscado devuelve null
        
        NodoArbol resultado = null;
        if (n != null)
            if (n.getElem().equals(buscado))
                // si el buscado es n, lo devuelve
                resultado = n;
            else{
                // no es el buscado: busca primero en el HI
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                // si no lo encuentra en el HI, busca en HD
                if (resultado == null)
                    resultado = obtenerNodo(n.getDerecho(), buscado);
            }
        return resultado;
    }
    
    public boolean esVacio() {
    // Devuelve falso si hay al menos un elemento cargado en el Ã¡rbol
    // y verdadero en caso contrario
        boolean exito = false;
        
        if (this.raiz == null) {
            exito = true;
        }
        return exito;
    }
    
    public void vaciar(){
        this.raiz = null;
    }
    
    public Lista listarPreorden(){
        // retorna una lista con los elementos del arbol en PREORDEN
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }
    
    private void listarPreordenAux(NodoArbol nodo, Lista lis){
        // metodo recursivo PRIVADO porque su parametro es de tipo NodoArbol
        
        if (nodo != null){
            // visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud()+1);
            
            // recorre a sus hijos en preorden
            listarPreordenAux(nodo.getIzquierdo(), lis);
            listarPreordenAux(nodo.getDerecho(), lis);
        }
    }
     
    public Lista listarInorden(){
    // retorna una lista con los elementos del arbol en InORDEN
        Lista lis = new Lista();
        listarInordenAux(this.raiz, lis);
        return lis;
    }
    
    private void listarInordenAux(NodoArbol nodo, Lista lis){
        
        if (nodo != null){
            listarInordenAux(nodo.getIzquierdo(), lis);
            lis.insertar(nodo.getElem(), lis.longitud()+1);
            listarInordenAux(nodo.getDerecho(), lis);
        }
    }
    
    public Lista listarPosorden(){
    // retorna una lista con los elementos del arbol en PosORDEN
        Lista lis = new Lista();
        listarPosordenAux(this.raiz, lis);
        return lis;
    }
    
    private void listarPosordenAux(NodoArbol nodo, Lista lis){
        
        if (nodo != null){
            listarPosordenAux(nodo.getIzquierdo(), lis);
            listarPosordenAux(nodo.getDerecho(), lis);
            lis.insertar(nodo.getElem(), lis.longitud()+1);
        }
    }
    
    public Lista listarPorNiveles() {
        Cola q = new Cola();
        Lista l = new Lista();
        NodoArbol nodoActual;
        int posicion = 1;

        if (!esVacio()) { // si el arbol no esta vacio, pone la raiz en la cola
            q.poner(this.raiz);
        }

        while (!q.esVacia()) {
            nodoActual = (NodoArbol) q.obtenerFrente();
            q.sacar();

            l.insertar(nodoActual.getElem(), posicion);

            if (nodoActual.getIzquierdo() != null) {
                q.poner(nodoActual.getIzquierdo());
            }

            if (nodoActual.getDerecho() != null) {
                q.poner(nodoActual.getDerecho());
            }
            posicion++;
        }
        return l;
    }
    
    public int nivel(Object elem){
        int nivel = -1, aux;
        if(this.raiz != null){
            if (this.raiz.getElem() == elem){
                nivel = 0;
            }
            else{
                aux = nivelAux(this.raiz,elem); 
                if(aux > 0){
                    nivel = aux;   
                }
            }
        }
        return nivel;
    }
    
    private int nivelAux(NodoArbol nodo,Object elem){
        
        if(nodo != null){
            if(nodo.getElem() == elem){
                return 0;
            }
            else{
                return 1 + logica(nivelAux(nodo.getIzquierdo(),elem),nivelAux(nodo.getDerecho(), elem));
            }
        }
        else{
            return -999999999;//como el valor de logica es el mayor de los dos, devolvemos el minimo valor posible
        }
    }
    
    public int altura(){
        if (this.raiz == null){
            return -1;
        }
        else{
            return alturaAux(this.raiz);
        }
        
    }
    
    private int alturaAux(NodoArbol nodo){
        if (nodo != null){ //si el nodo es nulo, retornamos 0
            if ((nodo.getDerecho() != null) || (nodo.getIzquierdo() != null)){ 
               //si cualquiera de los dos hijos existe sumamos 1
               //y y llamamos recursivamente a que verifique sus hijos
                return 1 + logica(alturaAux(nodo.getDerecho()),alturaAux(nodo.getIzquierdo()));
            }
            else{
                return 0;
            }
        }
        else{
            return 0;
        } 
    }
    
    private int logica(int a, int b){
        //este metodo se utiliza para saber la altura del arbol o el nivel, ya que siempre se queda con el valor mas altos
        //por si se da el caso que unas ramas llegen mas abajo que otras, siempre se toman las de mas abajo
        if(a==0 && b==0){
            return 0;
        }
        else{
            if(a<b){
                return b;
            }
            else{
                if(b<a){
                    return a;
                }
                else{
                    return b;//en este caso los valores son iguales por lo que retornamos cualquiera
                }
            }
        }
    } 
     
    public String toString() {
        if(this.raiz != null){
            return imprimir(this.raiz);
        }
        else{
            return "Arbol vacio;";
        }
    }
    
    private String imprimir(NodoArbol nodo) {
        String cadena = "";
        if (nodo != null) {
            cadena = "";
            if (nodo.getDerecho() != null || nodo.getIzquierdo() != null) {
                cadena += "Padre: " + nodo.getElem();
                if (nodo.getIzquierdo() != null) {
                    cadena += " HI: " + nodo.getIzquierdo().getElem();
                } else {
                    cadena += "HI: null ";
                }
                if (nodo.getDerecho() != null) {
                    cadena += " HD: " + nodo.getDerecho().getElem() + "\n";
                } else {
                    cadena += " HD: null \n";
                }
                cadena += imprimir(nodo.getIzquierdo());
                cadena += imprimir(nodo.getDerecho());
            } else {
                cadena += "Hoja:" + nodo.getElem() + "\n";
            }
        }
        else{
            cadena = "";
        }
        return cadena;
    }
    
    public Lista PorNivel() {
        Cola q = new Cola();
        Lista l = new Lista();
        q.poner(this.raiz);
        NodoArbol nodoActual;
        int posicion = 1;

        while (!q.esVacia()) {
            nodoActual = (NodoArbol) q.obtenerFrente();
            q.sacar();

            l.insertar(nodoActual.getElem(), posicion);

            if (nodoActual.getIzquierdo() != null) {
                q.poner(nodoActual.getIzquierdo());
            }

            if (nodoActual.getDerecho() != null) {
                q.poner(nodoActual.getDerecho());
            }
            posicion++;
        }
        return l;
    }
    
    public Object padre(Object buscado) {
        Object resultado = null;
        if(this.raiz != null){ //si la raiz es nula, el arbol es vacio
            if(this.raiz.getElem() == buscado){//si la raiz es el elemento buscado, esta no tiene padre
                resultado = null;
            }
            else{
                //comenzamos la iteracion, con raiz como el nodo hijo y padre null
                resultado = padreAux(this.raiz,null,buscado);
            }
        }
        return resultado;
    }
    
    private Object padreAux(NodoArbol nodoHijo, Object ObjectoPadre, Object elem){
        Object resultado = null;
        //verificamos que el hijo no sea nulo
        if(nodoHijo != null){
            if(nodoHijo.getElem().equals(elem)){
                //si el hijo es el buscado, retornamos el elemento del nodo padre
                resultado = ObjectoPadre;
            }
            else{
                //si no lo encontramos iteramos primero sobre su lado izquierdo
                resultado = padreAux(nodoHijo.getIzquierdo(),nodoHijo.getElem(),elem);
                if(resultado == null){//si no lo encontramos pasamos al lado derecho
                    resultado = padreAux(nodoHijo.getDerecho(),nodoHijo.getElem(),elem);
                }
            }
        }
        return resultado;
    }
    
    public ArbolBin clone(){
        ArbolBin clon = new ArbolBin();
        clon.raiz = cloneAux(this.raiz);
        return clon;    
    }
    
    private NodoArbol cloneAux(NodoArbol nodo){
        NodoArbol nuevo=null;
        if(nodo != null){
            nuevo = new NodoArbol(nodo.getElem(),cloneAux(nodo.getIzquierdo()),cloneAux(nodo.getDerecho()));
        }
        return nuevo;
    }
    
    public Lista frontera(){
        if (this.raiz != null){
            Lista frontera = new Lista();
            //retornar todas las hojas de izquierda a derecha
            fronteraAux(this.raiz,frontera);
            return frontera;
        }
        return new Lista(); //si el arbol tiene raiz nula, retornamos una lista vacia 
    }
    
    private void fronteraAux(NodoArbol nodo,Lista l){
        //en caso de que el nodo tenga hijos, vamos al nodo siguiente
        if(nodo != null){
            if(tieneHijos(nodo)){
                //como los debemos mostrar de izquierda a derecha aplicamos la recursion
                //sobre el izquierdo primero
                fronteraAux(nodo.getIzquierdo(),l);
                fronteraAux(nodo.getDerecho(),l);
            }
            else{//si no tiene hijos, lo agregamos a la lista.
                l.insertar(nodo.getElem(), l.longitud() + 1);
            }
        }
    }
    
    private boolean tieneHijos(NodoArbol nodo){
        //este metodo solo sirve para verificar si un nodo tiene hijos
        if(nodo != null){
            return nodo.getDerecho() != null || nodo.getIzquierdo() != null;
        }
        else{
            return false;
        }
    }
}