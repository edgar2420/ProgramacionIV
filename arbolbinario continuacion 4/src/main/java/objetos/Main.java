package objetos;

import abb.ArbolBinarioBusqueda;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Persona p1 = new Persona("Pedro",15);
        Persona p2 = new Persona("Juan", 15);

        Comparator<Persona> comparator = new CompadorPersona();
        //int comparacion = p1.compareTo(p2);
        int comparacion = comparator.compare(p1, p2);

        if(comparacion == 0){
            System.out.println("p1 es igual a la persona 2");
        }else if(comparacion > 0){
            System.out.println("p1 es mayor que persona 2");
        }else{
            System.out.println("p1 es menor a persona 2");
        }

        ArbolBinarioBusqueda<Peso> arbol = new ArbolBinarioBusqueda<>();

        Peso peso1 = new Peso(80, "Lb");
        Peso peso2 = new Peso(90, "Lb");

        arbol.insertar(peso1);
        arbol.insertar(peso2);
    }
}
