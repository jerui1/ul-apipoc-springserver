package ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@Setter(AccessLevel.NONE)
@EqualsAndHashCode(exclude = "idDossierAdmission")
public class DossierAdmissionEntiteDomaine {

    @NotNull
    private UUID idDossierAdmission;
    @NotNull
    private String ni;
    @NotNull
    @Valid
    private Collection<EtablissementEnseignementFrequenteEntiteDomaine> etablissementEnseignementFrequentes;

    public static DossierAdmissionEntiteDomaine creer(String ni) {
        return new DossierAdmissionEntiteDomaine(UUID.randomUUID(), ni, Collections.emptyList());
    }

    public List<EtablissementEnseignementFrequenteEntiteDomaine> findEtablissementEnseignementFrequentes(
            @Nullable String codePays) {
        List<EtablissementEnseignementFrequenteEntiteDomaine> list = this.etablissementEnseignementFrequentes.stream()
                .filter(eef -> eef.getEtablissementEnseignement().getCodePays().equalsIgnoreCase(codePays))
                .collect(Collectors.toList());
        return list;
    }
}
