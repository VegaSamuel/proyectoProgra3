/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 
 */
public class validadores {
    
    public static boolean validarNombre(String nombre) {
        Pattern pattern = Pattern.compile("^(?!.*\\s{2,})(?!.*\\d)(?!.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{1,20}$");
        Matcher matcher = pattern.matcher(nombre);
        return matcher.matches();
    }
    
    public static boolean validarContrasena(String contrasena) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]{4,8}$");
        Matcher matcher = pattern.matcher(contrasena);
        return matcher.matches();
    }
    
    public static boolean validarCorreo(String correo) {
        // Patrón para validar un correo electrónico
        String patronCorreo = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(patronCorreo);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
    
    public static boolean validarUsuario(String usuario) {
        Pattern pattern = Pattern.compile("^(?!.*\\s{2,}).{4,16}$");
        Matcher matcher = pattern.matcher(usuario);
        return matcher.matches();
    }
    
}
