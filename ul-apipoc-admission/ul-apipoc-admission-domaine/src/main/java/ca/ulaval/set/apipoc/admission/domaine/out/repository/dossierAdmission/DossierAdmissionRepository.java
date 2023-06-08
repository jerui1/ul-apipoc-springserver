package ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission;

import java.util.Optional;
import java.util.UUID;

public interface DossierAdmissionRepository {
    Optional<DossierAdmissionEntiteRepo> get(UUID idDossierAdmission);

    void persist(DossierAdmissionEntiteRepo dossierAdmissionEntiteRepo);
}
