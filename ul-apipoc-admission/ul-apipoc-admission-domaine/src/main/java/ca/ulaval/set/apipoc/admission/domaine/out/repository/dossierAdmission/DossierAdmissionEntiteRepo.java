package ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Collection;
import java.util.UUID;

import static ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.DossierAdmissionEntiteDomaine_Constraints.*;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(exclude = "idDossierAdmission")
public class DossierAdmissionEntiteRepo {

    @ValidIdDossierAdmission
    private UUID idDossierAdmission;

    @ValidNi
    private String ni;

    @ValidEtablissementEnseignementFrequentes
    private Collection<EtablissementEnseignementFrequenteEntiteRepo> etablissementEnseignementFrequentes;
}
