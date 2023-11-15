/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import back.Juego;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author ruben
 */
public class Fondo extends javax.swing.JPanel {
    
    public Fondo() {}
    // Dimensiones
    int anchoFondo = 1920;
    int altoFondo = 1800;
    // Coordenadas
    static int x1 = 1300;
    static int y1 = 0;
    int x2 = 0;
    int y2 = 0;

    @Override
    public void paint(Graphics pa) {
        ImageIcon fondo = new ImageIcon(getClass().getResource("/Multimedia/Fondo1.jpg"));
        pa.drawImage(fondo.getImage(), x1, y1, anchoFondo, altoFondo, null);
        pa.drawImage(fondo.getImage(), x2, y2, anchoFondo, altoFondo, null);
    }
}
