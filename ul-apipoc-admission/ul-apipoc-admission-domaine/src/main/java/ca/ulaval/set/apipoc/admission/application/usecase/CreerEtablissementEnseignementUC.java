package ca.ulaval.set.apipoc.admission.application.usecase;

import ca.ulaval.set.apipoc.admission.application.in.etablissementEnseignement.CreerEtablissementEnseignementUCPort;
import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementFabrique;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class CreerEtablissementEnseignementUC implements CreerEtablissementEnseignementUCPort {

    private final EtablissementEnseignementFabrique fabrique;

    @Override
    public UUID apply(String nomEtablissementEnseignement, String codePays) {
        EtablissementEnseignementEntiteDomaine etablissementEnseignementEntiteDomaine =
                this.fabrique.creer(nomEtablissementEnseignement, codePays);
        etablissementEnseignementEntiteDomaine.persister();

        return etablissementEnseignementEntiteDomaine.getIdEtablissementEnseignement();
    }
}
