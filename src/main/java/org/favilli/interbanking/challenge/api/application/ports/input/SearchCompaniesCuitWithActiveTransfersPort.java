package org.favilli.interbanking.challenge.api.application.ports.input;

import java.util.List;

public interface SearchCompaniesCuitWithActiveTransfersPort {

    List<String> getCompaniesWithActiveTransfers();
}
