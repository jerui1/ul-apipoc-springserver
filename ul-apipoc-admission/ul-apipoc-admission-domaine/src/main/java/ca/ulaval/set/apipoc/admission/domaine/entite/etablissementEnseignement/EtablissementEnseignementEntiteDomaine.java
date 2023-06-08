package ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@AllArgsConstructor
@Setter(AccessLevel.NONE)
@EqualsAndHashCode(exclude = "idEtablissementEnseignement")
public class EtablissementEnseignementEntiteDomaine {

    private UUID idEtablissementEnseignement;

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

    public static EtablissementEnseignementEntiteDomaine creer(String nomEtablissementEnseignement, String codePays) {
        EtablissementEnseignementEntiteDomaine nouvelEtablissementEnseignement =
                new EtablissementEnseignementEntiteDomaine(
                        UUID.randomUUID(), nomEtablissementEnseignement, codePays, null, true);
        return nouvelEtablissementEnseignement;
    }
}
