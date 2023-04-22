package org.favilli.interbanking.challenge.api.application.usecases;

import org.favilli.interbanking.challenge.api.application.ports.input.InputCompanyPort;
import org.favilli.interbanking.challenge.api.context.UseCase;
import org.favilli.interbanking.challenge.api.domain.model.Company;
import org.favilli.interbanking.challenge.api.application.ports.input.CreateCompanyPort;
import org.favilli.interbanking.challenge.api.application.ports.output.CompanyRepositoryPort;

import java.time.LocalDate;

@UseCase
public class CreateCompanyPortImpl implements CreateCompanyPort {

    private  final CompanyRepositoryPort companyRepositoryPort;
    public CreateCompanyPortImpl(CompanyRepositoryPort companyRepositoryPort) {
        this.companyRepositoryPort = companyRepositoryPort;
    }

    @Override
    public Company createCompany(InputCompanyPort inputCompanyPort) {
        Company company = Company.builder()
                .cuit(inputCompanyPort.getCuit())
                .businessName(inputCompanyPort.getBusinessName())
                .accessionDate(LocalDate.now())
                .build();

        return companyRepositoryPort.save(company);
    }
}
