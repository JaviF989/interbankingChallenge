package org.favilli.interbanking.challenge.api.application.usecases;

import org.favilli.interbanking.challenge.api.application.ports.input.InputCompanyPort;
import org.favilli.interbanking.challenge.api.application.ports.output.CompanyRepositoryPort;
import org.favilli.interbanking.challenge.api.domain.model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

class CreateCompanyPortImplTest {

    @Mock
    private CompanyRepositoryPort companyRepositoryPort;
    @InjectMocks
    private CreateCompanyPortImpl createCompanyPortImpl;
    private InputCompanyPort inputCompanyPort;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.inputCompanyPort = new InputCompanyPort("12345678910", "Kiosco Potter");
    }

    @Test
    void createCompanyTest() {
        Company createdCompany = Company.builder()
                .cuit(inputCompanyPort.getCuit())
                .businessName(inputCompanyPort.getBusinessName())
                .accessionDate(LocalDate.now())
                .build();
        when(companyRepositoryPort.save(createdCompany)).thenReturn(createdCompany);
        Company savedCompany = createCompanyPortImpl.createCompany(inputCompanyPort);
        assertEquals(inputCompanyPort.getBusinessName(), createdCompany.getBusinessName());
    }
}