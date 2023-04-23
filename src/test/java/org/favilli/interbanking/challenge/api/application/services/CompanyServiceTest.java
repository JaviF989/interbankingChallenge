package org.favilli.interbanking.challenge.api.application.services;

import org.favilli.interbanking.challenge.api.application.ports.input.CreateCompanyPort;
import org.favilli.interbanking.challenge.api.application.ports.input.InputCompanyPort;
import org.favilli.interbanking.challenge.api.application.ports.input.SearchActiveCompaniesByCuitPort;
import org.favilli.interbanking.challenge.api.application.ports.input.SearchNewCompaniesPort;
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

class CompanyServiceTest {

    @Mock
    private CreateCompanyPort createCompanyPort;
    @Mock
    private SearchNewCompaniesPort searchNewCompaniesPort;
    @Mock
    private SearchActiveCompaniesByCuitPort searchActiveCompaniesByCuitPort;
    @InjectMocks
    private CompanyService companyService;
    private Company testCompany;
    private Company noTransferCompany;
    private Company oldCompany;
    private List<Company> companiesWithTransferList;
    private List<Company> newCompaniesList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        this.testCompany = Company.builder()
                .cuit("12345678901")
                .businessName("testCompany")
                .accessionDate(LocalDate.now())
                .build();

        this.noTransferCompany = Company.builder()
                .cuit("12345678906")
                .businessName("noTransferCompany")
                .accessionDate(LocalDate.now().minusDays(3))
                .build();

        this.oldCompany = Company.builder()
                .cuit("12345678917")
                .businessName("oldCompany")
                .accessionDate(LocalDate.now().minusMonths(11))
                .build();

        this.companiesWithTransferList = Arrays.asList(testCompany, oldCompany);
        this.newCompaniesList = Arrays.asList(testCompany, noTransferCompany);

    }

    @Test
    void createCompanyTest() {
        InputCompanyPort inputCompany = new InputCompanyPort("12345678901", "testCompany");

        when(this.createCompanyPort.createCompany(inputCompany)).thenReturn(this.testCompany);
        assertEquals(this.testCompany, this.companyService.createCompany(inputCompany));
    }

    @Test
    void getNewCompaniesTest() {
        when(this.searchNewCompaniesPort.getNewCompanies()).thenReturn(this.newCompaniesList);
        assertEquals(2, this.companyService.getNewCompanies().size());
        assertTrue(this.companyService.getNewCompanies().contains(noTransferCompany));
    }

    @Test
    void getActiveCompaniesByCuitTest() {
        when(this.searchActiveCompaniesByCuitPort.getActiveCompaniesByCuit()).thenReturn(this.companiesWithTransferList);
        assertEquals(2, this.companyService.getActiveCompaniesByCuit().size());
        assertTrue(this.companyService.getActiveCompaniesByCuit().contains(oldCompany));
    }
}