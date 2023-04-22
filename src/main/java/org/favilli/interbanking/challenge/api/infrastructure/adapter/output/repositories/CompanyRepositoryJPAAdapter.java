package org.favilli.interbanking.challenge.api.infrastructure.adapter.output.repositories;

import org.favilli.interbanking.challenge.api.context.PersistenceAdapter;
import org.favilli.interbanking.challenge.api.domain.model.Company;
import org.favilli.interbanking.challenge.api.application.ports.output.CompanyRepositoryPort;
import org.favilli.interbanking.challenge.api.infrastructure.adapter.output.entities.CompanyEntity;
import org.favilli.interbanking.challenge.api.infrastructure.mapper.CompanyEntityToCompanyDTO;
import org.favilli.interbanking.challenge.api.infrastructure.mapper.CompanyToCompanyEntityDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@PersistenceAdapter
public class CompanyRepositoryJPAAdapter implements CompanyRepositoryPort {

    private final CompanyRepositoryJPA companyRepositoryJPA;
    private final CompanyToCompanyEntityDTO companyToCompanyEntityDTO;
    private final CompanyEntityToCompanyDTO companyEntityToCompanyDTO;
    public CompanyRepositoryJPAAdapter(CompanyRepositoryJPA companyRepositoryJPA,
                                       CompanyToCompanyEntityDTO companyToCompanyEntityDTO,
                                       CompanyEntityToCompanyDTO companyEntityToCompanyDTO) {
        this.companyRepositoryJPA = companyRepositoryJPA;
        this.companyToCompanyEntityDTO = companyToCompanyEntityDTO;
        this.companyEntityToCompanyDTO = companyEntityToCompanyDTO;
    }

    @Override
    public Company save(Company company) {
        CompanyEntity newCompany = companyToCompanyEntityDTO.map(company);
        CompanyEntity savedEntity = companyRepositoryJPA
                .save(newCompany);
        return companyEntityToCompanyDTO.map(savedEntity);
    }

    @Override
    public List<Company> getNewCompanies(LocalDate fromDate) {
        List<CompanyEntity> companyJoinLastMonth = companyRepositoryJPA.findNewCompanies(fromDate);
        return this.companyEntityToCompanyDTO.map(companyJoinLastMonth);
    }

    @Override
    public List<Company> getCompaniesByCuit(List<String> cuitList) {
        List<CompanyEntity> companyEntityList = new ArrayList<>();
        cuitList.forEach(cuit -> companyEntityList.add(this.companyRepositoryJPA.findAllByCuit(cuit)));
        return this.companyEntityToCompanyDTO.map(companyEntityList);
    }
}
