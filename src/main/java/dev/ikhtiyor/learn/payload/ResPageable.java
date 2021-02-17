package dev.ikhtiyor.learn.payload;

public class ResPageable {
    private Integer page;
    private Integer size;
    private Integer totalPages;
    private long totalElements;
    private Object object;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public ResPageable() {
    }

    public ResPageable(Integer page, Integer size, Integer totalPages, long totalElements, Object object) {
        this.page = page;
        this.size = size;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.object = object;
    }

    @Override
    public String toString() {
        return "ResPageable{" +
                "page=" + page +
                ", size=" + size +
                ", totalPages=" + totalPages +
                ", totalElements=" + totalElements +
                ", object=" + object +
                '}';
    }
}
