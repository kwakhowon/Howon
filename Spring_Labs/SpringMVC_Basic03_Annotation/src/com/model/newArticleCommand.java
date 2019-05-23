package com.model;

//DTO(VO)
public class newArticleCommand {
  private int parentId;
  private String title;
  private String content;
  
  public int getParentId() {
    return parentId;
  }
  public void setParentId(int parentId) {
    this.parentId = parentId;
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
  
  @Override
  public String toString() {
    return "newArticleCommand [parentId=" + parentId + ", title=" + title + ", content=" + content + "]";
  }
  
}
