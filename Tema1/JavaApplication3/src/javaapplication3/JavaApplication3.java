/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;

import java.io.File;

public class JavaApplication3 {
    private void Lanzador(Integer num1, Integer num2, String file){
        ProcessBuilder pb;
        String clase = ".\\build\\classes\\javaapplication3\\Sumatorio";
        try {
            pb = new ProcessBuilder("java",clase,num1.toString(),num2.toString());
            pb.redirectError(new File("error.txt"));
            pb.directory(new File(".\\build\\classes\\javaapplication3"));
            pb.redirectOutput(new File(file));
            pb.start();
        } catch (Exception e) {
            System.out.println("Error1");
        }
    }
    public static void main(String[] args) {
        JavaApplication3 l = new JavaApplication3();
        l.Lanzador(1, 51,"suma1.txt");
        l.Lanzador(51, 100,"suma2.txt");
        System.out.println(new File(".\\src\\javaapplication3\\Sumatorio.java").exists());
        System.out.println("Ok");
    }
}
