package ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement;

import ca.ulaval.set.apipoc.admission.domaine.convertisseur.EtablissementEnseignementConvertisseur;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementRepositoryPort;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public class EtablissementEnseignementOutillage {

    private EtablissementEnseignementRepositoryPort etablissementEnseignementRepository;
    private EtablissementEnseignementConvertisseur etablissementEnseignementConvertisseur;

}
