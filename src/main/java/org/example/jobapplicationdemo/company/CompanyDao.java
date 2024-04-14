package org.example.jobapplicationdemo.company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDao extends JpaRepository<Company, Long> {

}
