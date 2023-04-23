package org.favilli.interbanking.challenge.api.infrastructure.adapter.output.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class TransferRepositoryJPAAdapterTest {

    @InjectMocks
    TransferRepositoryJPAAdapter transferRepositoryJPAAdapter;
    @BeforeEach
    void setUp() {
    }

    @Test
    void getCompaniesCuitWithActiveTransfers() {
        //List<String> cuits = transferRepositoryJPAAdapter.getCompaniesCuitWithActiveTransfers(LocalDate.now());
    }
}