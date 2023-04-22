package org.favilli.interbanking.challenge.api.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Transfer {

    private long id;
    private String cuit;
    private double amount;
    private String debitAccount;
    private String creditAccount;
    private LocalDate date;

}
