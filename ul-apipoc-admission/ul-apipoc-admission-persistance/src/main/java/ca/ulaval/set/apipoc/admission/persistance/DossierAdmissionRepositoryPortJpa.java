package ca.ulaval.set.apipoc.admission.persistance;

import ca.ulaval.set.apipoc.admission.application.out.repository.dossierAdmission.DossierAdmissionEntiteRepo;
import ca.ulaval.set.apipoc.admission.application.out.repository.dossierAdmission.DossierAdmissionRepositoryPort;
import ca.ulaval.set.apipoc.admission.application.out.repository.dossierAdmission.EtablissementEnseignementFrequenteEntiteRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class DossierAdmissionRepositoryPortJpa implements DossierAdmissionRepositoryPort {

    private final EntityManager em;

    @Override
    public Optional<DossierAdmissionEntiteRepo> getDossierAdmission(UUID idDossierAdmission) {
        DossierAdmissionEntiteRepo dossierAdmissionEntiteRepo =
                this.em.find(DossierAdmissionEntiteRepo.class, idDossierAdmission);
        return Optional.ofNullable(dossierAdmissionEntiteRepo);
    }

    @Override
    public void persist(DossierAdmissionEntiteRepo dossierAdmissionEntiteRepo) {
        this.em.merge(dossierAdmissionEntiteRepo);
    }

    @Override
    public Stream<DossierAdmissionEntiteRepo> find(String ni) {
        TypedQuery<DossierAdmissionEntiteRepo> query =
                this.em.createQuery("SELECT da FROM DossierAdmissionEntiteRepo da", DossierAdmissionEntiteRepo.class);
        return query.getResultStream();
    }

    @Override
    public void ajouterEtablissementEnseignementFrequente(
            UUID idDossierAdmission,
            EtablissementEnseignementFrequenteEntiteRepo etablissementEnseignementFrequenteEntiteRepo) {
        DossierAdmissionEntiteRepo dossierAdmissionEntiteRepo =
                this.em.find(DossierAdmissionEntiteRepo.class, idDossierAdmission);
        dossierAdmissionEntiteRepo
                .getEtablissementEnseignementFrequentes()
                .add(etablissementEnseignementFrequenteEntiteRepo);
    }

    @Override
    public Stream<DossierAdmissionEntiteRepo> findAll() {
        TypedQuery<DossierAdmissionEntiteRepo> query =
                this.em.createQuery("SELECT da FROM DossierAdmissionEntiteRepo da", DossierAdmissionEntiteRepo.class);
        return query.getResultStream();    }
}
