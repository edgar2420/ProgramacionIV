/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio;

import java.util.Scanner;

/**
 *
 * @author EdgarRojas
 */
public class Pro4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Empezamos el programa");

        Scanner entradaEscaner = new Scanner(System.in);
        System.out.println("Por favor introduza las personas:");
        int p = entradaEscaner.nextInt();
        System.out.println("Personas asesinadas:");
        int n = entradaEscaner.nextInt();
        int cont = 0;
        while (cont < p) {
            cont += n;
        }
        cont -= n - 1;

        System.out.println("La persona sobreviviente es: " + cont);
    }

}
