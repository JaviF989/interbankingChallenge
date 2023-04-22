package org.favilli.interbanking.challenge.api.infrastructure.adapter.output.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEntity {

    @Id
    @Column(name = "cuit", length = 13)
    private String cuit;
    @Column(name = "business_name")
    private String businessName;
    @Column(name = "accession_date")
    private LocalDate accessionDate;

}
