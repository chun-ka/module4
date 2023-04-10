package com.example.reposotory;

import com.example.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IStudentReposotory extends JpaRepository<Student, Integer> {
    @Query(value = "select * from student where flag=true", nativeQuery = true)
    Page<Student> search(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update student s set s.flag=false where s.id=:deleteId", nativeQuery = true)
    void delete(@Param("deleteId") int deleteId);


    @Query(value = "select * from student as s where s.flag=true and s.name like concat('%',:name,'%') and s.code like concat('%',:code,'%') and s.clazz_id like concat('%',:clazzId,'%')",
            countQuery ="select * from student as s where s.flag=true and s.name like concat('%',:name,'%') and s.code like concat('%',:code,'%') and s.clazz_id like concat('%',:clazzId,'%')" ,nativeQuery = true)
    Page<Student> search(Pageable pageable, @Param("name") String name, @Param("code") String code, @Param("clazzId") String clazzId);
    boolean existsByCode(String code);
}
