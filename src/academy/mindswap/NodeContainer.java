package academy.mindswap;

public class NodeContainer {

    private Node head;
    private int length;


    public NodeContainer() {
        head = new Node(null);
    }

    // RETURNS THE NUMBER OF ELEMENTS ADDED TO THE CONTAINER
    public int size() {
        return length;
    }

    // ADDS A NEW ELEMENT TO THE END OF THE CONTAINER
    public void add(Object data) {
        Node lastNode=transverseNode(head,null);
        lastNode.setNext(new Node(data));
        length++;
    }

    // RETURNS THE INDEX OF THE NODE IN WHICH THE SPECIFIED OBJECT IS STORED
    public int indexOf(Object data) {
        Node currentNode=head;
        int index=-1;
        while (currentNode.getData()!=data){
            if(currentNode.getNext()==null){
                return index;
            }
            currentNode=currentNode.getNext();
            index++;
        }
        return index;
    }

    // RECEIVES AN INDEX AND RETURNS THE OBJECT STORED IN THAT NODE
    public Object get(int index) {
        Node currentNode=head;
        if(index>=length){return null;}
        for (int i = 0; i <=index ; i++) {
            currentNode=currentNode.getNext();
        }
        return currentNode.getData();
    }

    // REMOVES THE SPECIFIED OBJECT FROM THE CONTAINER
    public boolean remove(Object data) {

        Node currentNode=head;
        Node previous = head;
        while (currentNode.getData()!=data){
            if(currentNode.getNext()==null){
                return false;//did not found
            }
            if(currentNode.getData()==data){
                break;
            }
            previous=currentNode;
            currentNode=currentNode.getNext();
        }
        previous.setNext(currentNode.getNext());
        length--;
        return true;
    }


    private Node transverseNode(Node tempNode, Object condition){
        while (tempNode.getNext()!=condition){
           return transverseNode(tempNode.getNext(),condition);
        }
        return tempNode;
    }

    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
