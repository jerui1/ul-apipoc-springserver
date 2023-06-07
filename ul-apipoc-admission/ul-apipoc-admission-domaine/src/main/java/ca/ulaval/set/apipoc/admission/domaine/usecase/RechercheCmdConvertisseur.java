package ca.ulaval.set.apipoc.admission.domaine.usecase;

import ca.ulaval.set.apipoc.admission.domaine.entite.RechercheCmdDomaine;
import ca.ulaval.set.apipoc.admission.domaine.in.RechercheCmdDto;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.RechercheCmdRepoDto;
import org.mapstruct.Mapper;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
@Mapper(componentModel = "spring")
public interface RechercheCmdConvertisseur {

    RechercheCmdDomaine toDomaine(RechercheCmdDto dtoCmd);

    RechercheCmdRepoDto toPersistance(RechercheCmdDomaine rechercheCmdDomaine);

}
