package dominio;

import back.Juego;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import vista.frmJuego;

/**
 *
 * @author samuel
 */
public class Jugador extends Posicionable {
    private Juego juego;
    private String dir;
    
    private int vida;
    
    public Jugador(Juego juego) {
        super(120, 750);
        this.juego = juego;
        this.vida = 3;
        this.dir = "/Multimedia/zombiePlayer_idle.png";
    }
    
    @Override
    public void dibujar(Graphics2D g) {
        ImageIcon image = new ImageIcon(getClass().getResource(this.getDir()));
        g.drawImage(image.getImage(), getX(), getY(), 180, 180, null);
    }
    
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_A:
                mover(-10);
                setDir("/Multimedia/zombiePlayer_walkLeft.png");
                break;
            case KeyEvent.VK_D:
                mover(10);
                setDir("/Multimedia/zombiePlayer_walkRight.png");
                break;
            case KeyEvent.VK_E:
                atacar();
                break;
        }
    }

    public void perderVida() {
        this.vida -= 1;
    }
    
    public void atacar() {
        setDir("/Multimedia/zombiePlayer_attack.png");
    }

    private void mover(int x) {
        this.setX(getX() + x);
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
}
