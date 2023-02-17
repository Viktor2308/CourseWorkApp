package me.coursework.examapp.services;

import me.coursework.examapp.model.Question;

/**
 * Validation service
 */

public interface ValidationService {

    /**
     * validation of incoming data
     *
     * @param question - validation of object question
     * @return true if data valid
     */
    default boolean validate(Question question) {
        return false;
    }

//    /**
//     * validation of incoming data
//     *
//     * @param amount - count random questions
//     * @return true if the number is less than the size of elements in the questions collection
//     */
//    boolean validate(int amount);

}
