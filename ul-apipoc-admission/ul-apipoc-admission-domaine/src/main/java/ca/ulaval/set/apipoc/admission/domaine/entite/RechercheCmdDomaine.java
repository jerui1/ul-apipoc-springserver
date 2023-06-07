package ca.ulaval.set.apipoc.admission.domaine.entite;

import javax.validation.constraints.Size;

public record RechercheCmdDomaine(@Size(min = 2, max = 2) String codePays) {}
