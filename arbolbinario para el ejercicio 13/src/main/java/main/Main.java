package main;

import abb.ArbolBinarioBusqueda;
import objetos.Peso;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArbolBinarioBusqueda<Integer> arbol = new ArbolBinarioBusqueda<>();

        arbol.insertar(20);
        arbol.insertar(18);
        arbol.insertar(20);
        arbol.insertar(30);
        arbol.insertar(35);

        List<Integer> recorrido = arbol.getRecorridoInOrder();
        System.out.println(Arrays.toString(recorrido.toArray()));

        System.out.println("Se encuentra 5: " + arbol.seEncuentra(5));
        System.out.println("Se encuentra 20: " + arbol.seEncuentra(20));
        System.out.println("Se encuentra 10: " + arbol.seEncuentra(10));
        System.out.println("Se encuentra 30: " + arbol.seEncuentra(30));
        System.out.println("Se encuentra 18: " + arbol.seEncuentra(18));
        System.out.println("Se encuentra 35: " + arbol.seEncuentra(35));
    }
}
