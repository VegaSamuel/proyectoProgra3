/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import back.Juego;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author ruben
 */
public class Fondo {
    private Juego juego;
    private String dir;
    private int x;
    private int y;
    private int level;
    private String[] dirs = {"/Multimedia/Fondo1.jpg", 
                             "/Multimedia/Fondo2.jpg",
                             "/Multimedia/Fondo3.jpg",
                             "/Multimedia/Fondo4.jpg"};
    
    public Fondo(Juego juego) {
        this.juego = juego;
        this.level = 0;
        this.x = 0;
        this.y = 0;
        this.dir = dirs[0];
    }

    public void dibujar(Graphics2D g) {
        ImageIcon image = new ImageIcon(getClass().getResource(this.dir));
        g.drawImage(image.getImage(), getX(), getY(), 1920, 1080, null);
    }

    public void cambiarFondo() {
        if(juego.getJugador().getX() > 1900) {
            if((level+1) < dirs.length) {
                level++;
                ponerFondo(level);
                ajustarFondo();
                juego.getJugador().setX(-150);
                if(juego.getNina().estaSiguiendo()) {
                    juego.getNina().setX(-110);
                }else {
                    juego.getNina().setX(-100);
                }
            }
        }else if(juego.getJugador().getX() < -150) {
            if((level-1) >= 0) {
                level--;
                ponerFondo(level);
                ajustarFondo();
                juego.getJugador().setX(1900);
                juego.getNina().setX(1890);
            }
        }
    }
    
    private void ajustarFondo() {
        switch(level) {
            case 0:
                setY(0);
                break;
            case 1:
                setY(-70);
                break;
            case 2:
                setY(-80);
                break;
            case 3:
                setY(-60);
                break;
        }
    }
    
    private void ponerFondo(int x) {
        this.dir = dirs[x];
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
