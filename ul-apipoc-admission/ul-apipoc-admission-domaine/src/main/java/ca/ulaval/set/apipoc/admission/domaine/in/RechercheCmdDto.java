package ca.ulaval.set.apipoc.admission.domaine.in;

import javax.validation.constraints.AssertTrue;
import java.util.UUID;

import static ca.ulaval.set.apipoc.admission.domaine.in.RechercheCmdDomaine_Constraints.ValidCodePays;

public record RechercheCmdDto(UUID idDossierAdmission, @ValidCodePays String codePays) {

}
