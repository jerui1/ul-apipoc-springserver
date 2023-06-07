package ca.ulaval.set.apipoc.springserver.restapi;

import ca.ulaval.set.apipoc.admission.domaine.in.etablissementEnseignement.EtablissementEnseignementEntiteDto;
import ca.ulaval.set.apipoc.restapi.model.EtablissementEnseignementFrequente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EtablissementEnseignementConvertisseurRest {

    EtablissementEnseignementFrequente toRest(EtablissementEnseignementEntiteDto dto);

}
