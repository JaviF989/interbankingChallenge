package org.favilli.interbanking.challenge.api.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

@Data
@Builder
public class Transfer {

    private long id;
    private String cuit;
    private double amount;
    private String debitAccount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return getId() == transfer.getId() && Double.compare(transfer.getAmount(), getAmount()) == 0 && Objects.equals(getCuit(), transfer.getCuit()) && Objects.equals(getDebitAccount(), transfer.getDebitAccount()) && Objects.equals(getCreditAccount(), transfer.getCreditAccount()) && Objects.equals(getDate(), transfer.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCuit(), getAmount(), getDebitAccount(), getCreditAccount(), getDate());
    }

    private String creditAccount;
    private LocalDate date;

}
