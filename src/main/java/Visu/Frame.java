package Visu;

import abb.ArbolBinarioBusqueda;

import java.awt.*;

import javax.swing.*;


public class Frame extends JFrame {
    ArbolBinarioBusqueda modelo = new ArbolBinarioBusqueda();
    private Panel panel;

    public Frame() {
        init();
    }

    private void init() {
        this.setSize(600, 400);
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem item1 = new JMenuItem("Ingresar Expresion:");
        item1.addActionListener(e -> {
            btn();
        });
        menu.add(item1);
        bar.add(menu);
        panel = new Panel(modelo);
        JScrollPane scroller = new JScrollPane(panel);
        panel.setBackground(new Color(0xFF07074B, true));
        this.getContentPane().add(scroller, BorderLayout.CENTER);

        this.setJMenuBar(bar);
        this.getContentPane().setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // this.pack();
    }

    public void btn() {
        try {
            String expresión = JOptionPane.showInputDialog(null, "Ingrese la expresion:");
            if (expresión == null)
                return;
            String[] lista = expresión.split(" ");
            for (int i = 0; i < lista.length; i++) {
                modelo.insertar(Integer.parseInt(lista[i]));
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Frame frameArbol = new Frame();
            frameArbol.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
