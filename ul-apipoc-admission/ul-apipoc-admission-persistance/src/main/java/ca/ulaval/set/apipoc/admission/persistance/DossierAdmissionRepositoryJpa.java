package ca.ulaval.set.apipoc.admission.persistance;

import ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.DossierAdmissionEntiteRepo;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.DossierAdmissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DossierAdmissionRepositoryJpa implements DossierAdmissionRepository {

    private final EntityManager em;

    @Override
    public Optional<DossierAdmissionEntiteRepo> get(UUID idDossierAdmission) {
        DossierAdmissionEntiteRepo dossierAdmissionEntiteRepo =
                this.em.find(DossierAdmissionEntiteRepo.class, idDossierAdmission);
        return Optional.ofNullable(dossierAdmissionEntiteRepo);
    }

    @Override
    public void persist(DossierAdmissionEntiteRepo dossierAdmissionEntiteRepo) {
        this.em.persist(dossierAdmissionEntiteRepo);
    }
}
