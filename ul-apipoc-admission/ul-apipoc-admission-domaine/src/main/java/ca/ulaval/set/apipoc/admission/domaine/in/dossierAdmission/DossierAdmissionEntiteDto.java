package ca.ulaval.set.apipoc.admission.domaine.in.dossierAdmission;

import static ca.ulaval.set.apipoc.admission.domaine.in.dossierAdmission.DossierAdmissionEntiteDomaine_Constraints.*;

public record DossierAdmissionEntiteDto(
        String idDossierAdmission,
        @ValidNi String ni) {
}
