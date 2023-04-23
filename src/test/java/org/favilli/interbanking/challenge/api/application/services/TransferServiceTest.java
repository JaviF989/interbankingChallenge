package org.favilli.interbanking.challenge.api.application.services;

import org.favilli.interbanking.challenge.api.application.ports.input.SearchCompaniesCuitWithActiveTransfersPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TransferServiceTest {

    @Mock
    private SearchCompaniesCuitWithActiveTransfersPort searchCompaniesCuitWithActiveTransfersPort;

    @InjectMocks
    private TransferService transferService;

    List<String> cuits;
    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        cuits = Arrays.asList("012345678901", "012345678910");
    }
    @Test
    void getCompaniesWithActiveTransfersTest() {
        when(searchCompaniesCuitWithActiveTransfersPort.getCompaniesWithActiveTransfers()).thenReturn(cuits);
        assertEquals(2, transferService.getCompaniesWithActiveTransfers().size());
        assertTrue(transferService.getCompaniesWithActiveTransfers().contains("012345678901"));
    }
}