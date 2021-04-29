/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;

import jerarquicas.ArbolBin;
/**
 *
 * @author Escritorio
 */
public class TestArbolBin {
    
    public static void main(String[] arg) {
        
        ArbolBin a1 = new ArbolBin();
        /*System.out.println("Arbol: " + a1.insertar("1", null, 'I'));
        System.out.println("Arbol: " + a1.insertar("2", "1", 'I'));
        System.out.println("Arbol: " + a1.insertar("3", "1", 'D'));
        System.out.println("Arbol: " + a1.insertar("4", "2", 'I'));
        System.out.println("Arbol: " + a1.insertar("5", "2", 'D'));        
        System.out.println("Arbol: " + a1.insertar("6", "3", 'I'));
        System.out.println("Arbol: " + a1.insertar("7", "3", 'D'));
        */
        
        System.out.println("Arbol: " + a1.insertar("A", null, 'I'));
        System.out.println("Arbol: " + a1.insertar("B", "A", 'I'));
        System.out.println("Arbol: " + a1.insertar("C", "A", 'D'));
        System.out.println("Arbol: " + a1.insertar("D", "B", 'I'));
        System.out.println("Arbol: " + a1.insertar("E", "C", 'I'));
        System.out.println("Arbol: " + a1.insertar("F", "C", 'D'));
        System.out.println("Arbol: " + a1.insertar("G", "E", 'I'));
        System.out.println("Arbol: " + a1.insertar("H", "E", 'D'));
        
        System.out.println("Es Vacio?: " +a1.esVacio());
        System.out.println("Padre de 20 es: " + a1.padre("20"));
        
        System.out.println(" PreOrden: "+ a1.listarPreorden());        
        System.out.println(" PosOrden: "+ a1.listarPosorden()); 
        System.out.println(" PorNivel: "+ a1.listarPorNiveles());

        System.out.println("\n InOrden: "+ a1.listarInorden());
    }
    
}
