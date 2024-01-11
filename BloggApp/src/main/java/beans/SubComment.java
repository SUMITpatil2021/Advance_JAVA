package beans;

public class SubComment {
	
	Topic topic;
	Comments comment;
	public SubComment() {
		super();
	}
	public SubComment(Topic topic, Comments comment) {
		super();
		this.topic = topic;
		this.comment = comment;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Comments getComment() {
		return comment;
	}
	public void setComment(Comments comment) {
		this.comment = comment;
	}
	

}
