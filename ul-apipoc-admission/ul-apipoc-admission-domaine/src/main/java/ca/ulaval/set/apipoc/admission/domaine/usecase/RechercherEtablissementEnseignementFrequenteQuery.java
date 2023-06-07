package ca.ulaval.set.apipoc.admission.domaine.usecase;

import ca.ulaval.set.apipoc.admission.domaine.entite.RechercheCmdDomaine;
import ca.ulaval.set.apipoc.admission.domaine.in.EtablissementEnseignementDto;
import ca.ulaval.set.apipoc.admission.domaine.in.RechercheCmdDto;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.EtablissementEnseignementRepository;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.RechercheCmdRepoDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class RechercherEtablissementEnseignementFrequenteQuery {

    private final RechercheCmdConvertisseur convertisseurCmd;
    private final EtablissementEnseignementConvertisseur etablissementEnseignementConvertisseur;
    private final EtablissementEnseignementRepository repository;
    private final Validator validator;

    @NotNull
    @Valid
    public List<EtablissementEnseignementDto> apply(@NotNull @Valid RechercheCmdDto rechercheCmdDto) {
        RechercheCmdDomaine rechercheCmdDomaine = this.convertisseurCmd.toDomaine(rechercheCmdDto);

        Set<ConstraintViolation<RechercheCmdDomaine>> constraintViolations = validator.validate(rechercheCmdDomaine);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }

        RechercheCmdRepoDto rechercheCmdRepoDto = this.convertisseurCmd.toPersistance(rechercheCmdDomaine);

        List<EtablissementEnseignementDto> etablissements = this.repository.rechercher(rechercheCmdRepoDto).stream()
                .map(this.etablissementEnseignementConvertisseur::toDomaine)
                .map(this.etablissementEnseignementConvertisseur::toDto)
                .collect(Collectors.toList());

        return etablissements;
    }
}
