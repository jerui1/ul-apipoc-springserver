package ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission;

import ca.ulaval.set.apipoc.admission.domaine.entite.Paire;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface DossierAdmissionRepositoryDomainePort {
    Optional<DossierAdmissionEntiteDomaine> get(UUID idDossierAdmission);

    Stream<DossierAdmissionEntiteDomaine> find(String ni);

    Stream<Paire<DossierAdmissionEntiteDomaine, EtablissementEnseignementFrequenteEntiteDomaine>>
            findEtablissementEnseignementFrequente(String codePays);
}
