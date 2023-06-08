package ca.ulaval.set.apipoc.admission.domaine.convertisseur;

import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.EtablissementEnseignementFrequenteEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.in.etablissementEnseignement.EtablissementEnseignementEntiteDto;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementEntiteRepo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EtablissementEnseignementConvertisseur {

    EtablissementEnseignementEntiteDomaine toDomaine(EtablissementEnseignementEntiteRepo entiteRepo);

    EtablissementEnseignementEntiteDto toDto(EtablissementEnseignementEntiteDomaine entiteDomaine);

    EtablissementEnseignementEntiteRepo toRepo(EtablissementEnseignementEntiteDomaine entiteDomaine);
}
