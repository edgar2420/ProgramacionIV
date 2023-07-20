package Visu;

import abb.ArbolBinarioBusqueda;
import abb.Nodo;

import java.awt.*;


public class DibujoArbol implements IDibujo {
    private ArbolBinarioBusqueda modelo;
    public static final int ANCHO_CONTENEDOR = 40;
    public static final int ESPACIO_VERTICAL = 80;
    public static final int ESPACIO_HORIZONTAL = 50;


    public DibujoArbol(ArbolBinarioBusqueda obj) {
        modelo = obj;
    }

    @Override
    public void dibujar(Graphics g) {
        Nodo raiz = modelo.getRaiz();
        dibujarContenedor(raiz, 10, 10, g);
    }

    public void dibujarContenedor(Nodo contenedor, int x, int y, Graphics g) {
        int ancho =getAncho(contenedor);
        int xh = x;
        int yh = y+ESPACIO_VERTICAL;
        int anchoHijo = 0;
        g.setColor(Color.cyan);
        for(Object o : modelo.getRecorridoInOrden())
        g.drawString(String.valueOf(o), x + (ancho / 2)-4, y +(ANCHO_CONTENEDOR / 2)+4);

    }

    private int getAncho(Nodo contenedor) {
        if (contenedor.getDerecho()==null && contenedor.getIzquierdo()==null)
            return ANCHO_CONTENEDOR;
        int result = 0;
        int espacio = 0;
        for (int i=0;i<modelo.taman();i++) {
            result += espacio + i;
            espacio = ESPACIO_HORIZONTAL;
        }
        return result;
    }
}