package ca.ulaval.set.apipoc.admission.domaine.usecase;

import ca.ulaval.set.apipoc.admission.domaine.in.dossierAdmission.DossierAdmissionEntiteDto;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.DossierAdmissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RechercherDossierAdmissionsQuery {

    private final DossierAdmissionRepository dossierAdmissionRepository;
    private final DossierAdmissionConvertisseur dossierAdmissionConvertisseur;

    public List<DossierAdmissionEntiteDto> apply(String ni) {
        List<DossierAdmissionEntiteDto> list = this.dossierAdmissionRepository.find(ni)
                .map(this.dossierAdmissionConvertisseur::toDomaine)
                .map(this.dossierAdmissionConvertisseur::toDto)
                .collect(Collectors.toList());
        return list;
    }
}
