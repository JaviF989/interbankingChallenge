package org.favilli.interbanking.challenge.api.infrastructure.adapter.output.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class TransferRepositoryJPAAdapterTest {

    @Mock
    TransferRepositoryJPA transferRepositoryJPA;
    @InjectMocks
    TransferRepositoryJPAAdapter transferRepositoryJPAAdapter;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCompaniesCuitWithActiveTransfers() {
        assertNotNull(transferRepositoryJPA.getCompaniesWithActiveTransactions(LocalDate.now().minusMonths(1)));
    }
}