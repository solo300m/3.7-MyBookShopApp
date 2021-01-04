package com.example.MyBookShopApp.data;

public class Authors {
    private Integer id;
    private String author;

    public Authors(){}
    public Authors(String author){
        this.id = 0;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + id +
                ", author='" + author + '\'' +
                '}';
    }
}
