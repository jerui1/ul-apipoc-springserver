package ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement;

import ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementEntiteRepo;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@AllArgsConstructor
@Setter(AccessLevel.NONE)
@EqualsAndHashCode(exclude = "idEtablissementEnseignement")
public class EtablissementEnseignementEntiteDomaine {

    @Getter(AccessLevel.NONE)
    private final EtablissementEnseignementOutillage outillage;

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

    public void persister() {
        EtablissementEnseignementEntiteRepo entiteRepo =
                this.outillage.getEtablissementEnseignementConvertisseur().toRepo(this);
        this.outillage.getEtablissementEnseignementRepository().persist(entiteRepo);
    }
}
