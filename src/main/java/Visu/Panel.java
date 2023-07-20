package Visu;

import abb.ArbolBinarioBusqueda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class Panel extends JPanel {

    private ArbolBinarioBusqueda modelo;

    public Panel(ArbolBinarioBusqueda obj) {
        modelo = obj;
    }

    public Dimension getPreferredSize() {
        return new Dimension(10000, 10000);
    }


}