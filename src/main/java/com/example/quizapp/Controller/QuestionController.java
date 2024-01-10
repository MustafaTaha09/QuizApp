package com.example.quizapp.Controller;

import com.example.quizapp.Model.Question;
import com.example.quizapp.Service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {


    private QuestionsService questionsService;

    @Autowired
    public QuestionController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

//    @GetMapping("/allQuestions")
//    public ResponseEntity<List<Question>> getAllQuestions() {
//
//        return questionsService.getAllQuestions();
//    }

    @GetMapping("/difficultyLevel/{difficulty_level}")
    public ResponseEntity<List<Question>> getCategorizedQuestions(@PathVariable("difficulty_level") String difficulty_level) {
        return questionsService.getCategorizedQuestions(difficulty_level);
    }

//    @PostMapping("/addQuestion")
//    public ResponseEntity<String> addQuestion(@RequestBody Question question){ //@RequestBody even when adding to the DB, bcz it allows u to send Data from the client(u) to the server. When removed, it won't  work!
//      return questionsService.addQuestion(question);
//
//    }
//
//    @DeleteMapping("delete/{id}")
//    public ResponseEntity<String> deleteQuestion(@PathVariable("id") Integer id){
//        return questionsService.deleteQuestionById(id);
//    }
//
//    @PutMapping("update/{id}")
//    public ResponseEntity<String> updateQuestion(@PathVariable("id") Integer id,
//                                                 @RequestParam(required = true) String questionTitle){
//        return questionsService.updateQuestionById(id, questionTitle);
//    }

}
