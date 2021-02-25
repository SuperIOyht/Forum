package edu.zjut.finalwork.model;

public class commentBean {
	private int id;
	private String author;
	private int forumpostId;
	private String releaseDate;
	private String content;
	private boolean checking;
	public boolean isChecking() {
		return checking;
	}
	public void setChecking(boolean checking) {
		this.checking = checking;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getForumpostId() {
		return forumpostId;
	}
	public void setForumpostId(int forumpostId) {
		this.forumpostId = forumpostId;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
