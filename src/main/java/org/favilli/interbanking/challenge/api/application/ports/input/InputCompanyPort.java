package org.favilli.interbanking.challenge.api.application.ports.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputCompanyPort {

    private String cuit;
    private String businessName;

}
