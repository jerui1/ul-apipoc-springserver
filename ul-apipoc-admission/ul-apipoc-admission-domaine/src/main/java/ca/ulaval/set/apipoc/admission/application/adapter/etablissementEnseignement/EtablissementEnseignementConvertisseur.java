package ca.ulaval.set.apipoc.admission.application.adapter.etablissementEnseignement;

import ca.ulaval.set.apipoc.admission.application.in.etablissementEnseignement.EtablissementEnseignementEntiteDto;
import ca.ulaval.set.apipoc.admission.application.out.repository.etablissementEnseignement.EtablissementEnseignementEntiteRepo;
import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementEntiteDomaine;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EtablissementEnseignementConvertisseur {

    EtablissementEnseignementEntiteDomaine toDomaine(EtablissementEnseignementEntiteRepo entiteRepo, EtablissementEnseignementEntiteDomaine.Outillage outillage);

    EtablissementEnseignementEntiteDto toDto(EtablissementEnseignementEntiteDomaine entiteDomaine);

    EtablissementEnseignementEntiteRepo toRepo(EtablissementEnseignementEntiteDomaine entiteDomaine);
}
