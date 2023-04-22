package org.favilli.interbanking.challenge.api.application.usecases;

import org.favilli.interbanking.challenge.api.application.ports.output.TransferRepositoryPort;
import org.favilli.interbanking.challenge.api.context.UseCase;
import org.favilli.interbanking.challenge.api.application.ports.input.SearchCompaniesCuitWithActiveTransfersPort;

import java.time.LocalDate;
import java.util.List;

@UseCase
public class SearchCompaniesCuitWithActiveTransfersPortImpl
        implements SearchCompaniesCuitWithActiveTransfersPort {

    public SearchCompaniesCuitWithActiveTransfersPortImpl
            (TransferRepositoryPort transactionRepositoryPort) {
        this.transactionRepositoryPort = transactionRepositoryPort;
    }

    TransferRepositoryPort transactionRepositoryPort;
    @Override
    public List<String> getCompaniesWithActiveTransfers() {
        LocalDate fromDate = LocalDate.now().minusMonths(1);
        return transactionRepositoryPort.getCompaniesCuitWithActiveTransfers(fromDate);
    }
}
