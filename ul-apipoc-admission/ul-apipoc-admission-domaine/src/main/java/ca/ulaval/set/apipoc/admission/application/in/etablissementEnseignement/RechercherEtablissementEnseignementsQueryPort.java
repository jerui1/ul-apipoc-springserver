package ca.ulaval.set.apipoc.admission.application.in.etablissementEnseignement;

import java.util.List;

public interface RechercherEtablissementEnseignementsQueryPort {
    List<EtablissementEnseignementEntiteDto> apply();
}
