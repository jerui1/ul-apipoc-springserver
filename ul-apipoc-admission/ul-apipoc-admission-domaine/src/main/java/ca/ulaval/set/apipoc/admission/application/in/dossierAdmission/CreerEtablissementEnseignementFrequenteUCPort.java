package ca.ulaval.set.apipoc.admission.application.in.dossierAdmission;

import javax.transaction.Transactional;
import java.util.UUID;

public interface CreerEtablissementEnseignementFrequenteUCPort {
    @Transactional
    UUID apply(UUID idDossierAdmission, UUID idEtablissementEnseignement);
}
