package ca.ulaval.set.apipoc.admission.application.adapter.dossierAdmission;

import ca.ulaval.set.apipoc.admission.domaine.entite.Paire;
import ca.ulaval.set.apipoc.admission.application.out.repository.dossierAdmission.DossierAdmissionEntiteRepo;
import ca.ulaval.set.apipoc.admission.application.out.repository.dossierAdmission.DossierAdmissionRepositoryPort;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.DossierAdmissionRepositoryDomainePort;
import ca.ulaval.set.apipoc.admission.domaine.entite.dossierAdmission.EtablissementEnseignementFrequenteEntiteDomaine;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class DossierAdmissionRepositoryDomaine implements DossierAdmissionRepositoryDomainePort {

    private final DossierAdmissionOutillage outillage;
    private final DossierAdmissionRepositoryPort repository;
    private final DossierAdmissionConvertisseur convertisseur;

    @Override
    public Optional<DossierAdmissionEntiteDomaine> get(UUID idDossierAdmission) {
        return this.repository
                .getDossierAdmission(idDossierAdmission)
                .map((DossierAdmissionEntiteRepo entiteRepo) ->
                        this.convertisseur.toDomaine(entiteRepo, this.outillage));
    }

    @Override
    public Stream<DossierAdmissionEntiteDomaine> find(String ni) {
        return this.repository
                .find(ni)
                .map((DossierAdmissionEntiteRepo entiteRepo) ->
                        this.convertisseur.toDomaine(entiteRepo, this.outillage));
    }

    @Override
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
