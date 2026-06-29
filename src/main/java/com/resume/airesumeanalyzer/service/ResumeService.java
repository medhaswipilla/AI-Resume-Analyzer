package com.resume.airesumeanalyzer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.airesumeanalyzer.model.Resume;
import com.resume.airesumeanalyzer.repository.ResumeRepository;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository repository;

    public Resume saveResume(Resume resume) {
        return repository.save(resume);
    }
}