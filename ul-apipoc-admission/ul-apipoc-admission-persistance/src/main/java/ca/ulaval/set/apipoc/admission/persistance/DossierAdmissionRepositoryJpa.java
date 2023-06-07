package ca.ulaval.set.apipoc.admission.persistance;

import ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.DossierAdmissionEntiteRepo;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.DossierAdmissionRepository;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.EtablissementEnseignementFrequenteEntiteRepo;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementEntiteRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class DossierAdmissionRepositoryJpa implements DossierAdmissionRepository {

    private final ArrayList<EtablissementEnseignementFrequenteEntiteRepo> etablissements;

    public DossierAdmissionRepositoryJpa() {
        etablissements = new ArrayList<>();
        etablissements.add(new EtablissementEnseignementFrequenteEntiteRepo()
                .setIdEtablissementEnseignementFrequente(UUID.randomUUID())
                        .setVersion(1)
                .setEtablissementEnseignement(new EtablissementEnseignementEntiteRepo()
                        .setIdEtablissement(UUID.randomUUID())
                        .setCodePays("ca")
                        .setNomEtablissementEnseignement("ULaval")));
        etablissements.add(new EtablissementEnseignementFrequenteEntiteRepo()
                .setIdEtablissementEnseignementFrequente(UUID.randomUUID())
                .setVersion(1)
                .setEtablissementEnseignement(new EtablissementEnseignementEntiteRepo()
                        .setIdEtablissement(UUID.randomUUID())
                        .setCodePays("fr")
                        .setNomEtablissementEnseignement("Dauphine")));
    }

    @Override
    public DossierAdmissionEntiteRepo get(UUID idDossierAdmission) {
        DossierAdmissionEntiteRepo dossierAdmissionEntiteRepo = new DossierAdmissionEntiteRepo()
                .setIdDossierAdmission(idDossierAdmission)
                .setEtablissementEnseignementFrequentes(etablissements);
        return dossierAdmissionEntiteRepo;
    }
}
