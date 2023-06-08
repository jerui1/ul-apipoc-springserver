package ca.ulaval.set.apipoc.admission.domaine.usecase;

import ca.ulaval.set.apipoc.admission.domaine.convertisseur.DossierAdmissionConvertisseur;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionRepositoryDomaine;
import ca.ulaval.set.apipoc.admission.domaine.in.dossierAdmission.DossierAdmissionEntiteDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RechercherDossierAdmissionsQuery {

    private final DossierAdmissionRepositoryDomaine repositoryDomaine;
    private final DossierAdmissionConvertisseur dossierAdmissionConvertisseur;

    public List<DossierAdmissionEntiteDto> apply(String ni) {
        List<DossierAdmissionEntiteDto> list = this.repositoryDomaine.find(ni)
                .map(this.dossierAdmissionConvertisseur::toDto)
                .collect(Collectors.toList());
        return list;
    }
}
