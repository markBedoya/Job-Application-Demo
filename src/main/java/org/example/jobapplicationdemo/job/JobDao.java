package org.example.jobapplicationdemo.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDao extends JpaRepository<Job, Long> {

}
