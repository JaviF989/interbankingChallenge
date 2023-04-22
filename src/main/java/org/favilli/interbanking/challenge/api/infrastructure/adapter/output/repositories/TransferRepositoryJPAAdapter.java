package org.favilli.interbanking.challenge.api.infrastructure.adapter.output.repositories;

import org.favilli.interbanking.challenge.api.application.ports.output.TransferRepositoryPort;
import org.favilli.interbanking.challenge.api.context.PersistenceAdapter;

import java.time.LocalDate;
import java.util.List;

@PersistenceAdapter
public class TransferRepositoryJPAAdapter implements TransferRepositoryPort {

    private final TransferRepositoryJPA transferRepositoryJPA;
    public TransferRepositoryJPAAdapter(TransferRepositoryJPA transferRepositoryJPA) {
        this.transferRepositoryJPA = transferRepositoryJPA;
    }

    @Override
    public List<String> getCompaniesCuitWithActiveTransfers(LocalDate fromDate) {
        return transferRepositoryJPA.getCompaniesWithActiveTransactions(fromDate);
    }
}
