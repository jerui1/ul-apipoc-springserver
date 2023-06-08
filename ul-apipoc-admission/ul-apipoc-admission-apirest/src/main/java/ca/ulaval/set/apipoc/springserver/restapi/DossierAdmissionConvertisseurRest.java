package ca.ulaval.set.apipoc.springserver.restapi;

import ca.ulaval.set.apipoc.admission.domaine.in.dossierAdmission.DossierAdmissionEntiteDto;
import ca.ulaval.set.apipoc.restapi.model.DossierAdmission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DossierAdmissionConvertisseurRest {

    DossierAdmission toRest(DossierAdmissionEntiteDto entiteDto);

}
