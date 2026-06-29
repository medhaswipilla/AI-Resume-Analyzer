package com.resume.airesumeanalyzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.resume.airesumeanalyzer.model.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

}
