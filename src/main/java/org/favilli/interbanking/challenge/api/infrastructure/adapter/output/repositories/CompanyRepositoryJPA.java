package org.favilli.interbanking.challenge.api.infrastructure.adapter.output.repositories;

import org.favilli.interbanking.challenge.api.infrastructure.adapter.output.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CompanyRepositoryJPA extends JpaRepository<CompanyEntity, String> {

    public CompanyEntity findAllByCuit(String cuit);
    @Query(value = "SELECT * FROM `company` WHERE `accession_date` >=:fromDate", nativeQuery = true)
    List<CompanyEntity> findNewCompanies(@Param("fromDate") LocalDate fromDate);
}
