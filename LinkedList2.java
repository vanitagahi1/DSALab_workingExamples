public class LinkedList2 {
    private Node top;

    public static class Node {
        public int data;
        public Node next;


        public Node(int data) {
            this.data = data;
        }
    }
        public void insertFirst(int data){
            Node n = new Node(data);
            n.next = top;
            top = n;
        }
        public Node deleteFirst(){
            Node temp = top;
            top = top.next;
            return temp;
        }
        public void displayList(){
            Node current = top;
            while(current!= null){
                System.out.println(current.data);
                current = current.next;
            }
        }
    }

class LinkedListStack{
    LinkedList2 li = new LinkedList2();
    public void push(int element){
        li.insertFirst(element);
    }
    public void pop(){
        li.deleteFirst();
    }
    public void displayList(){
        System.out.println(" ");
        li.displayList();
    }
}
class LLStackClient{
    public static void main(String[] args) {
        LinkedListStack st = new LinkedListStack();
       st.push(50);
        st.push(70);
        st.push(190);
        System.out.println("1. Stack after push operation: ");
        st.displayList();
        System.out.println("1. Stack after pop operation: ");
        st.pop();
        st.displayList();
    }
}