package ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission;

import ca.ulaval.set.apipoc.admission.domaine.Paire;
import ca.ulaval.set.apipoc.admission.domaine.adapter.convertisseur.DossierAdmissionConvertisseur;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.DossierAdmissionEntiteRepo;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.dossierAdmission.DossierAdmissionRepositoryPort;
import ca.ulaval.set.apipoc.admission.domaine.adapter.outillage.DossierAdmissionOutillage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class DossierAdmissionRepositoryDomaine {

    private final DossierAdmissionOutillage outillage;
    private final DossierAdmissionRepositoryPort repository;
    private final DossierAdmissionConvertisseur convertisseur;

    public Optional<DossierAdmissionEntiteDomaine> get(UUID idDossierAdmission) {
        return this.repository
                .getDossierAdmission(idDossierAdmission)
                .map((DossierAdmissionEntiteRepo entiteRepo) ->
                        this.convertisseur.toDomaine(entiteRepo, this.outillage));
    }

    public Stream<DossierAdmissionEntiteDomaine> find(String ni) {
        return this.repository
                .find(ni)
                .map((DossierAdmissionEntiteRepo entiteRepo) ->
                        this.convertisseur.toDomaine(entiteRepo, this.outillage));
    }

    public Stream<Paire<DossierAdmissionEntiteDomaine, EtablissementEnseignementFrequenteEntiteDomaine>>
            findEtablissementEnseignementFrequente(String codePays) {

        Stream<Paire<DossierAdmissionEntiteDomaine, EtablissementEnseignementFrequenteEntiteDomaine>> stream =
                this.repository
                        .findAll()
                        .map((DossierAdmissionEntiteRepo entiteRepo) ->
                                this.convertisseur.toDomaine(entiteRepo, this.outillage))
                        .map(da -> new Paire<>(da, da.findEtablissementEnseignementFrequentes(codePays)))
                        .flatMap(paire -> paire.y().stream().map(y -> new Paire<>(paire.x(), y)));

        return stream;
    }
}
