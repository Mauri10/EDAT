/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;
import lineales.dinamicas.Pila;
/**
 *
 * @author Escritorio
 */
public class TestPila {
    public static void main(String[] arg){
        
        testPila();
    }
        
    public static void testPila(){
        Pila p1 = new Pila();
        
        System.out.println("Apilar 1: "+ p1.apilar(1));
        System.out.println("Apilar 2: "+ p1.apilar(2));
        System.out.println("Apilar 3: "+ p1.apilar(3));        
        System.out.println("Apilar 4: "+ p1.apilar(4));
        System.out.println("Apilar 5: "+ p1.apilar(5));
        System.out.println("Apilar 6: "+ p1.apilar(5));
        System.out.println("Apilar 7: "+ p1.apilar(4));
        System.out.println("Apilar 8: "+ p1.apilar(3));        
        System.out.println("Apilar 9: "+ p1.apilar(2));
        System.out.println("Apilar 10: "+ p1.apilar(1));
                               
        System.out.println("Pila: "+ p1.toString());
        
        System.out.println("Es Capicua?: "+ capicua(p1));  
    }
    
    public static boolean capicua(Pila capi) {
        // Metodo que verifica si una pila es capicua
        boolean exito = true;
        Pila auxPila = new Pila(); // crea una pila axiliar
        Pila capiClon = capi.clone(); // crea una pila clon de la original para 
                                     //  luego ser vaciada en la pila auxiliar

        while (!capiClon.esVacia()) { //verifica que no este vacia
            auxPila.apilar(capiClon.obtenerTope()); // obtiene tope y apila en aux
            capiClon.desapilar(); // desapila de clon
        }

        while (!capi.esVacia() && exito) { // Mientras no este vacia y sea verdadero repite
            if (auxPila.obtenerTope().equals(capi.obtenerTope())) {
                auxPila.desapilar();
                capi.desapilar();
            } else {
                exito = false;
            }
        }

        return exito;
    }
}
