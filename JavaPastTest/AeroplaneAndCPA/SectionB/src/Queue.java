public class Queue<T> implements QueueInterface<T>{
	
	private Node<T> first;
	private Node<T> last;
	
	public boolean isEmpty() {
		return last == null;
	}
	
	//post: Adds the given item to the queue
	public void enqueue(T item) {
		Node<T> node = new Node<>(item);
		if (first == null) {
			first = node;
			last = node;
			return;
		} else if (first == last) {
			last = node;
			first.setNext(last);
			return;
		}
		last.setNext(node);
		last = node;
	}
	
	//post: Removes and returns the head of the queue. It throws an 
	//      exception if the queue is empty.
	public T dequeue() throws QueueException {
		if (first == null) {throw new QueueException("Empty queue!");}
		if (first == last) {T temp = first.getItem(); first = null; last = null; return temp; }
		T temp = first.getItem();
		first = first.getNext();
		return temp;
	}
}
