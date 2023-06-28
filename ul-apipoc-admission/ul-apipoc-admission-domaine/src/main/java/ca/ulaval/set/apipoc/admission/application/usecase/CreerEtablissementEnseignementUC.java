package ca.ulaval.set.apipoc.admission.application.usecase;

import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementFabrique;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class CreerEtablissementEnseignementUC {

    private final EtablissementEnseignementFabrique fabrique;

    public UUID apply(String nomEtablissementEnseignement, String codePays) {
        EtablissementEnseignementEntiteDomaine etablissementEnseignementEntiteDomaine =
                this.fabrique.creer(nomEtablissementEnseignement, codePays);
        etablissementEnseignementEntiteDomaine.persister();

        return etablissementEnseignementEntiteDomaine.getIdEtablissementEnseignement();
    }
}
