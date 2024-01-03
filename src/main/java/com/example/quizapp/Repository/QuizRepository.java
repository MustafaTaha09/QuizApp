package com.example.quizapp.Repository;

import com.example.quizapp.Model.Question;
import com.example.quizapp.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {



}
