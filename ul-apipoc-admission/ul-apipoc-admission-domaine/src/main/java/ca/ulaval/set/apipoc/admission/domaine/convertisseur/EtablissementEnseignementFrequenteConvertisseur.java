package ca.ulaval.set.apipoc.admission.domaine.convertisseur;

import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.EtablissementEnseignementFrequenteEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.in.dossierAdmission.EtablissementEnseignementFrequenteEntiteDto;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.EtablissementEnseignementFrequenteEntiteRepo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = EtablissementEnseignementConvertisseur.class)
public interface EtablissementEnseignementFrequenteConvertisseur {

    EtablissementEnseignementFrequenteEntiteDomaine toDomaine(EtablissementEnseignementFrequenteEntiteRepo entiteRepo);

    //    @Mapping(target = "idDossierAdmission", source = "idDossierAdmission")
    EtablissementEnseignementFrequenteEntiteDto toDto(
            EtablissementEnseignementFrequenteEntiteDomaine entiteDomaine,
            DossierAdmissionEntiteDomaine dossierAdmissionEntiteDomaine);

    EtablissementEnseignementFrequenteEntiteRepo toRepo(EtablissementEnseignementFrequenteEntiteDomaine entiteDomaine);
}
