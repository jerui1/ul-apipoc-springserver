package ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface DossierAdmissionRepository {
    Optional<DossierAdmissionEntiteRepo> get(UUID idDossierAdmission);

    void persist(DossierAdmissionEntiteRepo dossierAdmissionEntiteRepo);

    Stream<DossierAdmissionEntiteRepo> find(String ni);

    void ajouterEtablissementEnseignementFrequente(
            UUID idDossierAdmission,
            EtablissementEnseignementFrequenteEntiteRepo etablissementEnseignementFrequenteEntiteRepo);
}
