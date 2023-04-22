package org.favilli.interbanking.challenge.api.application.ports.input;

import org.favilli.interbanking.challenge.api.domain.model.Company;

public interface CreateCompanyPort {
    Company createCompany(InputCompanyPort inputCompanyPort);
}
