/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea;

import java.util.Scanner;

/**
 *
 * @author EdgarRojas
 */
public class Todo {

    /**
     * @param args the command line arguments
     */
    public static void ChauEspacio(String cadena) {
        int i, longitud, aux = 0;
        longitud = cadena.length() - 1;
        String x = " ";
        System.out.println("\ncadena con espacios\n" + cadena);
        System.out.println("\nLa cadena sin espacios en blanco quedaria asi:");
        for (i = 0; i <= longitud; i++) {
            if (x.charAt(0) != cadena.charAt(i)) {
                System.out.print(cadena.charAt(i));
            }
        }
    }
    public static void main(String[] args) {
        ChauEspacio("Anita lava la tina");
    }
}
