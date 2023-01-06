import java.io.Serializable;

public class Node implements Serializable{
	private String data;
	private Node next;
	
	public Node(String data) {
		this.data = data;
		next = null;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getNext() {
		return next;
	}
}