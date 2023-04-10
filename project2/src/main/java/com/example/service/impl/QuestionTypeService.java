package com.example.service.impl;

import com.example.model.QuestionType;
import com.example.reposotory.IQuestionTypeRepository;
import com.example.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    private IQuestionTypeRepository iQuestionTypeRepository;
    @Override
    public List<QuestionType> findAll() {
        return iQuestionTypeRepository.findAll();
    }

    @Override
    public Optional<QuestionType> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(QuestionType questionType) {

    }

    @Override
    public void remove(int id) {

    }
}
