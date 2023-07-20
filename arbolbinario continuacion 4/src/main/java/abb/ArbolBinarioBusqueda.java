package abb;

import java.security.spec.ECField;
import java.util.*;

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

            int comparacion = comparar(obj, rsa.getDato());

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

    public void eliminar(E obj){
        try {
            raiz = eliminar(obj, raiz);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private Nodo<E> eliminar(E obj, Nodo<E> rsa) throws Exception {

        if(rsa == null){
            return null;
        }

        int comparacion = comparar(obj, rsa.getDato());
        if(comparacion == 0){

            if(esHoja(rsa)){
                rsa = null;
            }else if(rsa.getIzquierdo() == null){
                rsa = rsa.getDerecho();
            }else if(rsa.getDerecho() == null){
                rsa = rsa.getIzquierdo();
            }else{

                E mayorSI = getMayor(rsa.getIzquierdo());

                rsa.setDato(mayorSI);

                Nodo<E> nuevoRsi = eliminar(mayorSI, rsa.getIzquierdo());
                rsa.setIzquierdo(nuevoRsi);

            }


            return rsa;
        } if(comparacion > 0){
            return eliminar(obj, rsa.getDerecho());
        }else{
            return eliminar(obj, rsa.getIzquierdo());
        }
    }

    private E getMayor(Nodo<E> rsa){
        if(rsa == null){
            return null;
        }

        if(rsa.getDerecho() == null)
            return rsa.getDato();

        return getMayor(rsa.getDerecho());
    }

    public boolean seEncuentra(E obj){

        try {
            return seEncuentra(obj, raiz);

        }catch (Exception e){
            e.printStackTrace();
        }
        return  false;
    }

    private boolean seEncuentra(E obj, Nodo<E> rsa) throws Exception {

        if(rsa == null){
            return false;
        }

        int comparacion = comparar(obj, rsa.getDato());
        if(comparacion == 0){
            return true;
        } if(comparacion > 0){
            return seEncuentra(obj, rsa.getDerecho());
        }else{
            return seEncuentra(obj, rsa.getIzquierdo());
        }
    }

    public List<E> getRecorridoInOrder(){
        List<E> resultado = new ArrayList<>();
        getRecordidoInOrder(resultado, raiz);

        return resultado;
    }

    private void getRecordidoInOrder(List<E> resultado, Nodo<E> rsa){
        if(rsa == null){
            return;
        }
        getRecordidoInOrder(resultado, rsa.getIzquierdo());
        resultado.add(rsa.getDato());
        getRecordidoInOrder(resultado, rsa.getDerecho());
    }

    public List<E> getRecorridoPreOrder(){
        List<E> resultado = new ArrayList<>();
        getRecorridoPreOrder(resultado, raiz);

        return resultado;
    }

    private void getRecorridoPreOrder(List<E> resultado, Nodo<E> rsa){
        if(rsa == null){
            return;
        }
        resultado.add(rsa.getDato());
        getRecorridoPreOrder(resultado, rsa.getIzquierdo());
        getRecorridoPreOrder(resultado, rsa.getDerecho());
    }

    public List<E> getRecorridoPostOrder(){
        List<E> resultado = new ArrayList<>();
        getRecorridoPostOrder(resultado, raiz);

        return resultado;
    }

    private void getRecorridoPostOrder(List<E> resultado, Nodo<E> rsa){
        if(rsa == null){
            return;
        }
        getRecorridoPostOrder(resultado, rsa.getIzquierdo());
        getRecorridoPostOrder(resultado, rsa.getDerecho());
        resultado.add(rsa.getDato());
    }

    public List<E> getRecorridoPorNiveles(){
        List<E> result = new ArrayList<>();
        if(raiz != null){
            Queue<Nodo<E>> cola = new LinkedList<>();
            cola.add(raiz);
            getRecorridoPorNiveles(cola, result);
        }
        return result;
    }

    private void getRecorridoPorNiveles(Queue<Nodo<E>> cola, List<E> result) {

        if(cola.isEmpty()){
            return;
        }

        Nodo<E> nodoQueTocaVisitar = cola.poll();
        if(nodoQueTocaVisitar.getIzquierdo() != null){
            cola.add(nodoQueTocaVisitar.getIzquierdo());
        }
        if(nodoQueTocaVisitar.getDerecho() != null){
            cola.add(nodoQueTocaVisitar.getDerecho());
        }
        result.add(nodoQueTocaVisitar.getDato());
        getRecorridoPorNiveles(cola, result);


    }

    public int getAltura(){
        return getAltura(raiz);
    }

    private int getAltura(Nodo<E> rsa){
        if(rsa == null){
            return 0;
        }

        int alturaSI = getAltura(rsa.getIzquierdo());
        int alturaSD = getAltura(rsa.getDerecho());
        int alturaMayor = Math.max(alturaSD, alturaSI);
        return 1 + alturaMayor;
    }

    private int comparar(E a, E b) throws Exception {
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

    public boolean esHoja(Nodo<E> rsa){
        return (rsa.getDerecho() == null && rsa.getIzquierdo() == null);
    }

}
