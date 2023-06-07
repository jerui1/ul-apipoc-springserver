package ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission;

import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.EtablissementEnseignementFrequenteEntiteDomaine;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.UUID;

import static ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.EtablissementEnseignementFrequenteEntiteDomaine_Constraints.*;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(exclude = "idDossierAdmission")
public class DossierAdmissionEntiteRepo {


    private UUID idDossierAdmission;

    @ValidEtablissementEnseignement
    private Collection<EtablissementEnseignementFrequenteEntiteRepo> etablissementEnseignementFrequentes;

}
