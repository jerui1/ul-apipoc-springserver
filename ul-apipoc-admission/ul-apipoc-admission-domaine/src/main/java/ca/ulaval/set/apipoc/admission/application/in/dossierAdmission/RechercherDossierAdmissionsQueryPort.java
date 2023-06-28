package ca.ulaval.set.apipoc.admission.application.in.dossierAdmission;

import java.util.List;

public interface RechercherDossierAdmissionsQueryPort {
    List<DossierAdmissionEntiteDto> apply(String ni);
}
