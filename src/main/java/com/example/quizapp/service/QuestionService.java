package com.example.quizapp.service;

import com.example.quizapp.dao.QuestionDao;
import com.example.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();

    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "success";

    }

    public String updateQuestion(int id, Question updatedQuestion) {
        if (questionDao.existsById(id)) {
            updatedQuestion.setId(id); // Ensure the ID remains the same
            questionDao.save(updatedQuestion);
            return "updated";
        }
        return "error";
    }

    public String deleteQuestion(int id) {
        if (questionDao.existsById(id)) {
             // Ensure the ID remains the same
            questionDao.deleteById(id);
            return "deleted";
        }
        return "error";
    }
    }


