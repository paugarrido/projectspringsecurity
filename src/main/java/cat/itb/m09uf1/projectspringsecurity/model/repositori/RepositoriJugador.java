package cat.itb.m09uf1.projectspringsecurity.model.repositori;

import cat.itb.m09uf1.projectspringsecurity.model.entitat.Jugador;

import org.springframework.data.repository.CrudRepository;

public interface RepositoriJugador extends CrudRepository<Jugador, String> {
}
