class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }
    
    public void removeNode(int data) {
        if (head == null) {
            return; // list is empty, nothing to remove
        }

        if (head.getData() == data) {
            head = head.getNext(); // remove head node
            return;
        }

        Node prev = head;
        Node curr = head.getNext();

        while (curr != null) {
            if (curr.getData() == data) {
                prev.setNext(curr.getNext()); // remove curr node
                return;
            }
            prev = curr;
            curr = curr.getNext();
        }
    }
    
    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.getData() == data) {
                return true; // found node with data
            }
            current = current.getNext();
        }
        return false; // data not found in any node
    }



    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
    }
    
    public int findMax() {
        if (head == null) {
            return Integer.MIN_VALUE; // return minimum integer value if list is empty
        }

        int max = head.getData();
        Node current = head.getNext();

        while (current != null) {
            if (current.getData() > max) {
                max = current.getData(); // update max if current node's data is greater
            }
            current = current.getNext();
        }

        return max; // return maximum value in list
    }

    public double findAvg() {
        if (head == null) {
            return 0; // return 0 if list is empty
        }

        int sum = 0;
        int count = 0;
        Node current = head;

        while (current != null) {
            sum += current.getData(); // add current node's data to sum
            count++; // increment count
            current = current.getNext();
        }

        return (double) sum / count; // calculate and return average value
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.removeNode(4);
        System.out.println(list.contains(1));
        list.printList();
    }
}
