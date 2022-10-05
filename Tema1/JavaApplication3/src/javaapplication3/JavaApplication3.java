/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;

import java.io.File;

public class JavaApplication3 {
    private void Lanzador(Integer num1, Integer num2, String file){
        ProcessBuilder pb;
        String clase = "C:\\Users\\usuario\\Desktop\\2DAM\\P-S-P\\EjemploThreads\\src\\ejemplothreads\\Sumatorio.java";
        try {
            pb = new ProcessBuilder("java",clase,num1.toString(),num2.toString());
            pb.redirectError(new File("error.txt"));
            pb.redirectOutput(new File(file));
        } catch (Exception e) {
            System.out.println("Error1");
        }
    }
    public static void main(String[] args) {
        
    }
}
