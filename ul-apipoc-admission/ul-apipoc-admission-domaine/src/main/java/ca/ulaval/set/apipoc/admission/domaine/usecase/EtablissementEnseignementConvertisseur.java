package ca.ulaval.set.apipoc.admission.domaine.usecase;

import ca.ulaval.set.apipoc.admission.domaine.entite.EtablissementEnseignementFrequenteEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.in.EtablissementEnseignementDto;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.EtablissementEnseignementEntiteRepo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EtablissementEnseignementConvertisseur {

    EtablissementEnseignementFrequenteEntiteDomaine toDomaine(EtablissementEnseignementEntiteRepo repoDto);

    EtablissementEnseignementDto toDto(EtablissementEnseignementFrequenteEntiteDomaine domaine);
}
