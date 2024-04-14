package org.example.jobapplicationdemo.company;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

  private CompanyDao companyDao;

  @Override
  public List<Company> getAllCompanies() {
    return companyDao.findAll();
  }

  @Override
  public Optional<Company> getCompanyById(Long id) {
    return companyDao.findById(id);
  }

  @Override
  public void createCompany(Company company) {
    companyDao.save(company);
  }

  @Override
  public boolean updateCompanyById(Long id, Company updatedCompany) {
    Optional<Company> companyOptional = companyDao.findById(id);
    if (companyOptional.isPresent()) {
      Company companyToUpdate = companyOptional.get();
      companyToUpdate.setName(updatedCompany.getName());
      companyToUpdate.setDescription(updatedCompany.getDescription());
      companyToUpdate.setJobs(updatedCompany.getJobs());
      companyToUpdate.setReviews(updatedCompany.getReviews());
      companyDao.save(companyToUpdate);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteCompanyById(Long id) {
    if (!companyDao.existsById(id)) {
      return false;
    }
    companyDao.deleteById(id);
    //TODO - delete cascade if child jobs or reviews exists to avoid internal server error.
    return true;
  }

}
