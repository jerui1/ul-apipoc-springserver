package ca.ulaval.set.apipoc.admission.domaine.usecase;

import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementEntiteRepo;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CreerEtablissementEnseignementUC {

    private final EtablissementEnseignementConvertisseur etablissementEnseignementConvertisseur;

    private final EtablissementEnseignementRepository etablissementEnseignementRepository;

    public void apply(String nomEtablissementEnseignement, String codePays) {
        EtablissementEnseignementEntiteDomaine etablissementEnseignementEntiteDomaine =
                EtablissementEnseignementEntiteDomaine.creer(nomEtablissementEnseignement, codePays);
        EtablissementEnseignementEntiteRepo etablissementEnseignementEntiteRepo =
                this.etablissementEnseignementConvertisseur.toRepo(etablissementEnseignementEntiteDomaine);
        this.etablissementEnseignementRepository.persist(etablissementEnseignementEntiteRepo);
    }
}
