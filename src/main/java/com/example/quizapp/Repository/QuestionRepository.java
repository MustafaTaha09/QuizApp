package com.example.quizapp.Repository;

import com.example.quizapp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

//    @Query("select q from Question q where q.difficultyLevel=:cate")
    List<Question> findByDifficultyLevel(String difficulty_level);

    boolean existsByDifficultyLevel(String difficulty_level);

    boolean existsByQuestionTitle(String questionTitle);

    // Picks random Questions for a quiz limited by specific number of Questions based on the difficulty Level
    @Query(value = "Select * from question q where q.difficulty_level=:diffLevel ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByDifficultyLevel(String diffLevel, Integer numQ);


//    void updateByQuestionTitle(String questionTitle);
}

