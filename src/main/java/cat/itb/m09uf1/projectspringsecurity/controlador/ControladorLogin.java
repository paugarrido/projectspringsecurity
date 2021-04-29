package cat.itb.m09uf1.projectspringsecurity.controlador;

import cat.itb.m09uf1.projectspringsecurity.model.entitat.Jugador;
import cat.itb.m09uf1.projectspringsecurity.model.entitat.Usuari;
import cat.itb.m09uf1.projectspringsecurity.servei.JugadorService;
import cat.itb.m09uf1.projectspringsecurity.servei.UsuariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Controller
public class ControladorLogin {

    @Autowired
    private UsuariService usuariService;

    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model m) {
        m.addAttribute("usuari", new Usuari());
        return "register";
    }

    @PostMapping("/registration")
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String afegirSubmit(@ModelAttribute("usuari") Usuari u){
        u.setRol("USER");
        usuariService.addUsuari(u);
        return "redirect:/";
    }


}
