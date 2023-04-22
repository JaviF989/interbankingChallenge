package org.favilli.interbanking.challenge.api.infrastructure.mapper;

import org.favilli.interbanking.challenge.api.domain.model.Company;
import org.favilli.interbanking.challenge.api.infrastructure.adapter.output.entities.CompanyEntity;
import org.springframework.stereotype.Component;

@Component
public class CompanyToCompanyEntityDTO implements IMapper<Company, CompanyEntity> {


    @Override
    public CompanyEntity map(Company in) {

        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setCuit(in.getCuit());
        companyEntity.setBusinessName(in.getBusinessName());
        companyEntity.setAccessionDate(in.companyJoinDate());

        return companyEntity;
    }
}
