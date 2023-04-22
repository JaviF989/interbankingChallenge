package org.favilli.interbanking.challenge.api.application.ports.output;

import java.time.LocalDate;
import java.util.List;

public interface TransferRepositoryPort {

    List<String> getCompaniesCuitWithActiveTransfers(LocalDate fromDate);
}
