package ca.ulaval.set.apipoc.admission.application.usecase;

import ca.ulaval.set.apipoc.admission.application.adapter.convertisseur.EtablissementEnseignementFrequenteConvertisseur;
import ca.ulaval.set.apipoc.admission.application.in.dossierAdmission.EtablissementEnseignementFrequenteEntiteDto;
import ca.ulaval.set.apipoc.admission.application.in.dossierAdmission.RechercherEtablissementEnseignementFrequenteQueryPort;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionRepositoryDomaine;
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
public class RechercherEtablissementEnseignementFrequenteQuery
        implements RechercherEtablissementEnseignementFrequenteQueryPort {

    private final DossierAdmissionRepositoryDomaine dossierAdmissionRepositoryDomaine;
    private final EtablissementEnseignementFrequenteConvertisseur etablissementEnseignementFrequenteConvertisseur;

    @Override
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
