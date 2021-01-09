package com.example.MyBookShopApp.data;

public class Authors {
    private Integer id;
    private String author;
    private String groupId;

    public Authors(){}
    public Authors(String author){
        this.id = 0;
        this.author = author;
        this.groupId = this.author.trim().substring(0,1);
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return  author;
    }
}
