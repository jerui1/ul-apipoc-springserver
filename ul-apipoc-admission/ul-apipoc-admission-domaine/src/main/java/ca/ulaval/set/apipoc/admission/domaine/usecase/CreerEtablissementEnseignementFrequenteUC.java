package ca.ulaval.set.apipoc.admission.domaine.usecase;

import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionRepositoryDomaine;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.EtablissementEnseignementFrequenteEntiteDomaine;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CreerEtablissementEnseignementFrequenteUC {

    private final DossierAdmissionRepositoryDomaine repositoryDomaine;

    @Transactional
    public UUID apply(UUID idDossierAdmission, UUID idEtablissementEnseignement) {
        DossierAdmissionEntiteDomaine dossierAdmissionEntiteDomaine =
                this.repositoryDomaine.get(idDossierAdmission).orElseThrow();

        EtablissementEnseignementFrequenteEntiteDomaine etablissementEnseignementFrequenteEntiteDomaine =
                dossierAdmissionEntiteDomaine.ajouterEtablissementEnseignementFrequente(idEtablissementEnseignement);
        dossierAdmissionEntiteDomaine.persister();

        return etablissementEnseignementFrequenteEntiteDomaine.getIdEtablissementEnseignementFrequente();
    }
}
