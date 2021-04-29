package cat.itb.m09uf1.projectspringsecurity.servei;


import cat.itb.m09uf1.projectspringsecurity.model.entitat.Usuari;
import cat.itb.m09uf1.projectspringsecurity.model.repositori.RepositoriUsuari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UsuariService {

    @Autowired
    private RepositoriUsuari repositoriUsuari;


    // LLISTA USUARIS

    @PostConstruct
    public void init() {
        repositoriUsuari.save(new Usuari("user", passwordEncoder("password"), "password"));
        repositoriUsuari.save(new Usuari("Pau", passwordEncoder("garrido"), "garrido" ));
        repositoriUsuari.save(new Usuari("ADMIN", passwordEncoder("ADMIN"), "ADMIN","ADMIN"));

    }

    // AFEGIR USUARI

    public void addUsuari (Usuari u){
        u.setPassword(passwordEncoder(u.getPassword()));
        repositoriUsuari.save(u);
    }

    // CERCAR PER ID

    public Usuari searchById (String id){
        return repositoriUsuari.findById(id).orElse(null);

    }

    // PASSWORD ENCODER

    public String passwordEncoder(String s) {
        return new BCryptPasswordEncoder().encode(s);
    }
}
