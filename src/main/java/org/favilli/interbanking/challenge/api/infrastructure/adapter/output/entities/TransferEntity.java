package org.favilli.interbanking.challenge.api.infrastructure.adapter.output.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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
    private LocalDate date;
}
