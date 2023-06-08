package ca.ulaval.set.apipoc.admission.domaine.usecase;

import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.EtablissementEnseignementFrequenteEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.DossierAdmissionRepository;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CreerEtablissementEnseignementFrequenteUC {

    private final DossierAdmissionRepository dossierAdmissionRepository;
    private final DossierAdmissionConvertisseur dossierAdmissionConvertisseur;

    private final EtablissementEnseignementRepository etablissementEnseignementRepository;
    private final EtablissementEnseignementConvertisseur etablissementEnseignementConvertisseur;
    private final EtablissementEnseignementFrequenteConvertisseur etablissementEnseignementFrequenteConvertisseur;

    @Transactional
    public UUID apply(UUID idDossierAdmission, UUID idEtablissementEnseignement) {
        DossierAdmissionEntiteDomaine dossierAdmissionEntiteDomaine = this.dossierAdmissionRepository
                .get(idDossierAdmission)
                .map(this.dossierAdmissionConvertisseur::toDomaine)
                .orElseThrow();

        EtablissementEnseignementEntiteDomaine etablissementEnseignementEntiteDomaine =
                etablissementEnseignementRepository
                        .get(idEtablissementEnseignement)
                        .map(this.etablissementEnseignementConvertisseur::toDomaine)
                        .orElseThrow();

        EtablissementEnseignementFrequenteEntiteDomaine etablissementEnseignementFrequenteEntiteDomaine = dossierAdmissionEntiteDomaine.ajouterEtablissementEnseignementFrequente(etablissementEnseignementEntiteDomaine);

        this.dossierAdmissionRepository.ajouterEtablissementEnseignementFrequente(
                dossierAdmissionEntiteDomaine.getIdDossierAdmission(),
                this.etablissementEnseignementFrequenteConvertisseur.toRepo(etablissementEnseignementFrequenteEntiteDomaine));

        return etablissementEnseignementFrequenteEntiteDomaine.getIdEtablissementEnseignementFrequente();
    }
}
