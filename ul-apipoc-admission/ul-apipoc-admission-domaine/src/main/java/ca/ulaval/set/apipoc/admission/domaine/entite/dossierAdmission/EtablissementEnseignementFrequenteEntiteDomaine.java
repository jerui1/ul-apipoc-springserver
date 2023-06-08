package ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission;

import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementEntiteRepo;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@Setter(AccessLevel.NONE)
@EqualsAndHashCode(exclude = "idEtablissementEnseignementFrequente")
public class EtablissementEnseignementFrequenteEntiteDomaine {

    @Getter(AccessLevel.NONE)
    private DossierAdmissionOutillage outillage;

    private UUID idEtablissementEnseignementFrequente;

    @NotNull
    @Valid
    private EtablissementEnseignementEntiteDomaine etablissementEnseignement;

    @NotNull
    private Integer version;

    static EtablissementEnseignementFrequenteEntiteDomaine creer(
            DossierAdmissionOutillage outillage, UUID idEtablissementEnseignement) {

        EtablissementEnseignementEntiteDomaine etablissementEnseignementEntiteDomaine = outillage
                .getEtablissementEnseignementRepository()
                .get(idEtablissementEnseignement)
                .map(ee -> outillage.getEtablissementEnseignementConvertisseur().toDomaine(ee))
                .orElseThrow();

        return new EtablissementEnseignementFrequenteEntiteDomaine(
                outillage, UUID.randomUUID(), etablissementEnseignementEntiteDomaine, 1);
    }
}
