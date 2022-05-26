package com.fcamara.desafio.Controller;

import com.fcamara.desafio.Model.Company;
import com.fcamara.desafio.Model.VehicleInGarage;
import com.fcamara.desafio.Repository.CompanyRepository;
import com.fcamara.desafio.Repository.VehicleInGarageRepository;
import com.opencsv.CSVWriter;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/company")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private VehicleInGarageRepository vehicleInGarageRepository;

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        companyRepository.save(company);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Long id){
       Company company = companyRepository.findById(id).get();
       return company;
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company){
        company.update(id, companyRepository);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Company> deleteCompany(@PathVariable Long id){
        companyRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(
            value="/report",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
    )
    public ResponseEntity<byte[]> generateReport(@RequestParam Long companyId) throws Exception {
        // Registration, type, time in, time out
        Optional<Company> company = companyRepository.findById(companyId);
        if(company.isPresent()){
            List<VehicleInGarage> vehicleInGarage = company.get().getVehiclesHistory();

            List<String[]> csvData = vehicleInGarage.stream()
                    .map(this::convertVehicleHistoryToCSV)
                    .collect(Collectors.toList());
            String[] header = {"registration", "type", "entry_time", "exit_time"};
            csvData.add(0, header);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
            CSVWriter writer = new CSVWriter(streamWriter);
            writer.writeAll(csvData);
            writer.flush();

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("Content-Type", "application/vnd.ms-excel");
            responseHeaders.add("Content-Disposition", "attachment; filename=report.csv");
            return new ResponseEntity<>(stream.toByteArray(), responseHeaders, HttpStatus.OK);
        }
        else {
           throw new Exception();
        }
        // Summary - total cars

    }

    private String[] convertVehicleHistoryToCSV(VehicleInGarage history){
        String[] entry = {
                history.getVehicle().getRegistration(),
                history.getVehicle().getType().toString(),
                history.getEntryTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm")),
                history.getExitTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm"))
        };
        return entry;
    }
}
