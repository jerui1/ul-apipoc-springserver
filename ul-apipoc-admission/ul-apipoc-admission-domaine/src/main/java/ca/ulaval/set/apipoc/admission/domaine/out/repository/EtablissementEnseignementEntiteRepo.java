package ca.ulaval.set.apipoc.admission.domaine.out.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static ca.ulaval.set.apipoc.admission.domaine.out.repository.EtablissementEnseignementFrequenteEntiteDomaine_Constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtablissementEnseignementEntiteRepo {

    private UUID idEtablissement;

    @ValidCodePays
    private String codePays;

    @ValidLabel
    private String label;

}
