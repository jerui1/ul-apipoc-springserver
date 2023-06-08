package ca.ulaval.set.apipoc.springserver.restapi;

import ca.ulaval.set.apipoc.admission.domaine.in.etablissementEnseignement.EtablissementEnseignementEntiteDto;
import ca.ulaval.set.apipoc.restapi.model.EtablissementEnseignement;
import ca.ulaval.set.apipoc.restapi.model.EtablissementEnseignementFrequente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface EtablissementEnseignementConvertisseurRest {

    @Mapping(target = "idEtablissement", source = "idEtablissementEnseignement")
    EtablissementEnseignement toRest(EtablissementEnseignementEntiteDto dto);

}
