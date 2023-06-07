package ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement;

import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@AllArgsConstructor
@Setter(AccessLevel.NONE)
@EqualsAndHashCode(exclude = "idEtablissement")
public class EtablissementEnseignementEntiteDomaine {

    private UUID idEtablissement;

    @NotNull
    @Size(min = 2)
    private String nomEtablissementEnseignement;

    @NotNull
    @Size(min = 2, max = 2)
    private String codePays;

    @Size(min = 2, max = 2)
    private String codeProvinceEtat;

    @NotNull
    private Boolean estEtablissementUniversitaire;
}
