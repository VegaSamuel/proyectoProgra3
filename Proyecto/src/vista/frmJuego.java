package vista;

import back.Juego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author 
 */
public class frmJuego {
    private JFrame frame;
    private Timer timer;

    public frmJuego() {
        frame = new JFrame("Mission Zombie");
        frame.setSize(1920, 1080);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void iniciarJuego() {
        Juego juego = new Juego();
        
        frame.add(juego);
        frame.setVisible(true);
        
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(juego.isJuegoFinalizado()) {
                    JOptionPane.showMessageDialog(frame, "Juego finalizado");
                    frame.dispose();
                    timer.stop();
                }else {
                    juego.getNina().seguirJugador();
                    juego.getFondo().posicionarJugadorCambioFondo();
                    juego.verificarFinJuego();
                    juego.repaint();
                }
            }
        });
        
        timer.start();
    }
    
}
