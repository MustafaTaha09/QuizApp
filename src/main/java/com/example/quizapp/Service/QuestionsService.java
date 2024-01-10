package com.example.quizapp.Service;

import com.example.quizapp.Model.Question;
import com.example.quizapp.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionsService(QuestionRepository _questionRepository) {
        this.questionRepository = _questionRepository;
    }

//    public ResponseEntity<List<Question>> getAllQuestions() {
//        try {
//            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(new ArrayList<>(), HttpStatusCode.valueOf(555));
//    }


    public ResponseEntity<List<Question>> getCategorizedQuestions(String difficulty_level) {

        //Implementing a validation check on difficulty level.
//        Assert.isTrue(questionRepository.existsByDifficultyLevel(difficulty_level), "Difficulty Level " + difficulty_level + " Doesn't exist!");

        //Implementing a validation check on difficulty level using Response Entity.
        if (questionRepository.existsByDifficultyLevel(difficulty_level))
            return new ResponseEntity<>(questionRepository.findByDifficultyLevel(difficulty_level), HttpStatus.OK);
        else
            return new ResponseEntity<>(new ArrayList<>(), HttpStatusCode.valueOf(555));

    }

//    public ResponseEntity<String> addQuestion(Question question) {
//
//        //A validation check on whether the Question ID Already exists.
////      Assert.isTrue(!questionRepository.existsById(Long.valueOf(question.getId())), "This Question ID: " + question.getId() + " Already Exists in the Quiz!");
//
//        //A validation Check on whether the question title already exists or not.
//        //Assert.isTrue(!questionRepository.existsByQuestionTitle(question.getQuestionTitle()), "Question: " + question.getQuestionTitle() + " Already Exists in the Quiz!");
//
//        //A validation Check on whether the question title already exists or not using Response Entity.
//        if (questionRepository.existsByQuestionTitle(question.getQuestionTitle())) {
//            return new ResponseEntity<>("Question: " + question.getQuestionTitle() + " Already Exists!", HttpStatus.BAD_REQUEST);
//        } else {
//            questionRepository.save(question);
//            return new ResponseEntity<>("Your question has been saved!", HttpStatus.CREATED);
//        }
//
////        questionRepository.save(question);
////        return "Question: " + question.getQuestionTitle() + " were Added Successfully";
//    }

//    public ResponseEntity<String> deleteQuestionById(Integer id) {
//        //Validation check on the existence of the QuestionID to be removed.
////        Assert.isTrue(questionRepository.existsById(id.longValue()), "Question ID: " + id + " to be deleted doesn't exist in the Quizz!");
////        questionRepository.deleteById(Long.valueOf(id));
//
//        if (questionRepository.existsById(id.longValue())) {
//            questionRepository.deleteById(Long.valueOf(id));
//            return new ResponseEntity<>("Deletion of Question Id: " + id + " is successful!", HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("Question ID: " + id + " to be deleted doesn't exist in the Quizz!", HttpStatus.BAD_REQUEST);
//        }
//    }


//    public ResponseEntity<String> updateQuestionById(Integer id, String questionTitle) {
//
//        if(questionRepository.existsById(id.longValue())) {
//            Question q = questionRepository.findById(id.longValue()).orElseThrow(() -> new IllegalStateException("Question Id: " + id + " doesn't exist!"));
//            q.setQuestionTitle(questionTitle);
//            questionRepository.save(q);
//            return new ResponseEntity<>("QuestionID: " + id + " is updated!", HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>("There is no Question of ID " + id +" to be updated!", HttpStatus.BAD_REQUEST);
//
//    }
}
