package org.favilli.interbanking.challenge.api.infrastructure.adapter.input;

import org.favilli.interbanking.challenge.api.application.ports.input.InputCompanyPort;
import org.favilli.interbanking.challenge.api.application.services.CompanyService;
import org.favilli.interbanking.challenge.api.domain.model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CompanyController.class)
class CompanyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyService companyService;
    private Company testCompany;
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

        Company noTransferCompany = Company.builder()
                .cuit("12345678906")
                .businessName("noTransferCompany")
                .accessionDate(LocalDate.now().minusDays(3))
                .build();

        Company oldCompany = Company.builder()
                .cuit("12345678917")
                .businessName("oldCompany")
                .accessionDate(LocalDate.now().minusMonths(11))
                .build();

        this.companiesWithTransferList = Arrays.asList(testCompany, oldCompany);
        this.newCompaniesList = Arrays.asList(testCompany, noTransferCompany);
    }

    @Test
    void createCompany() throws Exception{
        InputCompanyPort request = new InputCompanyPort("12345678901","testCompany");
        when(companyService.createCompany(request)).thenReturn(testCompany);
        mockMvc.perform(post("/company/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"cuit\":\"12345678901\",\"businessName\":\"testCompany\"}"))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.cuit").value("12345678901"))
                .andExpect(jsonPath("$.businessName").value("testCompany"));
    }

    @Test
    void getNewCompaniesTest() throws Exception{
        when(companyService.getNewCompanies()).thenReturn(newCompaniesList);
        mockMvc.perform(get("/company/search/recent").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getCompaniesWithRecentTransfersTest() throws Exception{
        when(companyService.getActiveCompaniesByCuit()).thenReturn(companiesWithTransferList);
        mockMvc.perform(get("/company/search/with_recent_transfers").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}