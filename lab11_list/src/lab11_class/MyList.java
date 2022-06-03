package lab11_class;

public class MyList {

	private ListElem head = null;
	private ListElem tail = null;
	
	public ListElem getHead() {
		return head;
	}
	
	public ListElem getTail() {
		return tail;
	}
	
	public void addToHead(String elem) {
		ListElem node = new ListElem(elem);
		
		if(tail == null) {
			tail = node;
		}else {
			head.prev = node;
		}
		
		node.next = head;
		head = node;
	}
	
	public void addToTail(String elem) {
		ListElem node = new ListElem(elem);
		
		if(head == null) {
			head = node;
		}else {
			tail.next = node;
		}
		
		node.prev = tail;
		tail = node;
	}
	
    public void removeFirst() {
        if (head.next == null) {
            tail = null;
        } else {
            head.next.prev = null;
        }

        head = head.next;
    }

    public void removeLast() {
        if (head.next == null) {
            head = null;
        } else {
            tail.prev.next = null;
        }

        tail = tail.prev;
    }
	
    public void searchByQuery(String elemQuery) {
        ListElem current = head;

        while (!current.elem.equals(elemQuery)) {
            current = current.next;

            if (current == null) {
                return;
            }
        }

        if (current == head) {
            removeFirst();
        } else {
            current.prev.next = current.next;
        }

        if (current == tail) {
            removeLast();
        } else {
            current.next.prev = current.prev;
        }
    }
	
}
