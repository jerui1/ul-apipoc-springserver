package ca.ulaval.set.apipoc.admission.application.adapter.dossierAdmission;

import ca.ulaval.set.apipoc.admission.application.adapter.LazyTransformedList;
import ca.ulaval.set.apipoc.admission.application.in.dossierAdmission.DossierAdmissionEntiteDto;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionEntiteDomaine;
import ca.ulaval.set.apipoc.admission.application.out.repository.dossierAdmission.DossierAdmissionEntiteRepo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = EtablissementEnseignementFrequenteConvertisseur.class, imports = LazyTransformedList.class)
public interface DossierAdmissionConvertisseur {

    @Mapping(
            target = "etablissementEnseignementFrequentes",
            expression =
                    "java(new LazyTransformedList<>("
                            + "entiteRepo.getEtablissementEnseignementFrequentes(),"
                            + "s -> this.etablissementEnseignementFrequenteConvertisseur.toDomaine(s, outillage.getOutillageEtablissementEnseignementFrequente())))")
    DossierAdmissionEntiteDomaine toDomaine(DossierAdmissionEntiteRepo entiteRepo, DossierAdmissionOutillage outillage);

    DossierAdmissionEntiteRepo toRepo(DossierAdmissionEntiteDomaine entiteDomaine);

    DossierAdmissionEntiteDto toDto(DossierAdmissionEntiteDomaine entiteDomaine);
}
