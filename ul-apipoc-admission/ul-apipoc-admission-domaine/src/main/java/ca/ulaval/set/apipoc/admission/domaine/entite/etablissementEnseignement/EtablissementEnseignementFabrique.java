package ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class EtablissementEnseignementFabrique {

    private final EtablissementEnseignementEntiteDomaine.Outillage outillage;

    public EtablissementEnseignementEntiteDomaine creer(String nomEtablissementEnseignement, String codePays) {
        EtablissementEnseignementEntiteDomaine nouvelEtablissementEnseignement =
                new EtablissementEnseignementEntiteDomaine(
                        outillage, UUID.randomUUID(), nomEtablissementEnseignement, codePays, null, true);
        return nouvelEtablissementEnseignement;
    }
}
