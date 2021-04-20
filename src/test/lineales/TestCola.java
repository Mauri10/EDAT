/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;
import lineales.dinamicas.Cola;
/**
 *
 * @author Escritorio
 */
public class TestCola {
    
    
    public static void main(String[] arg){
        
    Cola cola1 = new Cola();
    Cola cola2 = new Cola();
    System.out.println("toString: " + cola1.toString());
    System.out.println(cola1.poner("tres")+ " tres");
    System.out.println(cola1.poner("uno")+ " uno");
    System.out.println(cola1.poner("dos")+ " dos");
    cola2 = cola1.clone();
    System.out.println("toString: " + cola1.toString());
    System.out.println("Quita un valor: "+cola1.sacar());   
    System.out.println("toString: " + cola1.toString());
    System.out.println("toString Clon: " + cola2.toString());
    

    
    
/*System.out.println("toString: " + cola1.toString());
    
    System.out.println("\nSe vacia");
    cola1.vaciar();
    System.out.println("toString: " + cola1.toString());
    
    System.out.println("\nEs vacia?: " + cola1.esVacia());
    System.out.println("Saca en vacio?: "+cola1.sacar());    
    
    System.out.println();
    System.out.println(cola1.poner("tres")+ " tres");
    System.out.println(cola1.poner("uno")+ " uno");
    System.out.println(cola1.poner("dos")+ " dos");    
    System.out.println(cola1.poner("cuatro")+ " cuatro");
    System.out.println(cola1.poner("cinfo")+ " cinfo");
    System.out.println(cola1.poner("seis")+ " seis");
    System.out.println(cola1.poner("siete")+ " siete");
    System.out.println("Frente: " + cola1.obtenerFrente());
    System.out.println("\nQuita un valor: "+cola1.sacar());    
    System.out.println("\nQuita un valor: "+cola1.sacar());    
    System.out.println(cola1.poner("ocho")+ " ocho");
    System.out.println(cola1.poner("nueve")+ " nueve");
    System.out.println(cola1.poner("diez")+ " diez");
    System.out.println(cola1.poner("once")+ " once");
    System.out.println(cola1.poner("doce")+ " doce");
    System.out.println("\nQuita un valor: "+cola1.sacar());  
    System.out.println(cola1.poner("trece")+ " trece");
    
    
    System.out.println("\nFrente: " + cola1.obtenerFrente());
    System.out.println("toString: " + cola1.toString());
    
    
    Cola cola2 = new Cola();
    cola2 = cola1.clone();
    System.out.println("CLooon");
    System.out.println("\ntoString Clon: " + cola2.toString());
    System.out.println("Frente Clon: " + cola2.obtenerFrente());
    
    System.out.println("\nSe vacia cola Original");
    cola1.vaciar();
    
    System.out.println("\ntoString: " + cola1.toString());
    System.out.println("toString Clon: " + cola2.toString());
    
    
    System.out.println("\nFrente cola Original: " + cola1.obtenerFrente());
    System.out.println("Frente cola Clon: " + cola2.obtenerFrente());
*/
}
    
}
