package org.favilli.interbanking.challenge.api.application.ports.input;

import org.favilli.interbanking.challenge.api.domain.model.Company;

import java.util.List;

public interface SearchActiveCompaniesByCuitPort {

    List<Company> getActiveCompaniesByCuit();
}
