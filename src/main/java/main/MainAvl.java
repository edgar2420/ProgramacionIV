package main;

import abb.ArbolBinarioBusqueda;
import avl.ArbolBinarioAvl;

import java.util.Arrays;
import java.util.List;

public class MainAvl {


    public static void main(String[] args) {

        ArbolBinarioAvl<Integer> abb = new ArbolBinarioAvl<>();
        abb.insertar(26, 12, 38, 18, 29, 8, 42, 10, 32, 35, 30, 15);

        List<Integer> list = abb.getRecorridoInOrden();
        Integer[] elements = list.toArray(new Integer[0]);

        System.out.println("Recorrido In-Orden");
        System.out.println(Arrays.toString(elements));

        list = abb.getRecorridoPreOrden();
        elements = list.toArray(new Integer[0]);

        System.out.println("Recorrido Pre-Orden");
        System.out.println(Arrays.toString(elements));

        list = abb.getRecorridoPostOrden();
        elements = list.toArray(new Integer[0]);

        System.out.println("Recorrido Post-Orden");
        System.out.println(Arrays.toString(elements));

        list = abb.getRecorridoPorNiveles();
        elements = list.toArray(new Integer[0]);

        System.out.println("Recorrido Por Niveles");
        System.out.println(Arrays.toString(elements));


        list = abb.getRamaMasLarga();
        elements = list.toArray(new Integer[0]);
        System.out.println("Rama mas larga");
        System.out.println(Arrays.toString(elements));

        System.out.println("Peso: " + abb.getPeso());
        System.out.println("Altura: " + abb.getAltura());
    }
}
