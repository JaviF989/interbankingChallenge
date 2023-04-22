package org.favilli.interbanking.challenge.api.application.ports.output;

import org.favilli.interbanking.challenge.api.domain.model.Company;

import java.time.LocalDate;
import java.util.List;

public interface CompanyRepositoryPort {
    Company save(Company company);

    List<Company> getNewCompanies(LocalDate fromDate);

    List<Company> getCompaniesByCuit(List<String> cuitList);
}
