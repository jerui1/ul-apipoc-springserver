package ca.ulaval.set.apipoc.admission.domaine.convertisseur;

import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionOutillage;
import ca.ulaval.set.apipoc.admission.domaine.in.dossierAdmission.DossierAdmissionEntiteDto;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.DossierAdmissionEntiteRepo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = EtablissementEnseignementFrequenteConvertisseur.class)
public interface DossierAdmissionConvertisseur {

    DossierAdmissionEntiteDomaine toDomaine(DossierAdmissionEntiteRepo entiteRepo, DossierAdmissionOutillage outillage);

    DossierAdmissionEntiteRepo toRepo(DossierAdmissionEntiteDomaine entiteDomaine);

    DossierAdmissionEntiteDto toDto(DossierAdmissionEntiteDomaine entiteDomaine);
}
