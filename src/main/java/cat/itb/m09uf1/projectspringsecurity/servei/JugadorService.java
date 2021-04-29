package cat.itb.m09uf1.projectspringsecurity.servei;

import cat.itb.m09uf1.projectspringsecurity.model.entitat.Jugador;
import cat.itb.m09uf1.projectspringsecurity.model.entitat.Usuari;
import cat.itb.m09uf1.projectspringsecurity.model.repositori.RepositoriJugador;
import cat.itb.m09uf1.projectspringsecurity.model.repositori.RepositoriUsuari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


@Service
public class JugadorService {

    @Autowired
    private RepositoriJugador repositoriJugador;



    public List<Jugador> llistat(){
        List<Jugador> listaJugadors = new ArrayList<>();
        repositoriJugador.findAll().forEach(jugador -> listaJugadors.add(jugador));
        return listaJugadors;
    }

    @PostConstruct
    public void init(){
        repositoriJugador.save(new Jugador( "Leo Messi", "Argentina", "España", "FC Barcelona", "ED", 92));
        repositoriJugador.save(new Jugador( "Cristiano Ronaldo", "Portugal", "Italia", "Juventus FC", "DC", 92));
        repositoriJugador.save(new Jugador("Neymar JR", "Brasil", "Francia", "PSG FC", "EI", 90));
        repositoriJugador.save(new Jugador("Erling Haaland", "Noruega", "Alemania", "Borussia Dortmund", "DC", 89));
        repositoriJugador.save(new Jugador("Marc Andre Ter Stegen", "Alemania", "España", "FC Barcelona", "POR", 90));
        repositoriJugador.save(new Jugador("David DeGea", "España", "Inglaterra", "Manchester United", "POR", 90));
    }

    // CERCAR PER NAME

    public Jugador searchByName (String name){
        return repositoriJugador.findById(name).orElse(null);

    }

    // AFEGIR JUGADOR

    public void addJugador (Jugador j) {repositoriJugador.save(j);}


    // ELIMINAR JUGADOR PER NAME

    public void removeByName (String name){
        repositoriJugador.deleteById(name);
    }

//     ACTUALITZAR NOM DE JUGADOR

    public void updateName(Jugador j ) {
            repositoriJugador.save(j);
    }

    // ORDENAR PER MITJA

        public void sortByRate() {
            List<Jugador> listaJugadors = new ArrayList<>();
            repositoriJugador.findAll().forEach(jugador -> listaJugadors.add(jugador));
            listaJugadors.sort(Comparator.comparingLong(Jugador::getRate));
        }

}
