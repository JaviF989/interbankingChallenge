package org.favilli.interbanking.challenge.api.infrastructure.adapter.output.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEntity {

    @Id
    @Column(name = "cuit", length = 13)
    private String cuit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEntity that = (CompanyEntity) o;
        return Objects.equals(getCuit(), that.getCuit()) && Objects.equals(getBusinessName(), that.getBusinessName()) && Objects.equals(getAccessionDate(), that.getAccessionDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCuit(), getBusinessName(), getAccessionDate());
    }

    @Column(name = "business_name")
    private String businessName;
    @Column(name = "accession_date")
    private LocalDate accessionDate;

}
