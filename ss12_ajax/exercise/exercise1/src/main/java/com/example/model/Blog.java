package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id tự tăng
    private int id;
    private String title;
    @Column(columnDefinition = "text")//thay đổi kdl của column
    private String content;
    private String author;
    private String date;
    @ManyToOne(cascade = CascadeType.ALL) //tạo liên kết khóa ngoại,xóa khi có ràng buộc khóa chính ,ngoại
    @JoinColumn(name="category_id", referencedColumnName = "id")
    private Category category;

    public Blog(int id, String title, String content, String author, String date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
    }

    public Blog(int id, String title, String content, String author, String date, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.category = category;
    }

    public Blog() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}