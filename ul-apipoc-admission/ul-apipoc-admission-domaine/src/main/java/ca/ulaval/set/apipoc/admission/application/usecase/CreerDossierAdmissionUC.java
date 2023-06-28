package ca.ulaval.set.apipoc.admission.application.usecase;

import ca.ulaval.set.apipoc.admission.application.in.dossierAdmission.CreerDossierAdmissionUCPort;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionFabriqueDomaine;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class CreerDossierAdmissionUC implements CreerDossierAdmissionUCPort {

    private final DossierAdmissionFabriqueDomaine dossierAdmissionFabrique;

    @Override
    public UUID apply(String ni) {
        DossierAdmissionEntiteDomaine nouveauDossierAdmission = this.dossierAdmissionFabrique.creer(ni);
        nouveauDossierAdmission.persister();
        return nouveauDossierAdmission.getIdDossierAdmission();
    }
}
