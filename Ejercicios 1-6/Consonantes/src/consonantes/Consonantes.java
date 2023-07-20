/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consonantes;

/**
 *
 * @author EdgarRojas
 */
public class Consonantes {

    public static void main(String[] args) {
        String str = "Let bygones be bygones";
        int vocal = 0;
        int consonante = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char v = str.charAt(i);
            if (v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u') {
                vocal++;
            } else if ((v >= 'a' && v <= 'z')) {
                consonante++;
            }
        }
        System.out.println("Cantidad de Vocales: " + vocal);
        System.out.println("Cantidad de Consonante: " + consonante);
    }
}
