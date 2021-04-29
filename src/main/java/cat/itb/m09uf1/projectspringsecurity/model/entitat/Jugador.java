package cat.itb.m09uf1.projectspringsecurity.model.entitat;




import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
public class Jugador {

    @Id
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String country;

    @NotNull
    @NotEmpty
    private String league;

    @NotNull
    @NotEmpty
    private String club;

    @NotNull
    @NotEmpty
    private String position;

    @NotNull
    private int rate;

    public Jugador() {
    }

    public Jugador(String name, String country, String league, String club, String position, int rate) {
        this.name = name;
        this.country = country;
        this.league = league;
        this.club = club;
        this.position = position;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
