package Sevelet;


import modelo.Usuario;
import javax.servlet.http.HttpSession;



public class LoginController {

    
    public String loginForm() {
        return "formulario-login";
    }

   
    public String efetuarLogin(Usuario usuario, HttpSession session) {
        if (usuario.getLogin().equals("pivotto") && usuario.getSenha().equals("a12345")) {
        //if (new JdbcUsuarioDAOImpl().autenticar(usuario)) {
            session.setAttribute("usuarioLogado", usuario);
            return "menu";
        }
        return "redirect:loginForm";
    }

    
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:loginForm";
    }
}
