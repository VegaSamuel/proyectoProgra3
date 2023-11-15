/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author ruben
 */
public class Fondo extends javax.swing.JPanel {
    
    public Fondo() {
        this.setSize(1920, 1080);
    }

    @Override
    public void paint(Graphics g) {
        Dimension height = getSize();
        
        ImageIcon fondo = new ImageIcon(getClass().getResource("/Multimedia/Fondo1.jpg"));
        
        g.drawImage(fondo.getImage(), 0, 0, height.width, height.height, null);
        
        setOpaque(false);
        super.paintComponent(g);
    }
}
