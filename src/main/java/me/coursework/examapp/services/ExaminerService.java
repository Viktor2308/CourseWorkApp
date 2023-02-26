package me.coursework.examapp.services;

import me.coursework.examapp.model.Question;

import java.util.Set;

public interface ExaminerService {
    /**
     * get random amount question
     * @param amount count of random question
     * @return collection random question
     */
    Set<Question> getQuestion(int amount);
}
