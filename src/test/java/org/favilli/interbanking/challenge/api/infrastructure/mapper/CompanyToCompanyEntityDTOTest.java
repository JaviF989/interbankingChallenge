package org.favilli.interbanking.challenge.api.infrastructure.mapper;

import org.favilli.interbanking.challenge.api.domain.model.Company;
import org.favilli.interbanking.challenge.api.infrastructure.adapter.output.entities.CompanyEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CompanyToCompanyEntityDTOTest {
    private CompanyEntity firstEntity;
    private CompanyEntity secondEntity;
    private Company firstCompany;
    private Company secondCompany;

    private CompanyToCompanyEntityDTO companyToCompanyEntityDTO = new CompanyToCompanyEntityDTO();
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
        assertEquals(firstEntity, companyToCompanyEntityDTO.map(firstCompany));
        assertEquals(secondEntity, companyToCompanyEntityDTO.map(secondCompany));
        assertNotEquals(firstEntity, companyToCompanyEntityDTO.map(secondCompany));
    }
}