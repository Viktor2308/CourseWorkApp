package me.coursework.examapp.services.impl;

import lombok.AllArgsConstructor;
import me.coursework.examapp.exeption.ValidationException;
import me.coursework.examapp.model.Question;
import me.coursework.examapp.services.QuestionService;
import me.coursework.examapp.services.ValidationService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class JavaQuestionServiceImpl implements QuestionService {
    private final Set<Question> questionHashSet = new HashSet<>();
    private final ValidationService validationService;
    private final Random random = new Random();




    @Override
    public void addQuestion(String question, String answer) {
        Question inputQuestion = new Question(question, answer);
        if (!validationService.validate(inputQuestion)){
            throw new ValidationException(inputQuestion.toString());
        }
        questionHashSet.add(inputQuestion);
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
        Question inputQuestion = new Question(question, answer);
        if (!validationService.validate(inputQuestion)) {
            throw new ValidationException(inputQuestion.toString());
        }
        return questionHashSet.removeIf(questionToRemove -> questionToRemove.equals(inputQuestion));
    }

    @Override
    public Set<Question> getAllQuestion() {
        return Set.copyOf(questionHashSet);
    }

    @Override
    public Question getRandomQuestion() {
        Question randomQuestion = new Question();
        if (questionHashSet.size() > 0) {
            ArrayList<Question> questionsList = new ArrayList<>(questionHashSet);
            int num = random.nextInt(questionHashSet.size());
            randomQuestion = questionsList.get(num);
        }
        return randomQuestion;
    }
}
