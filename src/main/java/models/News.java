package models;

import java.util.Objects;

public class News {
    private String content;
    private String writtenBy;

    public News(String content,String writtenBy){
        this.content=content;
        this.writtenBy=writtenBy;
    }

    public String getContent() {
        return content;
    }

    public String getWrittenBy() {
        return writtenBy;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWrittenBy(String writtenBy) {
        this.writtenBy = writtenBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return Objects.equals(content, news.content) &&
                Objects.equals(writtenBy, news.writtenBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, writtenBy);
    }
}
