package cat.itb.m09uf1.projectspringsecurity.servei;

import cat.itb.m09uf1.projectspringsecurity.model.entitat.Usuari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuariDetallsService implements org.springframework.security.core.userdetails.UserDetailsService{

    @Autowired
    private UsuariService usuariService;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Usuari u= usuariService.searchById(id);
        User.UserBuilder builder = null;

        if(u != null){
            builder=User.withUsername(id);
            builder.disabled(false);
            builder.password(u.getPassword());
            builder.roles(u.getRol());
        }
        else throw new UsernameNotFoundException("User doesn't found!");

        return builder.build();
    }
}
