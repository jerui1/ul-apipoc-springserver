package ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.UUID;

import static ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementEntiteDomaine_Constraints.*;


@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "idEtablissement")
public class EtablissementEnseignementEntiteRepo {

    private UUID idEtablissement;

    @ValidCodePays
    private String codePays;

    @ValidNomEtablissementEnseignement
    private String nomEtablissementEnseignement;

}
