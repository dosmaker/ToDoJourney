import java.io.Serializable;

public class List implements Serializable{
	private Node first;
	private Node last;
	
	public List() {
		first = last = null;
	}
	
	public void Insert(String str) {
		Node n = new Node(str);
		
		if(first == null) {
			first = last = n;
		}else {
			if(str.compareTo(first.getData()) < 0) {
				n.setNext(first);
				first = n;
			}else {
				Node previous = first;
				Node following = first.getNext();
				boolean added = false;
				while(following != null) {
					if(str.compareTo(following.getData()) < 0) {
						n.setNext(following);
						previous.setNext(n);
						added = true;
						break;
					}
					previous = following;
					following = following.getNext();
				}
				if(!added) {
					last.setNext(n);
					last = n;
				}
			}
		}
	}
	
	public void Delete(String str) {
		if(first != null) {
			if(first.getData().equals(str)) {
				first = first.getNext();
				if(first == null) {
					last = null;
				}
			}else {
				Node previous = first;
				Node following = first.getNext();
				while(following != null) {
					if(str.equals(following.getData())) {
						previous.setNext(following.getNext());
						break;
					}
					previous = following;
					following = following.getNext();
				}
				if(previous.getNext() == null) {
					last = previous;
				}
			}
		}
	}
	
	public int Contains(String str) {
		Node n = first;
		int x = 1;
		
		while(n != null) {
			if(str.equals(n.getData())) { return x; }
			n = n.getNext(); x++;
		}
		return -1;
	}
	
	public void ListOut() {
		Node n = first;
		
		System.out.println();
		while(n != null) {
			System.out.print(n.getData() + " ");
			n = n.getNext();
		}
		System.out.println();
	}

	public String ListSearch(int x){
		Node n = first;
		for(int i = 0; i < x; i++){
			n = n.getNext();
		}
		String str = n.getData();
		return str;
	}
}