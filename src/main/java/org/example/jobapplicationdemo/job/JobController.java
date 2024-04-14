package org.example.jobapplicationdemo.job;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/jobs")
public class JobController {

  private JobService jobService;

  @GetMapping
  public ResponseEntity<List<Job>> getAllJobs() {
    return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Job> getJobById(@PathVariable Long id) {
    Optional<Job> job = jobService.getJobById(id);
    return job.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping
  public ResponseEntity<String> createJob(@RequestBody Job job) {
    jobService.createJob(job);
    return new ResponseEntity<>("Job added successfully.", HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job updatedJob) {
    return jobService.updateJobById(id, updatedJob) ?
        new ResponseEntity<>("Job updated successfully.", HttpStatus.OK) :
        new ResponseEntity<>("Job not found.", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
    return jobService.deleteJobById(id) ?
        new ResponseEntity<>("Job deleted successfully.", HttpStatus.OK) :
        new ResponseEntity<>("Job not found.",HttpStatus.NOT_FOUND);
  }

}
