package org.favilli.interbanking.challenge.api.infrastructure.adapter.input;

import org.favilli.interbanking.challenge.api.application.services.CompanyService;
import org.favilli.interbanking.challenge.api.context.WebAdapter;
import org.favilli.interbanking.challenge.api.domain.model.Company;
import org.favilli.interbanking.challenge.api.application.ports.input.InputCompanyPort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @PostMapping("/create")
    public Company createCompany(@RequestBody InputCompanyPort inputCompany){
        return this.companyService.createCompany(inputCompany);
    }
    @GetMapping("/search/recent")
    public List<Company> getNewCompanies(){
        return this.companyService.getNewCompanies();
    }

    @GetMapping("search/with_recent_transfers")
    public List<Company> getCompaniesWithRecentTransfers(){
        return this.companyService.getActiveCompaniesByCuit();
    }

}
