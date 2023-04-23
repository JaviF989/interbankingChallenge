package org.favilli.interbanking.challenge.api.infrastructure.mapper;

import org.favilli.interbanking.challenge.api.domain.model.Company;
import org.favilli.interbanking.challenge.api.infrastructure.adapter.output.entities.CompanyEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyEntityToCompanyDTOTest {

    private CompanyEntityToCompanyDTO companyEntityToCompanyDTO = new CompanyEntityToCompanyDTO();
    private CompanyEntity firstEntity;
    private CompanyEntity secondEntity;
    private Company firstCompany;
    private Company secondCompany;
    @BeforeEach
    void setUp() {
        firstEntity = new CompanyEntity("12345678901", "firstCompany",
                LocalDate.now().minusDays(3));

        secondEntity = new CompanyEntity("12345678927", "secondCompany",
                LocalDate.now().minusDays(7));

        this.firstCompany = Company.builder()
                .cuit("12345678901")
                .businessName("firstCompany")
                .accessionDate(LocalDate.now().minusDays(3))
                .build();

        this.secondCompany = Company.builder()
                .cuit("12345678927")
                .businessName("secondCompany")
                .accessionDate(LocalDate.now().minusDays(7))
                .build();
    }

    @Test
    void mapTest() {
        assertEquals(firstCompany, companyEntityToCompanyDTO.map(firstEntity));
        assertEquals(secondCompany, companyEntityToCompanyDTO.map(secondEntity));
        assertNotEquals(firstCompany, companyEntityToCompanyDTO.map(secondEntity));
    }

    @Test
    void mapListTest() {
        List<CompanyEntity> companyEntityList = Arrays.asList( firstEntity, secondEntity);
        List<Company> companyList = companyEntityToCompanyDTO.map(companyEntityList);
        assertEquals(firstCompany, companyList.get(0));
        assertEquals(secondCompany,companyList.get(1));
    }
}