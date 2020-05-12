package models;

import java.util.Objects;

public class News {
    private String content;
    private String writtenBy;
    private int id;
    private int departmentId; //will be used to connect Restaurant to Review (one-to-many)


    public News(String content,String writtenBy,int departmentId){
        this.content=content;
        this.writtenBy=writtenBy;
        this.departmentId=departmentId;
    }

    public String getContent() {
        return content;
    }

    public String getWrittenBy() {
        return writtenBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWrittenBy(String writtenBy) {
        this.writtenBy = writtenBy;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return Objects.equals(content, news.content) &&
                id == news.id &&
                departmentId == news.departmentId &&
                Objects.equals(writtenBy, news.writtenBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, writtenBy,id,departmentId);
    }
}
