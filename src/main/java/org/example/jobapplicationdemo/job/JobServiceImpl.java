package org.example.jobapplicationdemo.job;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

  private JobDao jobDao;

  @Override
  public List<Job> getAllJobs() {
    return jobDao.findAll();
  }

  @Override
  public Optional<Job> getJobById(Long id) {
    return jobDao.findById(id);
  }

  @Override
  public void createJob(Job job) {
    jobDao.save(job);
  }

  @Override
  public boolean updateJobById(Long id, Job updatedJob) {
    Optional<Job> jobOptional = jobDao.findById(id);
    if (jobOptional.isPresent()) {
      Job jobToUpdate = jobOptional.get();
      jobToUpdate.setTitle(updatedJob.getTitle());
      jobToUpdate.setDescription(updatedJob.getDescription());
      jobToUpdate.setMinSalary(updatedJob.getMinSalary());
      jobToUpdate.setMaxSalary(updatedJob.getMaxSalary());
      jobToUpdate.setLocation(updatedJob.getLocation());
      jobDao.save(jobToUpdate);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteJobById(Long id) {
    if (!jobDao.existsById(id)) {
      return false;
    }
    jobDao.deleteById(id);
    return true;
  }

}
