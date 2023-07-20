/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertir;

/**
 *
 * @author EdgarRojas
 */
public class Invertir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str = "Hola";
        System.out.println(str);
        StringBuilder strb = new StringBuilder(str);
        str = strb.reverse().toString();
        System.out.println(str);
    }
}


