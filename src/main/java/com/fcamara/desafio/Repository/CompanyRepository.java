package com.fcamara.desafio.Repository;

import com.fcamara.desafio.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
