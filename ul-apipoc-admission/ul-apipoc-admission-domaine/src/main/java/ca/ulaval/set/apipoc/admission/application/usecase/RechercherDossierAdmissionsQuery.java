package ca.ulaval.set.apipoc.admission.application.usecase;

import ca.ulaval.set.apipoc.admission.application.adapter.dossierAdmission.DossierAdmissionConvertisseur;
import ca.ulaval.set.apipoc.admission.application.in.dossierAdmission.RechercherDossierAdmissionsQueryPort;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionEntiteDomaine;
import ca.ulaval.set.apipoc.admission.application.adapter.dossierAdmission.DossierAdmissionRepositoryDomaine;
import ca.ulaval.set.apipoc.admission.application.in.dossierAdmission.DossierAdmissionEntiteDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RechercherDossierAdmissionsQuery implements RechercherDossierAdmissionsQueryPort {

    private final DossierAdmissionRepositoryDomaine repositoryDomaine;
    private final DossierAdmissionConvertisseur dossierAdmissionConvertisseur;

    @Override
    public List<DossierAdmissionEntiteDto> apply(String ni) {
        List<DossierAdmissionEntiteDomaine> dossierAdmissionEntiteDomaineStream =
                this.repositoryDomaine.find(ni).toList();
        List<DossierAdmissionEntiteDto> list = dossierAdmissionEntiteDomaineStream.stream()
                .map(this.dossierAdmissionConvertisseur::toDto)
                .collect(Collectors.toList());
        return list;
    }
}
