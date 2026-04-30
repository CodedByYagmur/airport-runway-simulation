package Airport;

public class AirportImplementation<T> implements AirportInterface<T> {

    private class Node {
        private T data;
        private Node next;
        
        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
        }
    }
    
    private Node firstNode;
    private Node lastNode;
    
    public AirportImplementation() {
        firstNode = null;
        lastNode = null;
    }
    
    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }
    
    @Override 
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.next = newNode;
        }
        lastNode = newNode;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty (underflow)");
        }
        T front = firstNode.data;   
        firstNode = firstNode.next; 

        if (firstNode == null) {   
            lastNode = null;
        }
        return front;               
    }
    
    @Override
    public int sizeOf() {
        int count = 0;
        Node currentNode = firstNode;

        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }
}//end of class