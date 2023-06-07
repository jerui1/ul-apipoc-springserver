package ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission;

import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionEntiteDomaine;

import java.util.UUID;

public interface DossierAdmissionRepository {
    DossierAdmissionEntiteRepo get(UUID idDossierAdmission);
}
