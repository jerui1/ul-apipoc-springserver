package ca.ulaval.set.apipoc.admission.persistance;

import ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementEntiteRepo;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
@AllArgsConstructor
public class EtablissementEnseignementRepositoryJpa implements EtablissementEnseignementRepository {

    private final EntityManager em;

    @Override
    public void persist(EtablissementEnseignementEntiteRepo entiteRepo) {
        this.em.persist(entiteRepo);
    }
}
