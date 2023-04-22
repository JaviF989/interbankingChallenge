package org.favilli.interbanking.challenge.api.infrastructure.mapper;

import org.favilli.interbanking.challenge.api.domain.model.Company;
import org.favilli.interbanking.challenge.api.infrastructure.adapter.output.entities.CompanyEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyEntityToCompanyDTO implements IMapper<CompanyEntity, Company> {


    @Override
    public Company map(CompanyEntity in) {
        return Company.builder()
                .cuit(in.getCuit())
                .businessName(in.getBusinessName())
                .accessionDate(in.getAccessionDate())
                .build();
    }

    public List<Company> map (List<CompanyEntity> companyEntityList){
        List<Company> companyList = new ArrayList<>();
        companyEntityList.forEach(companyEntity -> companyList.add(this.map(companyEntity)));
        return companyList;
    }
}
