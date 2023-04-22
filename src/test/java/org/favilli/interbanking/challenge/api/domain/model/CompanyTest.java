package org.favilli.interbanking.challenge.api.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    @Test
    void companyDefaultJoinDateTest() {
        Company company = Company.builder().build();
        assertEquals(LocalDate.now(), company.companyJoinDate());
    }

    @Test
    void companyWithJoinDateTest() {
        LocalDate beforeDate = LocalDate.now().minusDays(3);
        Company company = Company.builder()
                .accessionDate(beforeDate)
                .build();
        assertEquals(beforeDate, company.companyJoinDate());

        LocalDate anotherDate = LocalDate.now().minusDays(7);
        company.setAccessionDate(anotherDate);
        assertEquals(anotherDate, company.companyJoinDate());
    }
}