/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario;

/**
 *
 * @author Dell
 */
public class login {
    
    
    public boolean validarUsuario(String usuario, String contraseña)
    {
        boolean usuarioValidado = false;
                
        if(("INVITADO").equals(usuario) && ("2024").equals(contraseña))
        {   usuarioValidado = true;
}                
                return usuarioValidado;
    }

}