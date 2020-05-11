package models;

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
}
