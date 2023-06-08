package ca.ulaval.set.apipoc.admission.persistance;

import ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementEntiteRepo;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class EtablissementEnseignementRepositoryJpa implements EtablissementEnseignementRepository {

    private final EntityManager em;

    @Override
    public void persist(EtablissementEnseignementEntiteRepo entiteRepo) {
        this.em.persist(entiteRepo);
    }

    @Override
    public Stream<EtablissementEnseignementEntiteRepo> find() {
        TypedQuery<EtablissementEnseignementEntiteRepo> query = this.em.createQuery(
                "SELECT ee FROM EtablissementEnseignementEntiteRepo ee", EtablissementEnseignementEntiteRepo.class);

        return query.getResultStream();
    }

    @Override
    public Optional<EtablissementEnseignementEntiteRepo> get(UUID idEtablissementEnseignement) {
        EtablissementEnseignementEntiteRepo etablissementEnseignementEntiteRepo =
                this.em.find(EtablissementEnseignementEntiteRepo.class, idEtablissementEnseignement);
        return Optional.ofNullable(etablissementEnseignementEntiteRepo);
    }
}
