package dominio;

import java.awt.Graphics;

/**
 *
 * @author samuel
 */
public abstract class Posicionable {
    private int x, y;
    private int ancho, largo;
    
    public Posicionable(int x, int y, int ancho, int largo) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.largo = largo;
    }
    
    public abstract void dibujar(Graphics g, int x, int y, String dir);

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

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }
    
}
