package org.favilli.interbanking.challenge.api.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Builder
@ToString
public class Company {

    private String cuit;
    private String businessName;
    private LocalDate accessionDate;

    public LocalDate companyJoinDate(){
        return (this.getAccessionDate() == null) ? LocalDate.now() : this.getAccessionDate();
    }

}
