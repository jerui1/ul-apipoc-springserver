package ca.ulaval.set.apipoc.admission.application.in.dossierAdmission;


import static ca.ulaval.set.apipoc.admission.application.in.dossierAdmission.DossierAdmissionEntiteDomaine_Constraints.*;

public record DossierAdmissionEntiteDto(
        String idDossierAdmission,
        @ValidNi String ni) {
}
