package ca.ulaval.set.apipoc.admission.application.usecase;

import ca.ulaval.set.apipoc.admission.application.adapter.convertisseur.EtablissementEnseignementFrequenteConvertisseur;
import ca.ulaval.set.apipoc.admission.application.in.dossierAdmission.EtablissementEnseignementFrequenteEntiteDto;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionRepositoryDomaine;
import ca.ulaval.set.apipoc.admission.application.in.dossierAdmission.RechercheEtablissementEnseignementFrequenteCmdDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class RechercherEtablissementEnseignementFrequenteQuery {

    private final DossierAdmissionRepositoryDomaine dossierAdmissionRepositoryDomaine;
    private final EtablissementEnseignementFrequenteConvertisseur etablissementEnseignementFrequenteConvertisseur;

    @Transactional
    @NotNull
    @Valid
    public List<EtablissementEnseignementFrequenteEntiteDto> apply(
            @NotNull @Valid RechercheEtablissementEnseignementFrequenteCmdDto rechercheCmdDto) {

        List<EtablissementEnseignementFrequenteEntiteDto> list = this.dossierAdmissionRepositoryDomaine
                .findEtablissementEnseignementFrequente(rechercheCmdDto.codePays())
                .map(paire -> this.etablissementEnseignementFrequenteConvertisseur.toDto(paire.y(), paire.x()))
                .collect(Collectors.toList());

        return list;
    }
}
