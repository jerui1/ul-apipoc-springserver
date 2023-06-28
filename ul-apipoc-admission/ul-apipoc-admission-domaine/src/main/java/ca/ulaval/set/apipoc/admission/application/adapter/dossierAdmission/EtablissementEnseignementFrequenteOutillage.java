package ca.ulaval.set.apipoc.admission.application.adapter.dossierAdmission;

import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.EtablissementEnseignementFrequenteEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementEntiteDomaine;
import ca.ulaval.set.apipoc.admission.application.adapter.etablissementEnseignement.EtablissementEnseignementRepositoryDomaine;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EtablissementEnseignementFrequenteOutillage implements EtablissementEnseignementFrequenteEntiteDomaine.Outillage {

    private final EtablissementEnseignementRepositoryDomaine etablissementEnseignementRepositoryDomaine;

    @Override
    public Optional<EtablissementEnseignementEntiteDomaine> getEtablissementEnseignement(UUID idEtablissementEnseignement) {
        return this.etablissementEnseignementRepositoryDomaine.get(idEtablissementEnseignement);
    }
}
