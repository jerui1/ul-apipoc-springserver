package ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DossierAdmissionFabrique {

    private final DossierAdmissionOutillage outillage;

    public DossierAdmissionEntiteDomaine creer(String ni) {
        return new DossierAdmissionEntiteDomaine(outillage, UUID.randomUUID(), ni, Collections.emptyList());
    }

}
