package org.favilli.interbanking.challenge.api.application.usecases;

import org.favilli.interbanking.challenge.api.application.ports.output.CompanyRepositoryPort;
import org.favilli.interbanking.challenge.api.domain.model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

class SearchNewCompaniesPortImplTest {

    @Mock
    private CompanyRepositoryPort companyRepositoryPort;

    @InjectMocks
    private SearchNewCompaniesPortImpl searchNewCompaniesPortImpl;
    List<Company> companyList = new ArrayList<>();
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Company companyA = Company.builder()
                .cuit("12345678910")
                .businessName("Company A")
                .accessionDate(LocalDate.now().minusDays(3))
                .build();
        Company companyB = Company.builder()
                .cuit("01234567890")
                .businessName("Company B")
                .accessionDate(LocalDate.now().minusDays(28))
                .build();
        companyList.add(companyA);
        companyList.add(companyB);
    }

    @Test
    void getNewCompaniesTest() {
        when(companyRepositoryPort.getNewCompanies(LocalDate.now())).thenReturn(companyList);
        assertNotNull(searchNewCompaniesPortImpl.getNewCompanies());
    }
}