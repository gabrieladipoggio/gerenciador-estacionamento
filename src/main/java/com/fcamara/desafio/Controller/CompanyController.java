package com.fcamara.desafio.Controller;

import com.fcamara.desafio.Model.Company;
import com.fcamara.desafio.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path="/company")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping(path = "/add")
    public ResponseEntity<Company> addCompany(@RequestBody @Valid Company company, UriComponentsBuilder uriBuilder) {
        companyRepository.save(company);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/list")
    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }
}
