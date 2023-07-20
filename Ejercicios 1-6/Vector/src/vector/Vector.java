/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector;

/**
 *
 * @author EdgarRojas
 */
public class Vector {

    public static void main(String[] args) {
        int[] vector = {52, 74, 9, 14, 23, 20, 1, -1, -45, 0};
        for (int i = vector.length - 1; i >= 0; i--) {
            System.out.print(vector[i] + " ");
        }
    }
}
