package ca.ulaval.set.apipoc.admission.domaine.usecase;

import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.in.dossierAdmission.EtablissementEnseignementFrequenteEntiteDto;
import ca.ulaval.set.apipoc.admission.domaine.in.dossierAdmission.RechercheEtablissementEnseignementFrequenteCmdDto;
import ca.ulaval.set.apipoc.admission.domaine.in.etablissementEnseignement.EtablissementEnseignementEntiteDto;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.DossierAdmissionRepository;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.EtablissementEnseignementFrequenteEntiteRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class RechercherEtablissementEnseignementFrequenteQuery {

    private final DossierAdmissionRepository dossierAdmissionRepository;
    private final DossierAdmissionConvertisseur dossierAdmissionConvertisseur;
    private final EtablissementEnseignementFrequenteConvertisseur etablissementEnseignementFrequenteConvertisseur;

    @NotNull
    @Valid
    public List<EtablissementEnseignementFrequenteEntiteDto> apply(
            @NotNull @Valid
                    RechercheEtablissementEnseignementFrequenteCmdDto
                            rechercheEtablissementEnseignementFrequenteCmdDto) {

        DossierAdmissionEntiteDomaine dossierAdmissionEntiteDomaine =
                this.dossierAdmissionConvertisseur.toDomaine(this.dossierAdmissionRepository.get(
                        rechercheEtablissementEnseignementFrequenteCmdDto.idDossierAdmission()));

        List<EtablissementEnseignementFrequenteEntiteDto> etablissementEnseignementEntiteDtos =
                dossierAdmissionEntiteDomaine
                        .findEtablissementEnseignementFrequentes(
                                rechercheEtablissementEnseignementFrequenteCmdDto.codePays())
                        .stream()
                        .map(eef -> this.etablissementEnseignementFrequenteConvertisseur.toDto(eef, dossierAdmissionEntiteDomaine))
                        .collect(Collectors.toList());

        return etablissementEnseignementEntiteDtos;
    }
}
