/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dolares;

import java.util.Scanner;

public class dolares{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bolivianos;
        double res;
        System.out.println("Ingresar monto del dolar");
        bolivianos = sc.nextInt();
        res = bolivianos * 6.96;
        System.out.println( "El resultado es: "+res+" bolivianos" );

    }
}
