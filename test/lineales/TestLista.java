/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;
import lineales.dinamicas.Lista;
/**
 *
 * @author Escritorio
 */
public class TestLista {
    public static void main(String[] arg){       
        
        Lista l1, l2;
        l1 = new Lista();
        
        System.out.println("Es vacia?: " + l1.esVacia());
        System.out.println("Inserta cero, en posicion 0: " + l1.insertar("cero", 0));
        System.out.println("Inserta uno, en posicion 1: " + l1.insertar("uno", 1));
        System.out.println("Inserta dos, en posicion 2: " + l1.insertar("dos", 2));        
        System.out.println("Inserta tres, en posicion 3: " + l1.insertar("tres", 3));
        System.out.println("Inserta dos, en posicion 4: " + l1.insertar("dos", 4));
        //System.out.println("Inserta cinco, en posicion 5: " + l1.insertar("cinco", 5));
        //System.out.println("Inserta ocho, en posicion 2: " + l1.insertar("ocho", 2));
        System.out.println("");
        System.out.println("Quedaron:");
        
        
        System.out.println("Elemento en posicion 0: " + l1.recuperar(0));
        System.out.println("Elemento en posicion 1: " + l1.recuperar(1));
        System.out.println("Elemento en posicion 2: " + l1.recuperar(2));        
        System.out.println("Elemento en posicion 3: " + l1.recuperar(3));
        System.out.println("Elemento en posicion 4: " + l1.recuperar(4));
        //System.out.println("Elemento en posicion 5: " + l1.recuperar(5));
        //System.out.println("Elemento en posicion 6: " + l1.recuperar(6));
        System.out.println("");
        
        System.out.println("L1: toString: "+l1.toString());
        
        l2 = l1.clone();
        //l1.vaciar();
        System.out.println("L1: toString: "+l1.toString());
        System.out.println("L2: toString: "+l2.toString());
        System.out.println("Inserta seis, en posicion 3: " + l2.insertar("seis", 3));
        System.out.println("L1: Largo: " + l1.longitud());
        System.out.println("L2: Largo: " + l2.longitud());
        System.out.println("L2: Elemento en posicion 1: " + l2.recuperar(1));
        //System.out.println("L1: toString: "+l1.toString());
        
        /*
        Copia modificada espera [7,2,9,3]: 		--> [7,2,9,3]
        Inserta 6,3 espera true: 			ERROR
        
        */
        
       /* System.out.println("Elimina elemento en posicion 0: " + l1.eliminar(0));
        System.out.println("Elemento en posicion 1: " + l1.recuperar(1));        
        System.out.println("Elimina elemento en posicion 1: " + l1.eliminar(1));
        System.out.println("Elimina elemento en posicion 6: " + l1.eliminar(6));
        System.out.println("Es vacia?: " + l1.esVacia());
       
        System.out.println("Elemento en posicion 0: " + l1.recuperar(0));
        System.out.println("Elemento en posicion 1: " + l1.recuperar(1));
        System.out.println("Elemento en posicion 2: " + l1.recuperar(2));        
        System.out.println("Elemento en posicion 3: " + l1.recuperar(3));
        System.out.println("Elemento en posicion 4: " + l1.recuperar(4));
        System.out.println("Elemento en posicion 5: " + l1.recuperar(5));
        System.out.println("Elemento en posicion 6: " + l1.recuperar(6));
        
       System.out.println("Localizar uno en posicion: " + l1.localizar("uno"));
       System.out.println("Localizar dos en posicion: " + l1.localizar("dos"));
       System.out.println("Localizar seis en posicion: " + l1.localizar("seis"));
       System.out.println("Localizar cinco en posicion: " + l1.localizar("cinco"));
       System.out.println("");
            
       System.out.println("Clona la Lista");
       l2 = l1.clone();
       System.out.println("Vacia lista L1");
       //l1.vaciar();
       System.out.println("L1: Localizar uno, en posicion: " + l1.localizar("uno"));
       System.out.println("L2: Localizar cinco, en posicion: " + l2.localizar("cinco"));
       System.out.println("L1: Elemento en posicion 4: " + l1.recuperar(4));
       System.out.println("L2: Elemento en posicion 4: " + l2.recuperar(4));
       
       System.out.println("\nL2: Es vacia?: " + l2.esVacia());
       
       System.out.println("L1: toString: "+l1.toString());
       System.out.println("Elimina elemento en posicion 1: " + l1.eliminar(1));
       System.out.println("L1: toString: "+l1.toString());
       System.out.println("L2: toString: "+l2.toString());
          */    
    }
}
