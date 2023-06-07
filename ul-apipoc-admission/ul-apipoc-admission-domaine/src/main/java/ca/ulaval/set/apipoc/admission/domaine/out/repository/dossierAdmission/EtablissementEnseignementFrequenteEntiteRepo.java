package ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission;

import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementEntiteRepo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.UUID;

import static ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.EtablissementEnseignementFrequenteEntiteDomaine_Constraints.ValidEtablissementEnseignement;
import static ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.EtablissementEnseignementFrequenteEntiteDomaine_Constraints.ValidVersion;

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
