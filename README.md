# 🤖 AI Resume Analyzer

An AI-powered Resume Analyzer built using **Spring Boot**, **MySQL**, **Apache PDFBox**, and **Google Gemini AI**. The application allows users to upload a resume, extract its contents, analyze it using AI, and store the analysis in a MySQL database.

---

# 🏗️ Architecture

### Backend

* Java 17
* Spring Boot
* Spring MVC
* Spring Data JPA
* Maven

### Database

* MySQL

### AI Integration

* Google Gemini API

### PDF Processing

* Apache PDFBox

### Frontend

* Thymeleaf
* HTML
* CSS
* Bootstrap 5

---

# ✨ Features

## 📄 Resume Upload

* Upload PDF resumes
* Extract text using Apache PDFBox

## 🤖 AI Resume Analysis

* Resume Score
* Job Match
* Strengths
* Weaknesses
* Missing Skills
* Improvement Suggestions

## 💾 Database

* Store resume details
* Store extracted resume text
* Store AI analysis

---

# 📁 Project Structure

```
AIResumeAnalyzer
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.resume.airesumeanalyzer
│   │   │       ├── controller
│   │   │       ├── model
│   │   │       ├── repository
│   │   │       ├── service
│   │   │       └── AiResumeAnalyzerApplication.java
│   │   │
│   │   └── resources
│   │       ├── templates
│   │       ├── static
│   │       └── application.properties
│   │
│   └── test
│
├── pom.xml
└── README.md
```

---

# 🚀 Installation

## Clone Repository

```bash
git clone https://github.com/medhaswipilla/AI-Resume-Analyzer.git
```

## Open Project

```bash
cd AI-Resume-Analyzer
```

## Configure MySQL

Create a database:

```sql
CREATE DATABASE resume_ai;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/resume_ai
spring.datasource.username=your_username
spring.datasource.password=your_password

gemini.api.key=YOUR_GEMINI_API_KEY
```

---

## Run the Project

```bash
mvn spring-boot:run
```

Open:

```
http://localhost:8080
```

---

# 📊 Workflow

```
Upload Resume
      ↓
Extract PDF Text
      ↓
Gemini AI Analysis
      ↓
Store Results in MySQL
      ↓
Display Analysis
```

---

# 🛠️ Technologies Used

* Java 17
* Spring Boot
* Spring MVC
* Spring Data JPA
* MySQL
* Apache PDFBox
* Google Gemini API
* Thymeleaf
* Bootstrap
* Maven

---

# 🌟 Future Enhancements

* AI Interview Question Generator
* Cover Letter Generator
* Resume History Dashboard
* Authentication System
* Resume Comparison
* ATS Score Visualization

---

# 👩‍💻 Author

**Medhaswi**

