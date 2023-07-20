package Segundos;

import java.util.Scanner;

/**
 *
 * @author edgar
 */
public class Segundos {

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int segundos = lectura.nextInt();
        int horas = 0;
        int minutos = 0;
        while (segundos >= 3600) {
            segundos = segundos - 3600;
            horas++;
        }
        while (segundos >= 60) {
            segundos -= 60;
            minutos++;
        }
        System.out.println(horas + ":" + minutos + ":" + segundos);
    }
}
