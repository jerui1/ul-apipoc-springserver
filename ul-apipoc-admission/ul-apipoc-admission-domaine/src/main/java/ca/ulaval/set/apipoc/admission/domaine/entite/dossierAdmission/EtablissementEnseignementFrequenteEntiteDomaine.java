package ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission;

import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementEntiteDomaine;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@Data
@AllArgsConstructor
@Setter(AccessLevel.NONE)
@EqualsAndHashCode(exclude = "idEtablissementEnseignementFrequente")
public class EtablissementEnseignementFrequenteEntiteDomaine {

    @Getter(AccessLevel.NONE)
    private final Outillage outillage;

    private final UUID idEtablissementEnseignementFrequente;

    @NotNull
    @Valid
    private EtablissementEnseignementEntiteDomaine etablissementEnseignement;

    @NotNull
    private Integer version;

    static EtablissementEnseignementFrequenteEntiteDomaine creer(
            Outillage outillage, UUID idEtablissementEnseignement) {

        EtablissementEnseignementEntiteDomaine etablissementEnseignementEntiteDomaine = outillage
                .getEtablissementEnseignement(idEtablissementEnseignement)
                .orElseThrow();

        return new EtablissementEnseignementFrequenteEntiteDomaine(
                outillage, UUID.randomUUID(), etablissementEnseignementEntiteDomaine, 1);
    }

    public interface Outillage {
        Optional<EtablissementEnseignementEntiteDomaine> getEtablissementEnseignement(UUID idEtablissementEnseignement);
    }
}
