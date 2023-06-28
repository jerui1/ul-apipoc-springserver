package ca.ulaval.set.apipoc.admission.application.out.repository.etablissementEnseignement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.UUID;

import static ca.ulaval.set.apipoc.admission.application.out.repository.etablissementEnseignement.EtablissementEnseignementEntiteDomaine_Constraints.*;


@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "idEtablissementEnseignement")
public class EtablissementEnseignementEntiteRepo {

    private UUID idEtablissementEnseignement;

    @ValidCodePays
    private String codePays;

    @ValidNomEtablissementEnseignement
    private String nomEtablissementEnseignement;

}
