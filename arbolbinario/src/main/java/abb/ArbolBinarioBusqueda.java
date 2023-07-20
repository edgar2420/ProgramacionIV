package abb;

import java.util.Comparator;

public class ArbolBinarioBusqueda<E> {

    private Comparator<E> comparator;
    private Nodo<E> raiz;

    public ArbolBinarioBusqueda(Comparator<E> comparator) {
        this.comparator = comparator;
        this.raiz = null;
    }

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    public void insertar(E obj){
        try {
            raiz = insertar(obj, raiz);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private Nodo<E> insertar(E obj, Nodo<E> rsa) throws Exception{
        if(rsa == null){
            rsa = new Nodo<>(obj);
        }else{

            int comparacion = comparacion(obj, rsa.getDato());

            if(comparacion == 0){ //obj == rsa.getDato()
                //No hago nada
                return rsa;
            }else if(comparacion > 0){ //obj > rsa.getDato()
                //Trato de insertar por la derecha

                Nodo<E> insertado = insertar(obj, rsa.getDerecho());
                rsa.setDerecho(insertado);

            }else{ //obj < rsa.getDato()
                //Trato de insertar por la izquierda

                Nodo<E> insertado = insertar(obj, rsa.getIzquierdo());
                rsa.setIzquierdo(insertado);
            }

        }

        return rsa;
    }


    private int comparacion(E a, E b) throws Exception {
        if(comparator != null){
            return comparator.compare(a, b);
        }

        if(a instanceof Comparable && b instanceof Comparable){
            Comparable c1 = (Comparable<E>) a;
            Comparable c2 = (Comparable<E>) b;
            return c1.compareTo(c2);
        }

        throw new Exception("Los objetos no pueden ser comparados");
    }

}
