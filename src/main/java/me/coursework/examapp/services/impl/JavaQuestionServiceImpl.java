package me.coursework.examapp.services.impl;

import me.coursework.examapp.exeption.ValidationException;
import me.coursework.examapp.model.Question;
import me.coursework.examapp.services.JavaQuestionService;
import me.coursework.examapp.services.ValidationService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements JavaQuestionService {
    private final Set<Question> questionHashSet = new HashSet<>();
    private final ValidationService validationService;

    public JavaQuestionServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public void addQuestion(String question, String answer) {
        if (!validationService.validate(new Question(question, answer))) {
            throw new ValidationException(new Question(question, answer).toString());
        }
        questionHashSet.add(new Question(question, answer));
    }

    @Override
    public void addQuestion(Question question) {
        if (!validationService.validate(question)) {
            throw new ValidationException(question.toString());
        }
        questionHashSet.add(question);
    }

    @Override
    public boolean removeQuestion(String question, String answer) {
        if (!validationService.validate(new Question(question, answer))) {
            throw new ValidationException(new Question(question, answer).toString());
        }
        return questionHashSet.removeIf(questionToRemove -> questionToRemove.equals(new Question(question, answer)));
    }

    @Override
    public Set<Question> getAllQuestion() {
        return Set.copyOf(questionHashSet);
    }
}
