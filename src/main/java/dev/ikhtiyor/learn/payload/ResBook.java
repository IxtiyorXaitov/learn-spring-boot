package dev.ikhtiyor.learn.payload;

import java.util.Date;

public class ResBook {
    private Integer id;
    private String name;
    private Date publishedDate;
    private Integer pageCount;

    private ResAuthor resAuthor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public ResAuthor getResAuthor() {
        return resAuthor;
    }

    public void setResAuthor(ResAuthor resAuthor) {
        this.resAuthor = resAuthor;
    }

    public ResBook() {
    }

    public ResBook(Integer id, String name, Date publishedDate, Integer pageCount, ResAuthor resAuthor) {
        this.id = id;
        this.name = name;
        this.publishedDate = publishedDate;
        this.pageCount = pageCount;
        this.resAuthor = resAuthor;
    }

    @Override
    public String toString() {
        return "ResBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishedDate=" + publishedDate +
                ", pageCount=" + pageCount +
                ", resAuthor=" + resAuthor +
                '}';
    }
}
