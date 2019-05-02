package com.edu.bbs;
 
import java.sql.Timestamp;
 
public class BBSDto {
 
    private int articleNumber;
    private String id;
    private String title;
    private String content;
    private int groupId;
    private int depth;
    private int pos;
    private int hit;
    private Timestamp writeDate;
    private String fileName;
    private long commentCount;            // 추가한다.
    
    public int getArticleNumber() {
        return articleNumber;
    }
    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    public int getDepth() {
        return depth;
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }
    public int getPos() {
        return pos;
    }
    public void setPos(int pos) {
        this.pos = pos;
    }
    public int getHit() {
        return hit;
    }
    public void setHit(int hit) {
        this.hit = hit;
    }
    public Timestamp getWriteDate() {
        return writeDate;
    }
    public void setWriteDate(Timestamp writeDate) {
        this.writeDate = writeDate;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public long getCommentCount() {
        return commentCount;
    }
    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }
    
    @Override
    public String toString() {
        return "BBSDto [articleNumber=" + articleNumber + ", id=" + id + ", title=" + title + ", content=" + content
                + ", groupId=" + groupId + ", depth=" + depth + ", pos=" + pos + ", hit=" + hit + ", writeDate="
                + writeDate + ", fileName=" + fileName + ", commentCount=" + commentCount + "]";
    }
 
}
