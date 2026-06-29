package com.resume.airesumeanalyzer.controller;

import com.resume.airesumeanalyzer.model.Resume;
import com.resume.airesumeanalyzer.service.GeminiService;
import com.resume.airesumeanalyzer.service.PdfService;
import com.resume.airesumeanalyzer.service.ResumeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ResumeController {

    @Autowired
    private PdfService pdfService;

    @Autowired
    private GeminiService geminiService;

    @Autowired
    private ResumeService resumeService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/analyze")
    public String analyzeResume(@RequestParam("name") String name,
                                @RequestParam("email") String email,
                                @RequestParam("resume") MultipartFile file,
                                Model model) {

        try {

            // Extract Resume Text
            String resumeText = pdfService.extractText(file);

            // AI Prompt
            String prompt = """
You are an ATS Resume Analyzer.

Analyze the following resume.

Return ONLY plain text.

Do NOT return JSON.

Do NOT return Markdown.

Return exactly like this:

Resume Score : 85/100

Job Match :
Java Full Stack Developer

Strengths
1.
2.
3.

Weaknesses
1.
2.
3.

Missing Skills
1.
2.
3.

Suggestions
1.
2.
3.

Resume:

""" + resumeText;

            // Gemini Response
            String aiResponse = geminiService.askGemini(prompt);

            // Save to Database
            Resume resume = new Resume();

            resume.setName(name);
            resume.setEmail(email);
            resume.setFileName(file.getOriginalFilename());
            resume.setResumeText(resumeText);
            resume.setSuggestions(aiResponse);

            resumeService.saveResume(resume);

            // Send Data to HTML
            model.addAttribute("name", name);
            model.addAttribute("email", email);
            model.addAttribute("resumeText", resumeText);
            model.addAttribute("aiResponse", aiResponse);

        } catch (Exception e) {

            e.printStackTrace();

            model.addAttribute("aiResponse",
                    "Error : " + e.getMessage());

        }

        return "result";
    }

    @PostMapping("/questions")
public String generateQuestions(@RequestParam("resumeText") String resumeText,
                                Model model) {

    String prompt = """
You are an interview coach.

Based on this resume generate:

1. Five Java Interview Questions

2. Five SQL Interview Questions

3. Five HR Interview Questions

Resume:

""" + resumeText;

    String questions = geminiService.askGemini(prompt);

    model.addAttribute("questions", questions);

    return "questions";
}

}