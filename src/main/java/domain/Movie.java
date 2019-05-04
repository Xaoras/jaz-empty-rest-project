package domain;
import java.util.List;
public class Movie {
private int id;
private String title;
private List<Comment> comments;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public List<Comment> getComments() {
	return comments;
}
public void setComments(List<Comment> comments) {
	this.comments = comments;
}
public Comment getComment(int id) {
	for(Comment m : comments) {
		if(m.getId()==id)
			return m;
	}
	return null;
}
public boolean delete(Comment m) {
	return comments.remove(m);
}
}
