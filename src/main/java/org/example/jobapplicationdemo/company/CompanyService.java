package org.example.jobapplicationdemo.company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
  List<Company> getAllCompanies();
  Optional<Company> getCompanyById(Long id);
  void createCompany(Company company);
  boolean updateCompanyById(Long id, Company updatedCompany);
  boolean deleteCompanyById(Long id);

}
