package cat.itb.m09uf1.projectspringsecurity.model.entitat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
