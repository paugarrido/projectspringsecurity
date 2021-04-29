package cat.itb.m09uf1.projectspringsecurity.model.repositori;

import cat.itb.m09uf1.projectspringsecurity.model.entitat.Usuari;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriUsuari extends CrudRepository<Usuari, String> {
}
