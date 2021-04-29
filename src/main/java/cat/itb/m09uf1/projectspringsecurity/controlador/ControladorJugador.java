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
public class ControladorJugador {

    String n;
    @Autowired
    private JugadorService jugadorService;

    @GetMapping("/")
    public String inici(Model m){
        jugadorService.sortByRate();
        m.addAttribute("llistaJugador",jugadorService.llistat());
        m.addAttribute("Jugador",new Jugador());
        return "home";
    }

    // LLISTA JUGADOR

    @GetMapping("/home")
    public String llistarJugador(Model m){
        jugadorService.sortByRate();
        m.addAttribute("llistaJugador",jugadorService.llistat());
        m.addAttribute("Jugador",new Jugador());
        return "home";
    }

    // AFEGIR JUGADOR

    @RequestMapping("/afegir")
    public String afegirJugador(Model m) {
        m.addAttribute("Jugador", new Jugador());
        return "afegirJugador";
    }

    @PostMapping("/afegirJugador")
    public String AfegirJugador(@ModelAttribute("Jugador") Jugador j){
        jugadorService.addJugador(j);
        return "redirect:/";
    }

    // ELIMINAR JUGADOR

    @RequestMapping( value ="/delete/{name}", method = RequestMethod.POST)
    public String removeJugador(@PathVariable("name") String name){
        jugadorService.removeByName(name);
        return "redirect:/";
    }

    // UPDATE JUGADOR

    @RequestMapping( value ="/update/{name}", method = RequestMethod.POST)
    public String updateJugador(@PathVariable("name") String name, Model m){
        n = name;
        m.addAttribute("Jugador",jugadorService.searchByName(name));
        return "/updateJugador";
    }

    @PostMapping("/updateJugador")
    public String updateJugadorpost(@ModelAttribute("Jugador") Jugador j){
        jugadorService.updateName(j);
        return "redirect:/";

    }



}
