package Ejercicio3;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author edgar
 */
public class Mayor {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lectura = new Scanner(System.in);
        int[] lista = new int[6];
        for (int i = 0; i < lista.length - 1; i++) {
            lista[i] = lectura.nextInt();
        }
        Arrays.sort(lista);
        System.out.println(lista[lista.length - 1]);
    }
}
