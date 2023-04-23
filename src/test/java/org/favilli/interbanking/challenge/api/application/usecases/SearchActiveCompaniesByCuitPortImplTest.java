package org.favilli.interbanking.challenge.api.application.usecases;

import org.favilli.interbanking.challenge.api.application.ports.output.CompanyRepositoryPort;
import org.favilli.interbanking.challenge.api.application.services.TransferService;
import org.favilli.interbanking.challenge.api.domain.model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SearchActiveCompaniesByCuitPortImplTest {

    @Mock
    private TransferService transferService;

    @Mock
    private CompanyRepositoryPort companyRepositoryPort;
    @InjectMocks
    private SearchActiveCompaniesByCuitPortImpl searchActiveCompaniesByCuitPortImpl;

    private List<Company> companyList;
    private List<String> cuitsList;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cuitsList = Arrays.asList("12345678910", "01234567890");
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
        companyList = Arrays.asList(companyA, companyB);
    }

    @Test
    void getActiveCompaniesByCuitTest() {
        when(transferService.getCompaniesWithActiveTransfers()).thenReturn(cuitsList);
        when(companyRepositoryPort.getCompaniesByCuit(cuitsList)).thenReturn(companyList);
        assertNotNull(searchActiveCompaniesByCuitPortImpl.getActiveCompaniesByCuit());
        assertEquals(2, searchActiveCompaniesByCuitPortImpl.getActiveCompaniesByCuit().size());
    }
}