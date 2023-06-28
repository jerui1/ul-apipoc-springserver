package ca.ulaval.set.apipoc.admission.application.adapter.dossierAdmission;

import ca.ulaval.set.apipoc.admission.application.out.repository.dossierAdmission.DossierAdmissionEntiteRepo;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.EtablissementEnseignementFrequenteEntiteDomaine;
import ca.ulaval.set.apipoc.admission.application.out.repository.dossierAdmission.DossierAdmissionRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DossierAdmissionOutillage implements DossierAdmissionEntiteDomaine.Outillage {

    private final DossierAdmissionConvertisseur dossierAdmissionConvertisseur;
    private final DossierAdmissionRepositoryPort dossierAdmissionRepository;

    private final EtablissementEnseignementFrequenteEntiteDomaine.Outillage etablissementEnseignementFrequenteOutillage;

    @Override
    public EtablissementEnseignementFrequenteEntiteDomaine.Outillage getOutillageEtablissementEnseignementFrequente() {
        return etablissementEnseignementFrequenteOutillage;
    }

    @Override
    public void persist(DossierAdmissionEntiteDomaine entiteDomaine) {
        DossierAdmissionEntiteRepo entiteRepo = this.dossierAdmissionConvertisseur.toRepo(entiteDomaine);
        this.dossierAdmissionRepository.persist(entiteRepo);
    }
}
