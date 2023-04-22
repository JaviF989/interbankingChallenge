package org.favilli.interbanking.challenge.api.application.usecases;

import org.favilli.interbanking.challenge.api.application.ports.input.SearchActiveCompaniesByCuitPort;
import org.favilli.interbanking.challenge.api.application.ports.output.CompanyRepositoryPort;
import org.favilli.interbanking.challenge.api.application.services.TransferService;
import org.favilli.interbanking.challenge.api.context.UseCase;
import org.favilli.interbanking.challenge.api.domain.model.Company;

import java.util.List;

@UseCase
public class SearchActiveCompaniesByCuitPortImpl implements SearchActiveCompaniesByCuitPort {

    private final CompanyRepositoryPort companyRepositoryPort;
    private final TransferService transferService;
    public SearchActiveCompaniesByCuitPortImpl(CompanyRepositoryPort companyRepositoryPort,
                                               TransferService transferService) {
        this.companyRepositoryPort = companyRepositoryPort;
        this.transferService = transferService;
    }

    @Override
    public List<Company> getActiveCompaniesByCuit() {
        return companyRepositoryPort.getCompaniesByCuit(
                this.transferService.getCompaniesWithActiveTransfers());
    }
}
