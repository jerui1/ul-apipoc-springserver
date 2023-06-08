package ca.ulaval.set.apipoc.admission.domaine.usecase;

import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.in.dossierAdmission.EtablissementEnseignementFrequenteEntiteDto;
import ca.ulaval.set.apipoc.admission.domaine.in.dossierAdmission.RechercheEtablissementEnseignementFrequenteCmdDto;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.DossierAdmissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Validated
public class RechercherEtablissementEnseignementFrequenteQuery {

    private final DossierAdmissionRepository dossierAdmissionRepository;
    private final DossierAdmissionConvertisseur dossierAdmissionConvertisseur;
    private final EtablissementEnseignementFrequenteConvertisseur etablissementEnseignementFrequenteConvertisseur;

    @Transactional
    @NotNull
    @Valid
    public List<EtablissementEnseignementFrequenteEntiteDto> apply(
            @NotNull @Valid RechercheEtablissementEnseignementFrequenteCmdDto rechercheCmdDto) {

        List<EtablissementEnseignementFrequenteEntiteDto> list = this.dossierAdmissionRepository
                .find(null)
                .map(this.dossierAdmissionConvertisseur::toDomaine)
                .flatMap((DossierAdmissionEntiteDomaine dossierAdmissionEntiteDomaine) ->
                        toEtablissementFrequenteDtos(dossierAdmissionEntiteDomaine, rechercheCmdDto.codePays()))
                .collect(Collectors.toList());

        return list;
    }

    private Stream<EtablissementEnseignementFrequenteEntiteDto> toEtablissementFrequenteDtos(
            DossierAdmissionEntiteDomaine dossierAdmissionEntiteDomaine, String codePays) {
        return dossierAdmissionEntiteDomaine.getEtablissementEnseignementFrequentes().stream()
                .filter(eef -> codePays == null
                        || eef.getEtablissementEnseignement().getCodePays().equalsIgnoreCase(codePays))
                .map(eef ->
                        this.etablissementEnseignementFrequenteConvertisseur.toDto(eef, dossierAdmissionEntiteDomaine));
    }
}
