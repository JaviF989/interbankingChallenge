package org.favilli.interbanking.challenge.api.infrastructure.adapter.output.repositories;

import org.favilli.interbanking.challenge.api.infrastructure.adapter.output.entities.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransferRepositoryJPA extends JpaRepository <TransferEntity, Long> {
    @Query(value = "SELECT DISTINCT `cuit` FROM `transfer` WHERE `date` >=:fromDate", nativeQuery = true)
    List<String> getCompaniesWithActiveTransactions(@Param("fromDate")LocalDate fromDate);
}
