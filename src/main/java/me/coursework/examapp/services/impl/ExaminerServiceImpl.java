package me.coursework.examapp.services.impl;

import me.coursework.examapp.exeption.ValidationException;
import me.coursework.examapp.model.Question;
import me.coursework.examapp.services.ExaminerService;
import me.coursework.examapp.services.JavaQuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    Random random = new Random();

    @Override
    public Set<Question> getRandomQuestion(int amount) {
        Set<Question> randomQuestion = new HashSet<>();
        if (validate(amount) && questionService.getAllQuestion().size() > 0) {
            ArrayList<Question> questions = new ArrayList<>(questionService.getAllQuestion());
            while (randomQuestion.size() < amount) {
                int num = random.nextInt(questionService.getAllQuestion().size());
                randomQuestion.add(questions.get(num));
            }
        }
        return randomQuestion;
    }

    public boolean validate(int amount) {
        if (amount <= 0 || amount > questionService.getAllQuestion().size()) {
            throw new ValidationException(String.valueOf(amount));
        }
        return true;
    }
}
