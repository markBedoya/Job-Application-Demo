package org.example.jobapplicationdemo.job;

import java.util.List;
import java.util.Optional;

public interface JobService {
  List<Job> getAllJobs();
  Optional<Job> getJobById(Long id);
  void createJob(Job job);
  boolean updateJobById(Long id, Job updatedJob);
  boolean deleteJobById(Long id);
}
