package com.example.service.impl;

import com.example.model.QuestionContent;
import com.example.reposotory.IQuestionContentRepository;
import com.example.service.IQuestionContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionContentService implements IQuestionContentService {
    @Autowired
    private IQuestionContentRepository iQuestionContentRepository;

    @Override
    public List<QuestionContent> findAll() {
        return iQuestionContentRepository.findAll();
    }

    @Override
    public Optional<QuestionContent> findById(int id) {
        return iQuestionContentRepository.findById(id);
    }

    @Override
    public void save(QuestionContent questionContent) {
        iQuestionContentRepository.save(questionContent);
    }

    @Override
    public void remove(int id) {
        iQuestionContentRepository.deleteById(id);
    }

    @Override
    public Page<QuestionContent> search(Pageable pageable) {
        return iQuestionContentRepository.search(pageable);
    }

    @Override
    public Page<QuestionContent> search(Pageable pageable, String title, String questionTypeId) {
        return iQuestionContentRepository.search(pageable, title, questionTypeId);
    }

    @Override
    public void delete(int deleteId) {
        iQuestionContentRepository.delete(deleteId);
    }
}
