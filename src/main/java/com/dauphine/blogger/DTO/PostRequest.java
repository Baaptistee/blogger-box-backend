package com.dauphine.blogger.DTO;

import com.dauphine.blogger.model.Category;

import java.util.Date;
import java.util.UUID;

public class PostRequest {
    private String title;
    private String content;
    private Category category;
    private UUID id;
    private Date createdDate ;


    public PostRequest() {
    }

    public PostRequest(String title, String content, UUID id) {
        this.title = title;
        this.content = content;
        this.id = id;
    }

    public String getName() {
        return title;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setName(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}



