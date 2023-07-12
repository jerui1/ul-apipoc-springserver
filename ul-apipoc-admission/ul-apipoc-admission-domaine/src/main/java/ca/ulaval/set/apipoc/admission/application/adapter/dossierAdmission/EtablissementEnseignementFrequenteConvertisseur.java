package ca.ulaval.set.apipoc.admission.application.adapter.dossierAdmission;

import ca.ulaval.set.apipoc.admission.application.adapter.LazyTransformedList;
import ca.ulaval.set.apipoc.admission.application.adapter.etablissementEnseignement.EtablissementEnseignementConvertisseur;
import ca.ulaval.set.apipoc.admission.application.in.dossierAdmission.EtablissementEnseignementFrequenteEntiteDto;
import ca.ulaval.set.apipoc.admission.application.out.repository.dossierAdmission.EtablissementEnseignementFrequenteEntiteRepo;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.EtablissementEnseignementFrequenteEntiteDomaine;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = EtablissementEnseignementConvertisseur.class)
public abstract class EtablissementEnseignementFrequenteConvertisseur {

    @Autowired
    private EtablissementEnseignementFrequenteEntiteDomaine.Outillage outillage;

    public abstract EtablissementEnseignementFrequenteEntiteDomaine toDomaine(
            EtablissementEnseignementFrequenteEntiteRepo entiteRepo,
            EtablissementEnseignementFrequenteEntiteDomaine.Outillage outillage);

    public List<EtablissementEnseignementFrequenteEntiteDomaine> toDomaines(
            List<EtablissementEnseignementFrequenteEntiteRepo> entitesRepo) {
        return new LazyTransformedList<>(
                entitesRepo, s -> this.toDomaine(s, outillage));
    }

    public abstract EtablissementEnseignementFrequenteEntiteDto toDto(
            EtablissementEnseignementFrequenteEntiteDomaine entiteDomaine,
            DossierAdmissionEntiteDomaine dossierAdmissionEntiteDomaine);

    public abstract EtablissementEnseignementFrequenteEntiteRepo toRepo(
            EtablissementEnseignementFrequenteEntiteDomaine entiteDomaine);
}
