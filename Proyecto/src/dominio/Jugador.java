package dominio;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author samuel
 */
public class Jugador extends Posicionable {
    private JPanel panel;
    private String dir;
    
    public Jugador(JPanel panel) {
        super(50, 700);
        this.panel = panel;
    }
    
    @Override
    public void dibujar(Graphics g) {
        this.panel.update(g);
        
        ImageIcon image = new ImageIcon(getClass().getResource(dir));
        g.drawImage(image.getImage(), getX(), getY(), 180, 180, panel);
        
        this.setLargo(image.getIconHeight());
        this.setAncho(image.getIconWidth());
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                this.dibujar(this.panel.getGraphics());
                Jugador.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
    
}
