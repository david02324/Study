package my.practice.sql.app.entity;

import java.sql.Date;

public class Notice {
    private int id;
    private String title;
    private String writerId;
    private String content;
    private Date regDate;
    private int hit;
    private String files;

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public Notice() {
    }

    public Notice(int id, String title, String writerId, String content, Date regDate, int hit, String files) {
        this.id = id;
        this.title = title;
        this.writerId = writerId;
        this.content = content;
        this.regDate = regDate;
        this.hit = hit;
        this.files = files;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getWriterId() {
        return writerId;
    }

    public String getContent() {
        return content;
    }

    public Date getRegDate() {
        return regDate;
    }

    public int getHit() {
        return hit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }
}
