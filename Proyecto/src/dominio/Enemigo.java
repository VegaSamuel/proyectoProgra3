package dominio;

import back.Juego;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author samuel
 */
public class Enemigo extends Posicionable {
    private Juego juego;
    private String dir;
    
    private int vida;
    
    public Enemigo(Juego juego) {
        super(0, 750);
        this.juego = juego;
        this.dir = "/Multimedia/zombieFresh_idle.png";
        
        generarLocacionX();
    }

    @Override
    public void dibujar(Graphics2D g) {
        ImageIcon image = new ImageIcon(getClass().getResource(this.getDir()));
        g.drawImage(image.getImage(), getX(), getY(), 180, 180, null);
    }
    
    private void generarLocacionX() {
        Random random = new Random();
        
        int x = random.nextInt(1921);
        
        setX(x);
    }
    
    private void atacar() {
        setDir("/Multimedia/zombieFresh_attack.png");
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

}
