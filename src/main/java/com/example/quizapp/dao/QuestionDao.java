package com.example.quizapp.dao;

import com.example.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionDao extends  JpaRepository<Question,Integer>{

 List<Question> findByCategory(String category);//in findByCategory the category is the part of the table
}
