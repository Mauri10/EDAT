/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;
/**
 *
 * @author Escritorio
 */
public class MixLineales {
    
    
    public static void main(String[] arg){
                
        
        Cola c1, c2;
        c1 = new Cola();
        
        System.out.println("Poner A: " + c1.poner('A'));
        System.out.println("Poner B: " + c1.poner('B'));
        System.out.println("Poner $: " + c1.poner('$'));
        System.out.println("Poner C: " + c1.poner('C'));
        System.out.println("Poner $: " + c1.poner('$'));
        System.out.println("Poner D: " + c1.poner('D'));
        System.out.println("Poner E: " + c1.poner('E'));
        
        
        
        c2 = generarOtraCola(c1);
        System.out.println("El resultado: ");
        System.out.println(c2.toString());
        
/*implementar el método: generarOtraCola(Cola c1) que recibe por parámetro una estructura de tipo Cola c1 
con elementos de tipo char que tiene el siguiente formato: a1$a2$a3$. . . .$an, 
donde cada ai en una sucesión de letras mayúsculas y a partir de c1 debe generar
como salida otra Cola de la forma: a1a1$a2a2$ . . . .$anan donde cada ai es la 
secuencia de letras de ai invertida. Ejemplo: Si c1 es : AB$C$DEF, la operación 
generarOtraCola devolverá una Cola con el siguiente formato: ABBA$CC$DEFFED
NOTA: Para lograr los tramos invertidos de la Cola de salida debe utilizar una estructura Pila auxiliar*/
    }
    
    public static Cola generarOtraCola(Cola calo) {

        Cola clonCola = calo.clone();
        Pila pilaAux = new Pila();
        Cola aux = new Cola();

        while (!clonCola.esVacia()) {
            while (!clonCola.esVacia() && (char) clonCola.obtenerFrente() != '$') {
                pilaAux.apilar(clonCola.obtenerFrente());
                aux.poner(clonCola.obtenerFrente());
                clonCola.sacar();
            }

            clonCola.sacar();

            while (!pilaAux.esVacia()) {
                aux.poner(pilaAux.obtenerTope());
                pilaAux.desapilar();

            }
            if (!clonCola.esVacia() && (char) clonCola.obtenerFrente() != '$') {
                aux.poner('$');
            }
        }

        return aux;
    }
}
