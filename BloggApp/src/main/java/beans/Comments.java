package beans;

public class Comments {
	int cid;
	String text;
	int topicid;
	String uid;
	public Comments() {	
		
	}
	public Comments(int cid, String text, int topicid, String uid) {
		super();
		this.cid = cid;
		this.text = text;
		this.topicid = topicid;
		this.uid = uid;
	}
	public Comments(String text) {
		super();
		this.text=text;

	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getTopicid() {
		return topicid;
	}
	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	

}
