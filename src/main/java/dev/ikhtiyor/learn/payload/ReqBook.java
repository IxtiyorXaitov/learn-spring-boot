package dev.ikhtiyor.learn.payload;

import dev.ikhtiyor.learn.entity.Author;

import java.util.Date;

public class ReqBook {
    private String name;
    private Date publishedDate;
    private Integer pageCount;
    private Integer authorId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "ReqBook{" +
                "name='" + name + '\'' +
                ", publishedDate=" + publishedDate +
                ", pageCount=" + pageCount +
                ", authorId=" + authorId +
                '}';
    }
}
