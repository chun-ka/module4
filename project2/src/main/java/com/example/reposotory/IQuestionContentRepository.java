package com.example.reposotory;

import com.example.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IQuestionContentRepository extends JpaRepository<QuestionContent,Integer> {

    @Query(value = "select * from question_content where flag=true order by status ",nativeQuery = true)
    Page<QuestionContent> search(Pageable pageable);
    @Query(value = "select * from question_content as q where q.flag=true and q.title like concat('%',:title,'%') and q.question_type_id like concat('%',:questionTypeId,'%') order by q.status,q.date desc ",
            countQuery ="select * from question_content as q where q.flag=true and q.title like concat('%',:title,'%') and q.question_type_id like concat('%',:questionTypeId,'%') order by q.status,q.date desc ",nativeQuery = true)
    Page<QuestionContent> search(Pageable pageable, @Param("title") String title, @Param("questionTypeId") String questionTypeId);

    @Transactional
    @Modifying
    @Query(value = "update question_content q set q.flag=false where q.id=:deleteId", nativeQuery = true)
    void delete(@Param("deleteId") int deleteId);
}
