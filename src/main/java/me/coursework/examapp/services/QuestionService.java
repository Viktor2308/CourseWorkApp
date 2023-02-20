package me.coursework.examapp.services;

import me.coursework.examapp.model.Question;

import java.util.Set;

/**
 * service for work with questions
 */


public interface QuestionService {

    /**
     * add new question & answer
     *
     * @param question - question
     * @param answer   - answer for question
     */
    void addQuestion(String question, String answer);

    /**
     * add new object question
     *
     * @param question - question class object
     */
    void addQuestion(Question question);

    /**
     * remove question
     *
     * @param question - remove object question
     * @return true if object remove
     */
    boolean removeQuestion(String question, String answer);

    /**
     * get all object question
     *
     * @return Set collection questions
     */
    Set<Question> getAllQuestion();

    /**
     * get random question
     *
     * @return Set collection random questions
     */
    Question getRandomQuestion();

}
