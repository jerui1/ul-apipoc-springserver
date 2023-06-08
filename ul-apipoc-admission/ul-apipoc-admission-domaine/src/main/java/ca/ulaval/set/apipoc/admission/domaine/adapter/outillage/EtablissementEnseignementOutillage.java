package ca.ulaval.set.apipoc.admission.domaine.adapter.outillage;

import ca.ulaval.set.apipoc.admission.domaine.adapter.convertisseur.EtablissementEnseignementConvertisseur;
import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementEntiteRepo;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementRepositoryPort;
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
