/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> cl1compra = new ArrayList<>();
        cl1compra.add(1);
        cl1compra.add(5);
        cl1compra.add(10);
        Cliente cl1 = new Cliente("Pablo",cl1compra);
        Dependiente dep1 = new Dependiente("Antonio",cl1);
        dep1.start();
    }
}
