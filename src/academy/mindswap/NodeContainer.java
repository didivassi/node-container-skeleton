package academy.mindswap;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeContainer<T> implements Iterable<T>{

    private Node<T> head;
    private int length;


    public NodeContainer() {
        head = new Node(null);
    }

    // RETURNS THE NUMBER OF ELEMENTS ADDED TO THE CONTAINER
    public int size() {
        return length;
    }

    // ADDS A NEW ELEMENT TO THE END OF THE CONTAINER
    public void add(T data) {
        Node lastNode=transverseNode(head);
        lastNode.setNext(new Node(data));
        length++;
    }

    // RETURNS THE INDEX OF THE NODE IN WHICH THE SPECIFIED OBJECT IS STORED
    public int indexOf(T data) {
        Node currentNode=head;
        int index=-1;
        while (currentNode.getData()!=data){
            if(currentNode.getNext()==null){
                return -1;
            }
            currentNode=currentNode.getNext();
            index++;
        }
        return index;
    }

    // RECEIVES AN INDEX AND RETURNS THE OBJECT STORED IN THAT NODE
    public T get(int index) {
        Node<T> currentNode=head;
        if(index>=length){return null;}
        for (int i = 0; i <=index ; i++) {
            currentNode=currentNode.getNext();
        }
        return currentNode.getData();
    }

    // REMOVES THE SPECIFIED OBJECT FROM THE CONTAINER
    public boolean remove(T data) {
        Node<T> currentNode=head;
        Node<T> previous = head;
        while (currentNode.getData()!=data){
            if(currentNode.getNext()==null){
                return false;//did not found
            }
            previous=currentNode;
            currentNode=currentNode.getNext();
        }
        previous.setNext(currentNode.getNext());
        length--;
        return true;
    }


    private Node<T> transverseNode(Node<T> tempNode){
        while (tempNode.getNext()!=null){
           return transverseNode(tempNode.getNext());
        }
        return tempNode;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node =head;
            @Override
            public boolean hasNext() {
                return node.getNext()!=null;
            }

            @Override
            public T next() throws NoSuchElementException {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                node=node.getNext();
              //  node.setNext(node.getNext());Stupid Error
                return  node.getData();
            }
        };
    }

    private class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
