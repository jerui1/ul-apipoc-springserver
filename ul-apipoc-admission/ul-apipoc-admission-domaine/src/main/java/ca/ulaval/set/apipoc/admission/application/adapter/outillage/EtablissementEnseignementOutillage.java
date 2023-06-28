package ca.ulaval.set.apipoc.admission.application.adapter.outillage;

import ca.ulaval.set.apipoc.admission.application.out.repository.etablissementEnseignement.EtablissementEnseignementRepositoryPort;
import ca.ulaval.set.apipoc.admission.application.adapter.convertisseur.EtablissementEnseignementConvertisseur;
import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementEntiteDomaine;
import ca.ulaval.set.apipoc.admission.application.out.repository.etablissementEnseignement.EtablissementEnseignementEntiteRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EtablissementEnseignementOutillage implements EtablissementEnseignementEntiteDomaine.Outillage {

    private EtablissementEnseignementRepositoryPort etablissementEnseignementRepository;
    private EtablissementEnseignementConvertisseur etablissementEnseignementConvertisseur;

    @Override
    public void persister(EtablissementEnseignementEntiteDomaine entiteDomaine) {
        EtablissementEnseignementEntiteRepo entiteRepo =
                this.etablissementEnseignementConvertisseur.toRepo(entiteDomaine);
        this.etablissementEnseignementRepository.persist(entiteRepo);
    }
}
