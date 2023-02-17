package me.coursework.examapp.services.impl;

import me.coursework.examapp.model.Question;
import me.coursework.examapp.services.ValidationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {


    @Override
    public boolean validate(Question question) {
        return question != null
                && !StringUtils.isEmpty(question.getQuestion())
                && !StringUtils.isEmpty(question.getAnswer());
    }


}
