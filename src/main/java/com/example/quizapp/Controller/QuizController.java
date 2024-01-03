package com.example.quizapp.Controller;


import com.example.quizapp.Model.Question;
import com.example.quizapp.Model.QuestionWrapper;
import com.example.quizapp.Model.Response;
import com.example.quizapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/createQuiz/{difficultyLevel}")
    public ResponseEntity<String> createQuiz(@PathVariable("difficultyLevel") String diffLevel,
                                             @RequestParam(required = true) Integer numQ,
                                             @RequestParam(required = true) String title) {
        return quizService.createQuizByDifficultyLevel(diffLevel, numQ, title);
    }

    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestionsById(@PathVariable("id") Integer id) {
        return quizService.getQuizQuestionsById(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Float> submitResponse(@PathVariable("id") Integer id,
                                                @RequestBody List<Response> responses) {
        return quizService.calculateResponse(id, responses);
    }
}
