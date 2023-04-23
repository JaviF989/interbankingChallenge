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

    /**
     * Create a new @Company
     * @param inputCompany
     * @return status 200. @Company than we save
     */
    @PostMapping("/create")
    public Company createCompany(@RequestBody InputCompanyPort inputCompany){
        return this.companyService.createCompany(inputCompany);
    }

    /**
     * Search the companies than join us in the last month.
     * @return Status 200. List of @Company than join us the last month
     */
    @GetMapping("/search/recent")
    public List<Company> getNewCompanies(){
        return this.companyService.getNewCompanies();
    }

    /**
     * Search the companies than has transfers in the last month
     * @return Status 200. List of @Company than has transfers in the last month
     */
    @GetMapping("search/with_recent_transfers")
    public List<Company> getCompaniesWithRecentTransfers(){
        return this.companyService.getActiveCompaniesByCuit();
    }

}
