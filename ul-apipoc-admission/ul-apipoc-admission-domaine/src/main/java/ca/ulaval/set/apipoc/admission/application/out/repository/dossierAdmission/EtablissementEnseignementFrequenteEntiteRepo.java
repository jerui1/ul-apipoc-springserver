package ca.ulaval.set.apipoc.admission.application.out.repository.dossierAdmission;

import ca.ulaval.set.apipoc.admission.application.out.repository.etablissementEnseignement.EtablissementEnseignementEntiteRepo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.UUID;

import static ca.ulaval.set.apipoc.admission.application.out.repository.dossierAdmission.EtablissementEnseignementFrequenteEntiteDomaine_Constraints.*;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(exclude = "idEtablissementEnseignementFrequente")
public class EtablissementEnseignementFrequenteEntiteRepo {

    private UUID idEtablissementEnseignementFrequente;

    @ValidEtablissementEnseignement
    private EtablissementEnseignementEntiteRepo etablissementEnseignement;

    @ValidVersion
    private Integer version;
}
