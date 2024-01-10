package com.example.quizapp.Service;

import com.example.quizapp.Model.Question;
import com.example.quizapp.Model.QuestionWrapper;
import com.example.quizapp.Model.Quiz;
import com.example.quizapp.Model.Response;
import com.example.quizapp.Repository.QuestionRepository;
import com.example.quizapp.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }


    public ResponseEntity<String> createQuizByDifficultyLevel(String diffLevel, Integer numQ, String title) {
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        List<Question> questions = questionRepository.findRandomQuestionsByDifficultyLevel(diffLevel, numQ);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<>("Quiz ID: " + quiz.getId() + " Were created based on DifficultyLevel: " + diffLevel, HttpStatus.CREATED);
    }

//    public ResponseEntity<List<QuestionWrapper>> getQuizQuestionsById(Integer id) {
//        Optional<Quiz> quiz = quizRepository.findById(id);
//        if (quiz.isPresent()) {
//            List<Question> questionsFromDB = quiz.get().getQuestions();
//            List<QuestionWrapper> questionsToUser = new ArrayList<>();
//            for(Question q : questionsFromDB){
//                QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
//                questionsToUser.add(qw);
//            }
//            return new ResponseEntity<>(questionsToUser, HttpStatus.OK);
//        }
//        System.err.println("Quiz of ID: " + id + " Doesn't exist!");
//        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
//
//
//    }

    //Calculating the Answers submitted by the user
    public ResponseEntity<Float> calculateResponse(Integer id, List<Response> responses) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        if(quiz.isPresent()){ // Validating if the quiz is present
            List<Question> questions = quiz.get().getQuestions();
            float right = 0;
            int i = 0;
            for(Question q : questions){
                for(Response r : responses){ //This extra inner loop is to make sure that it will get the right score even if the user submitted the answers not in the same arrangement as the quiz's questions.
                    if(r.getId().equals(q.getId())){
                        if(q.getRightAnswer().equals(r.getAnswer()))
                            right++;
                        i++;
                    }
                }
                i=0;
            }
            return new ResponseEntity<>(right/questions.size() * 100, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(0F, HttpStatus.BAD_REQUEST);
        }

    }
}
