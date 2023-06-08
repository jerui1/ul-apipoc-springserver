package ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@Setter(AccessLevel.NONE)
@EqualsAndHashCode(exclude = "idDossierAdmission")
public class DossierAdmissionEntiteDomaine {

    @Getter(AccessLevel.NONE)
    private final Outillage outillage;

    @NotNull
    private UUID idDossierAdmission;

    @NotNull
    private String ni;

    @NotNull
    @Valid
    private Collection<EtablissementEnseignementFrequenteEntiteDomaine> etablissementEnseignementFrequentes;

    public List<EtablissementEnseignementFrequenteEntiteDomaine> findEtablissementEnseignementFrequentes(
            @Nullable String codePays) {
        List<EtablissementEnseignementFrequenteEntiteDomaine> list = this.etablissementEnseignementFrequentes.stream()
                .filter(eef -> eef.getEtablissementEnseignement().getCodePays().equalsIgnoreCase(codePays))
                .collect(Collectors.toList());
        return list;
    }

    public EtablissementEnseignementFrequenteEntiteDomaine ajouterEtablissementEnseignementFrequente(
            UUID idEtablissementEnseignementFrequente) {

        EtablissementEnseignementFrequenteEntiteDomaine nouvelEtablissementEnseignementFrequente =
                EtablissementEnseignementFrequenteEntiteDomaine.creer(
                        this.outillage.getOutillageEtablissementEnseignementFrequente(), idEtablissementEnseignementFrequente);
        this.etablissementEnseignementFrequentes.add(nouvelEtablissementEnseignementFrequente);
        return nouvelEtablissementEnseignementFrequente;
    }

    public void persister() {
        this.outillage.persist(this);
    }

    public interface Outillage {
        EtablissementEnseignementFrequenteEntiteDomaine.Outillage getOutillageEtablissementEnseignementFrequente();

        void persist(DossierAdmissionEntiteDomaine dossierAdmissionEntiteDomaine);
    }
}
