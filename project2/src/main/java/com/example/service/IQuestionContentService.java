package com.example.service;

import com.example.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IQuestionContentService extends IService<QuestionContent>{
    Page<QuestionContent> search(Pageable pageable);
    Page<QuestionContent> search(Pageable pageable, String title, String questionTypeId);
    void delete( int deleteId);


}
