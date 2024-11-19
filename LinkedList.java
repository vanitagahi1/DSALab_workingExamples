public class LinkedList {
    private Node front;
    private Node rear;



    static class Node{
        public int data;
        public Node next;
        public  Node (int data){
            this.data=data;
            this.next=null;
        }
    }
    public boolean isEmpty(){
        return (front==null);
    }
    public void insertLast(int new_data){
        Node new_node = new Node(new_data);
        if (isEmpty())
            front = new_node;
        else rear.next=new_node;
        rear=new_node;
    }
    public int deleteFirst(){
        int temp = front.data;;
        if(front.next == null)
            rear=null;
        front=front.next;
        return temp;
    }
    public void displaylist(){
        System.out.println("===Displaying Elements of DEQ===");
        Node current = front;
        while (current!=null){
            System.out.println(current.data);
            current=current.next;
        }

    }
}
class Queue_2{
    LinkedList llist;

    public Queue_2() {
        llist = new LinkedList(); }

    public boolean isEmpty(){
        return llist.isEmpty();
    }
    public void enqueue (int new_data){
        llist.insertLast (new_data);
    }
    public int deque(){
        return llist.deleteFirst();
    }
    void printQueue() {
        llist.displaylist();
    }
}
class QueueClient {
    public static void main(String[] args) {

    Queue_2 list=new Queue_2();

list.enqueue (10);

list.enqueue (20);

list.enqueue (30);

list.enqueue (40);

list.printQueue();

list.deque();

list.printQueue();

}

}