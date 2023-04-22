package org.favilli.interbanking.challenge.api.application.usecases;

import org.favilli.interbanking.challenge.api.application.ports.output.CompanyRepositoryPort;
import org.favilli.interbanking.challenge.api.context.UseCase;
import org.favilli.interbanking.challenge.api.domain.model.Company;
import org.favilli.interbanking.challenge.api.application.ports.input.SearchNewCompaniesPort;

import java.time.LocalDate;
import java.util.List;

@UseCase
public class SearchNewCompaniesPortImpl implements SearchNewCompaniesPort {

    private  final CompanyRepositoryPort companyRepositoryPort;
    public SearchNewCompaniesPortImpl(CompanyRepositoryPort companyRepositoryPort) {
        this.companyRepositoryPort = companyRepositoryPort;
    }
    @Override
    public List<Company> getNewCompanies() {
        LocalDate fromDate = LocalDate.now().minusMonths(1);
        return companyRepositoryPort.getNewCompanies(fromDate);
    }
}
