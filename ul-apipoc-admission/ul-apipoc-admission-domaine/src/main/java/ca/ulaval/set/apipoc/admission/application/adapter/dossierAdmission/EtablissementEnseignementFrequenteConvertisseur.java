package ca.ulaval.set.apipoc.admission.application.adapter.dossierAdmission;

import ca.ulaval.set.apipoc.admission.application.adapter.etablissementEnseignement.EtablissementEnseignementConvertisseur;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.EtablissementEnseignementFrequenteEntiteDomaine;
import ca.ulaval.set.apipoc.admission.application.in.dossierAdmission.EtablissementEnseignementFrequenteEntiteDto;
import ca.ulaval.set.apipoc.admission.application.out.repository.dossierAdmission.EtablissementEnseignementFrequenteEntiteRepo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = EtablissementEnseignementConvertisseur.class)
public interface EtablissementEnseignementFrequenteConvertisseur {

    EtablissementEnseignementFrequenteEntiteDomaine toDomaine(
            EtablissementEnseignementFrequenteEntiteRepo entiteRepo,
            EtablissementEnseignementFrequenteEntiteDomaine.Outillage outillage);

    //    @Mapping(target = "idDossierAdmission", source = "idDossierAdmission")
    EtablissementEnseignementFrequenteEntiteDto toDto(
            EtablissementEnseignementFrequenteEntiteDomaine entiteDomaine,
            DossierAdmissionEntiteDomaine dossierAdmissionEntiteDomaine);

    EtablissementEnseignementFrequenteEntiteRepo toRepo(EtablissementEnseignementFrequenteEntiteDomaine entiteDomaine);
}
