package domain;

public class Comment {
private int id;
private String content;
private Person author;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Person getAuthor() {
	return author;
}
public void setAuthor(Person author) {
	this.author = author;
}

}
