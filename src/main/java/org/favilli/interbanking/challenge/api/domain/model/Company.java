package org.favilli.interbanking.challenge.api.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

@Data
@Builder
@ToString
public class Company {

    private String cuit;
    private String businessName;
    private LocalDate accessionDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(getCuit(), company.getCuit()) && Objects.equals(getBusinessName(), company.getBusinessName()) && Objects.equals(getAccessionDate(), company.getAccessionDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCuit(), getBusinessName(), getAccessionDate());
    }

    public LocalDate companyJoinDate(){
        return (this.getAccessionDate() == null) ? LocalDate.now() : this.getAccessionDate();
    }

}
