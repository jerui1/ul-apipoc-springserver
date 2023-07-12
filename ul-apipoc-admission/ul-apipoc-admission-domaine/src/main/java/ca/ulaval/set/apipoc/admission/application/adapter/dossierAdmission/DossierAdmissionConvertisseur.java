package ca.ulaval.set.apipoc.admission.application.adapter.dossierAdmission;

import ca.ulaval.set.apipoc.admission.application.in.dossierAdmission.DossierAdmissionEntiteDto;
import ca.ulaval.set.apipoc.admission.application.out.repository.dossierAdmission.DossierAdmissionEntiteRepo;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionEntiteDomaine;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = EtablissementEnseignementFrequenteConvertisseur.class)
public interface DossierAdmissionConvertisseur {

    DossierAdmissionEntiteDomaine toDomaine(DossierAdmissionEntiteRepo entiteRepo, DossierAdmissionOutillage outillage);

    DossierAdmissionEntiteRepo toRepo(DossierAdmissionEntiteDomaine entiteDomaine);

    DossierAdmissionEntiteDto toDto(DossierAdmissionEntiteDomaine entiteDomaine);
}
