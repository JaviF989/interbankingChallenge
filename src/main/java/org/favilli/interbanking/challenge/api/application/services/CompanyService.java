package org.favilli.interbanking.challenge.api.application.services;

import org.favilli.interbanking.challenge.api.application.ports.input.InputCompanyPort;
import org.favilli.interbanking.challenge.api.application.ports.input.SearchActiveCompaniesByCuitPort;
import org.favilli.interbanking.challenge.api.context.UseCase;
import org.favilli.interbanking.challenge.api.domain.model.Company;
import org.favilli.interbanking.challenge.api.application.ports.input.CreateCompanyPort;
import org.favilli.interbanking.challenge.api.application.ports.input.SearchNewCompaniesPort;


import java.util.List;

@UseCase
public class CompanyService implements CreateCompanyPort, SearchNewCompaniesPort, SearchActiveCompaniesByCuitPort {

    private final CreateCompanyPort createCompanyPort;
    private final SearchNewCompaniesPort searchNewCompaniesPort;
    private final SearchActiveCompaniesByCuitPort searchActiveCompaniesByCuitPort;

    public CompanyService(CreateCompanyPort createCompanyPort,
                          SearchNewCompaniesPort searchNewCompaniesPort,
                          SearchActiveCompaniesByCuitPort searchActiveCompaniesByCuitPort) {
        this.createCompanyPort = createCompanyPort;
        this.searchNewCompaniesPort = searchNewCompaniesPort;
        this.searchActiveCompaniesByCuitPort = searchActiveCompaniesByCuitPort;
    }

    /**
     * Create a new @Company
     * @param @InputCompany
     * @return @Company than we save
     */
    @Override
    public Company createCompany(InputCompanyPort inputCompanyPort) {
        return createCompanyPort.createCompany(inputCompanyPort);
    }

    /**
     * Search the companies than join us in the last month.
     * @return List of @Company than join us the last month
     */
    @Override
    public List<Company> getNewCompanies() {
        return searchNewCompaniesPort.getNewCompanies();
    }

    /**
     * Search by Cuit the companies than has transfers in the last month
     * @return List of @Company than has transfers in the last month
     */
    @Override
    public List<Company> getActiveCompaniesByCuit() {
        return this.searchActiveCompaniesByCuitPort.getActiveCompaniesByCuit();
    }
}
