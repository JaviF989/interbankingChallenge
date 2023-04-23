package org.favilli.interbanking.challenge.api.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    private Company testCompany;
    private Company duplicateCompany;
    private Company anotherCompany;

    @BeforeEach
    void setup(){
        this.testCompany = Company.builder()
                .cuit("12345678901")
                .businessName("testCompany")
                .accessionDate(LocalDate.now().minusDays(3))
                .build();

        this.duplicateCompany = Company.builder()
                .cuit("12345678901")
                .businessName("testCompany")
                .accessionDate(LocalDate.now().minusDays(3))
                .build();

        this.anotherCompany = Company.builder()
                .cuit("12345678910")
                .businessName("testCompany")
                .accessionDate(LocalDate.now().minusDays(3))
                .build();
    }

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

    @Test
    void companyBuilderTest(){
        assertEquals("12345678901", testCompany.getCuit());
        assertEquals("testCompany", testCompany.getBusinessName());
        assertEquals(LocalDate.now().minusDays(3), testCompany.companyJoinDate());
    }

    @Test
    void compareCompanyEquals(){
        assertEquals(testCompany, duplicateCompany);
        assertFalse(testCompany.equals(anotherCompany));
    }

    @Test
    void compareCompanyHash(){
        assertEquals(testCompany.hashCode(), duplicateCompany.hashCode());
        assertNotEquals(testCompany.hashCode(), anotherCompany.hashCode());
    }

}