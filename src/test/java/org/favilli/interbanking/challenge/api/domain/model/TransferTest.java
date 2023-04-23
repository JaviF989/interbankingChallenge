package org.favilli.interbanking.challenge.api.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TransferTest {

    private Transfer testTransfer;
    private Transfer duplicateTransfer;
    private Transfer anotherTransfer;
    @BeforeEach
    void setup(){
        this.testTransfer = Transfer.builder()
                .id(1)
                .cuit("012345678901")
                .creditAccount("00000000054")
                .debitAccount("00000000067")
                .amount(560.50)
                .date(LocalDate.now())
                .build();

        this.duplicateTransfer = Transfer.builder()
                .id(1)
                .cuit("012345678901")
                .creditAccount("00000000054")
                .debitAccount("00000000067")
                .amount(560.50)
                .date(LocalDate.now())
                .build();

        this.anotherTransfer = Transfer.builder()
                .id(2)
                .cuit("012345678901")
                .creditAccount("00000000054")
                .debitAccount("00000000067")
                .amount(560.50)
                .date(LocalDate.now())
                .build();
    }
    @Test
    void transferBuilderTest() {
        assertEquals(1L, testTransfer.getId());
        assertEquals("012345678901", testTransfer.getCuit());
        assertEquals("00000000054", testTransfer.getCreditAccount());
        assertEquals("00000000067", testTransfer.getDebitAccount());
        assertEquals( 560.50, testTransfer.getAmount());
        assertEquals(LocalDate.now(), testTransfer.getDate());
    }

    @Test
    void compareTransferEquals(){
        assertEquals(testTransfer, duplicateTransfer);
        assertNotEquals(testTransfer, anotherTransfer);
    }

    @Test
    void compareTransferHash(){
        assertEquals(testTransfer.hashCode(), duplicateTransfer.hashCode());
        assertNotEquals(testTransfer.hashCode(), anotherTransfer.hashCode());
    }
}