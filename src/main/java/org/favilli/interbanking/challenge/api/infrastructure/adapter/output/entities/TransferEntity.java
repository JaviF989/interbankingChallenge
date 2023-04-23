package org.favilli.interbanking.challenge.api.infrastructure.adapter.output.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "transfer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String cuit;
    private double amount;
    @Column(name = "debit_account")
    private String debitAccount;
    @Column(name = "credit_account")
    private String creditAccount;
    @Column(name = "dates")
    private LocalDate date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferEntity that = (TransferEntity) o;
        return getId() == that.getId() && Double.compare(that.getAmount(), getAmount()) == 0 && Objects.equals(getCuit(), that.getCuit()) && Objects.equals(getDebitAccount(), that.getDebitAccount()) && Objects.equals(getCreditAccount(), that.getCreditAccount()) && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCuit(), getAmount(), getDebitAccount(), getCreditAccount(), getDate());
    }
}
