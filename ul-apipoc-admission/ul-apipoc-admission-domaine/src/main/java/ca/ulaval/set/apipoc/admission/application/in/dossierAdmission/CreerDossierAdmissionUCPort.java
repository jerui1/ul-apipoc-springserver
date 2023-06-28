package ca.ulaval.set.apipoc.admission.application.in.dossierAdmission;

import java.util.UUID;

public interface CreerDossierAdmissionUCPort {
    UUID apply(String ni);
}
