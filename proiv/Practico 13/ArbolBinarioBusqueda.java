package abb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public void insertar(E obj) {
        try {
            raiz = insertar(obj, raiz);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Nodo<E> insertar(E obj, Nodo<E> rsa) throws Exception {
        if (rsa == null) {
            rsa = new Nodo<>(obj);
        } else {

            int comparacion = comparacion(obj, rsa.getDato());

            if (comparacion == 0) { //obj == rsa.getDato()
                //No hago nada
                return rsa;
            } else if (comparacion > 0) { //obj > rsa.getDato()
                //Trato de insertar por la derecha

                Nodo<E> insertado = insertar(obj, rsa.getDerecho());
                rsa.setDerecho(insertado);

            } else { //obj < rsa.getDato()
                //Trato de insertar por la izquierda

                Nodo<E> insertado = insertar(obj, rsa.getIzquierdo());
                rsa.setIzquierdo(insertado);
            }

        }

        return rsa;
    }

    public void eliminar(E... objects) throws Exception {
        for (E obj : objects) {
            eliminar(obj);
        }
    }

    public void eliminar(E obj) throws Exception {
        raiz = eliminar(obj, raiz);
    }

    private Nodo<E> eliminar(E obj, Nodo<E> rsa) throws Exception {
        if (rsa == null)
            return rsa;

        int comparacion = comparacion(obj, rsa.getDato());
        if (comparacion == 0) {

            if (esHoja(rsa)) {
                rsa = null;
            } else if (rsa.getIzquierdo() != null && rsa.getDerecho() == null) {
                rsa = rsa.getIzquierdo();
            } else if (rsa.getDerecho() != null && rsa.getIzquierdo() == null) {
                rsa = rsa.getDerecho();
            } else {
                E mayor = getMayor(rsa.getIzquierdo());
                rsa.setDato(mayor);

                Nodo<E> nodo = eliminar(mayor, rsa.getIzquierdo());
                rsa.setIzquierdo(nodo);
            }

        } else if (comparacion > 0) {
            Nodo<E> nodo = eliminar(obj, rsa.getDerecho());
            rsa.setDerecho(nodo);
        } else if (comparacion < 0) {
            Nodo<E> nodo = eliminar(obj, rsa.getIzquierdo());
            rsa.setIzquierdo(nodo);
        }

        return rsa;
    }


    public boolean seEncuentra(E obj) {

        try {
            return seEncuentra(obj, raiz);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean seEncuentra(E obj, Nodo<E> rsa) throws Exception {

        if (rsa == null) {
            return false;
        }

        int comparacion = comparacion(obj, rsa.getDato());
        if (comparacion == 0) {
            return true;
        }
        if (comparacion > 0) {
            return seEncuentra(obj, rsa.getDerecho());
        } else {
            return seEncuentra(obj, rsa.getIzquierdo());
        }
    }

    public List<E> getRecorridoInOrder() {
        List<E> resultado = new ArrayList<>();
        recorridoInOrden(resultado, raiz);

        return resultado;
    }

    private void recorridoInOrden(List<E> resultado, Nodo<E> rsa) {

        if (rsa == null) {
            return;
        }

        recorridoInOrden(resultado, rsa.getIzquierdo());
        resultado.add(rsa.getDato());
        recorridoInOrden(resultado, rsa.getDerecho());

    }

    public List<E> getRecorridoPostOrden() {
        List<E> list = new ArrayList<>();
        getRecorridoPostOrden(raiz, list);
        return list;
    }

    private void getRecorridoPostOrden(Nodo<E> rsa, List<E> list) {
        if (rsa == null) {
            return;
        }

        getRecorridoPostOrden(rsa.getIzquierdo(), list);
        getRecorridoPostOrden(rsa.getDerecho(), list);
        list.add(rsa.getDato());
    }


    private int comparacion(E a, E b) throws Exception {
        if (comparator != null) {
            return comparator.compare(a, b);
        }

        if (a instanceof Comparable && b instanceof Comparable) {
            Comparable c1 = (Comparable<E>) a;
            Comparable c2 = (Comparable<E>) b;
            return c1.compareTo(c2);
        }

        throw new Exception("Los objetos no pueden ser comparados");
    }

    private boolean esHoja(Nodo<E> nodo) {
        return nodo.getIzquierdo() == null && nodo.getDerecho() == null;
    }

    private E getMayor(Nodo<E> rsa) {
        if (rsa.getDerecho() == null) {
            return rsa.getDato();
        }
        return getMayor(rsa.getDerecho());
    }

}
