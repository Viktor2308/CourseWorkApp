package me.coursework.examapp.services.impl;

import lombok.AllArgsConstructor;
import me.coursework.examapp.exeption.ValidationException;
import me.coursework.examapp.model.Question;
import me.coursework.examapp.services.ExaminerService;
import me.coursework.examapp.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    @Override
    public Set<Question> getQuestion(int amount) {
        if (!validate(amount)) {
            throw new ValidationException(Integer.toString(amount));
        }
        Set<Question> questionSet = new HashSet<>();
        while (questionSet.size() < amount) {
            questionSet.add(questionService.getRandomQuestion());
        }
        return questionSet;
    }

    public boolean validate(int amount) {
        if (amount <= 0 || amount > questionService.getAllQuestion().size()) {
            throw new ValidationException(String.valueOf(amount));
        }
        return true;
    }
}
