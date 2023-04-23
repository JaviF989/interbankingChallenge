package org.favilli.interbanking.challenge.api.infrastructure.adapter.output.repositories;

import org.favilli.interbanking.challenge.api.infrastructure.adapter.output.entities.CompanyEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CompanyRepositoryJPAAdapterTest {

    @Autowired
    CompanyRepositoryJPA companyRepositoryJPA;

    private CompanyEntity defaultCompany;
    private CompanyEntity oldCompany;
    private CompanyEntity newCompany;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        defaultCompany = new CompanyEntity("012345678901", "Default business", LocalDate.of(2023,4,20));
        newCompany = new CompanyEntity("012345678902", "New business", LocalDate.of(2023,4,22));
        oldCompany = new CompanyEntity("012345678903", "Old business", LocalDate.of(2023,2,22));
    }

    @Test
    void saveTest() {
        CompanyEntity companyEntity = new CompanyEntity("012345678904","Old business", LocalDate.now());
        companyRepositoryJPA.save(companyEntity);

        assertEquals(companyEntity, companyRepositoryJPA.findAllByCuit("012345678904"));
    }

    @Test
    void getNewCompaniesTest() {
        assertFalse(companyRepositoryJPA.findNewCompanies(LocalDate.now().minusMonths(1)).isEmpty());
        assertEquals(2,companyRepositoryJPA.findNewCompanies(LocalDate.now().minusMonths(1)).size());
        assertTrue(companyRepositoryJPA.findNewCompanies(LocalDate.now().minusMonths(1)).contains(defaultCompany));
        assertFalse(companyRepositoryJPA.findNewCompanies(LocalDate.now().minusMonths(1)).contains(oldCompany));
    }

    @Test
    void getCompaniesByCuitTest() {
        assertEquals(defaultCompany, companyRepositoryJPA.findAllByCuit(defaultCompany.getCuit()));
        assertEquals(newCompany, companyRepositoryJPA.findAllByCuit(newCompany.getCuit()));
    }
}