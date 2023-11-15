package dominio;

import java.awt.Graphics;
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
        super(100, 50, 0, 0);
        this.panel = panel;
    }
    
    @Override
    public void dibujar(Graphics g, int x, int y, String dir) {
        this.setX(x);
        this.setY(y);
        this.dir = dir;
        this.panel.update(g);
        
        ImageIcon image = new ImageIcon(getClass().getResource(dir));
        g.drawImage(image.getImage(), x, y, panel);
        
        this.setLargo(image.getIconHeight());
        this.setAncho(image.getIconWidth());
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
