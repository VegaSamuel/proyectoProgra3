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
                    mostrarCuadroFinJuego(juego);
                    
                    if(juego.sePuedeReiniciar()) {
                        juego.reiniciarJuego();
                    }else {
                        timer.stop();
                        System.exit(0);
                    }
                }else {
                    juego.funcionalidadesJuego();
                    juego.repaint();
                }
            }
        });
        
        timer.start();
    }
    
    private void mostrarCuadroFinJuego(Juego juego) {
        String causa = "";
        
        if(juego.getTipoFinalizacion().equals("FinalSeguro")) {
            causa = "Has terminado el juego, bien hecho!!";
        }else if(juego.getTipoFinalizacion().equals("Asesinado")) {
            causa =  "Te han asesinado :(";
        }
        
        dlgFinJuego dlg;

        dlg = new dlgFinJuego(frame, true, juego, causa);
        dlg.setVisible(true);
            
        return;
    }
    
}
