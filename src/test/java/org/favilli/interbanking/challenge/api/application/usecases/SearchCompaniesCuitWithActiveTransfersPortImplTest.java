package org.favilli.interbanking.challenge.api.application.usecases;

import org.favilli.interbanking.challenge.api.application.ports.output.TransferRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
class SearchCompaniesCuitWithActiveTransfersPortImplTest {

    @Mock
    private TransferRepositoryPort transferRepositoryPort;

    @InjectMocks
    private SearchCompaniesCuitWithActiveTransfersPortImpl searchCompaniesCuitWithActiveTransfersPortImpl;

    private List<String> cuitsList;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cuitsList = Arrays.asList("12345678910", "01234567890");
    }

    @Test
    void getCompaniesWithActiveTransfers() {
        when(transferRepositoryPort.getCompaniesCuitWithActiveTransfers(
                LocalDate.now().minusMonths(1))).thenReturn(cuitsList);
        assertNotNull(searchCompaniesCuitWithActiveTransfersPortImpl.getCompaniesWithActiveTransfers());
    }
}