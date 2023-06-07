package ca.ulaval.set.apipoc.admission.domaine.entite;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class EtablissementEnseignementFrequenteEntiteDomaine {

    private UUID idEtablissement;

    @NotNull
    @Size(min = 2, max = 2)
    private String codePays;

    @NotNull
    @Size(min = 2)
    private String label;

}
