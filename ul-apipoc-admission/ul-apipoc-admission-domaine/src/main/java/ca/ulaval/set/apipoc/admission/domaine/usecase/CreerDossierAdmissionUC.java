package ca.ulaval.set.apipoc.admission.domaine.usecase;

import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.DossierAdmissionEntiteRepo;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.DossierAdmissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class CreerDossierAdmissionUC {

    private final DossierAdmissionConvertisseur dossierAdmissionConvertisseur;
    private final DossierAdmissionRepository dossierAdmissionRepository;

    public UUID apply(String ni) {
        DossierAdmissionEntiteDomaine nouveauDossierAdmission = DossierAdmissionEntiteDomaine.creer(ni);

        // Autre approche possible
//        nouveauDossierAdmission.save(dossierAdmissionRepository);

        DossierAdmissionEntiteRepo dossierAdmissionEntiteRepo =
                this.dossierAdmissionConvertisseur.toRepo(nouveauDossierAdmission);
        this.dossierAdmissionRepository.persist(dossierAdmissionEntiteRepo);

        return nouveauDossierAdmission.getIdDossierAdmission();
    }
}
