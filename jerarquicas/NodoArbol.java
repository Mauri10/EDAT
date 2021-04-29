/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;
/**
 * @author Lizarrondo, Juan. FAI-2660
 * @author Bulgubure, Mauricio. FAI-2139
 */
public class NodoArbol {
    
    private Object TipoElemento;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
    // Constructores
    
    public NodoArbol(Object TipoElemento, NodoArbol izquierdo, NodoArbol derecho) {
        this.TipoElemento = TipoElemento;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }
    
    public NodoArbol (Object TipoElemento){
        this.TipoElemento = TipoElemento;
        this.izquierdo = null;
        this.derecho = null;
    }
    // Observadores
    
    public Object getElem() {
        return TipoElemento;
    }

    public NodoArbol getIzquierdo() {
        return izquierdo;
    }

    public NodoArbol getDerecho() {
        return derecho;
    }
    
    // Modificadores
    
    public void setTipoElemento(Object TipoElemento){
        this.TipoElemento = TipoElemento;
    }
    
    public void setIzquierdo(NodoArbol izquierdo){
        this.izquierdo = izquierdo;
    }
    
    public void setDerecho(NodoArbol derecho){
        this.derecho = derecho;
    }
}
