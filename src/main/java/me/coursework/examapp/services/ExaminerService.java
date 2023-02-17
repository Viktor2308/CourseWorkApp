package me.coursework.examapp.services;

import me.coursework.examapp.model.Question;

import java.util.Set;

public interface ExaminerService {
    /**
     * get random question
     *
     * @param amount random question/answer
     * @return Set collection random questions
     */
    Set<Question> getRandomQuestion(int amount);
}
