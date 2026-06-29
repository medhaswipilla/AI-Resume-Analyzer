package com.resume.airesumeanalyzer.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "resumes")
@Data
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String fileName;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String resumeText;

    private Integer resumeScore;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String strengths;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String weaknesses;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String missingSkills;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String suggestions;
}