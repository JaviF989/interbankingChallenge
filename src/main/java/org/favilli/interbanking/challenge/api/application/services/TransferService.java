package org.favilli.interbanking.challenge.api.application.services;

import org.favilli.interbanking.challenge.api.application.ports.input.SearchCompaniesCuitWithActiveTransfersPort;
import org.favilli.interbanking.challenge.api.context.UseCase;

import java.util.List;

@UseCase
public class TransferService implements SearchCompaniesCuitWithActiveTransfersPort {

    private final SearchCompaniesCuitWithActiveTransfersPort searchCompaniesCuitWithActiveTransfersPort;
    public TransferService(SearchCompaniesCuitWithActiveTransfersPort searchCompaniesCuitWithActiveTransfersPort) {
        this.searchCompaniesCuitWithActiveTransfersPort = searchCompaniesCuitWithActiveTransfersPort;
    }

    /**
     * Search the Cuils of the Companies than made transfers the last month
     * @return @Company's Cuils than made transfers this last month
     */
    @Override
    public List<String> getCompaniesWithActiveTransfers() {
        return searchCompaniesCuitWithActiveTransfersPort.getCompaniesWithActiveTransfers();
    }
}
