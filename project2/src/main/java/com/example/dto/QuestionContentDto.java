package com.example.dto;


import com.example.model.QuestionType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class QuestionContentDto {
    private int id;
    @NotEmpty(message = "Không được bỏ trống")
    @Size(min = 5, max = 100)
    private String title;
    @NotEmpty(message = "Không được bỏ trống")
    @Size(min = 10, max = 500)

    private String content;

    private String answer="Bạn xem demo tại link:...";
    @NotEmpty(message = "Không được bỏ trống")

    private String date;

    private String status="chờ phản hồi";

    private QuestionType questionType;
    private boolean flag = true;

    public QuestionContentDto() {
    }

    public QuestionContentDto(int id, String title, String content, String answer, String date, String status, QuestionType questionType, boolean flag) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.date = date;
        this.status = status;
        this.questionType = questionType;
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
