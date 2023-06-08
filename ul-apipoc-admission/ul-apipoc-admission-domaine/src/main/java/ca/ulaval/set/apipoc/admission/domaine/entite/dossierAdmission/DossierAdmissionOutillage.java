package ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission;

import ca.ulaval.set.apipoc.admission.domaine.convertisseur.EtablissementEnseignementConvertisseur;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.DossierAdmissionRepositoryPort;
import ca.ulaval.set.apipoc.admission.domaine.convertisseur.DossierAdmissionConvertisseur;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementRepositoryPort;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public class DossierAdmissionOutillage {

    private final DossierAdmissionConvertisseur dossierAdmissionConvertisseur;
    private final DossierAdmissionRepositoryPort dossierAdmissionRepository;

    private final EtablissementEnseignementRepositoryPort etablissementEnseignementRepository;
    private final EtablissementEnseignementConvertisseur etablissementEnseignementConvertisseur;

}
